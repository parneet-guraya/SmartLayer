package com.parneet.smartlayer.data.video.youtube

import okhttp3.OkHttpClient
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import org.schabi.newpipe.extractor.downloader.Downloader
import org.schabi.newpipe.extractor.downloader.Request
import org.schabi.newpipe.extractor.downloader.Response
import org.schabi.newpipe.extractor.exceptions.ReCaptchaException
import java.io.IOException
import java.util.Arrays
import java.util.Objects
import java.util.concurrent.TimeUnit
import java.util.stream.Collectors
import java.util.stream.Stream

class SimpleDownloader private constructor(builder: OkHttpClient.Builder) : Downloader() {
    private val mCookies: MutableMap<String, String>
    private val client: OkHttpClient

    init {
        client = builder
            .readTimeout(
                30,
                TimeUnit.SECONDS
            ) //                .cache(new Cache(new File(context.getExternalCacheDir(), "okhttp"),
            //                        16 * 1024 * 1024))
            .build()
        mCookies = HashMap()
    }

    private fun getCookies(url: String): String {
        val youtubeCookie = if (url.contains(YOUTUBE_DOMAIN)) getCookie(
            YOUTUBE_RESTRICTED_MODE_COOKIE_KEY
        ) else null

        // Recaptcha cookie is always added TODO: not sure if this is necessary
        return Stream.of<String?>(youtubeCookie, getCookie("recaptcha_cookies"))
            .filter { obj: String? ->
                Objects.nonNull(
                    obj
                )
            }
            .flatMap<String?> { cookies: String? ->
                Arrays.stream<String?>(
                    cookies!!.split("; *".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
                )
            }
            .distinct()
            .collect(Collectors.joining("; "))
    }

    private fun getCookie(key: String): String? {
        return mCookies[key]
    }

    /**
     * Get the size of the content that the url is pointing by firing a HEAD request.
     *
     * @param url an url pointing to the content
     * @return the size of the content, in bytes
     */
    @Throws(IOException::class)
    fun getContentLength(url: String?): Long {
        return try {
            val response = head(url)
            response.getHeader("Content-Length")!!.toLong()
        } catch (e: NumberFormatException) {
            throw IOException("Invalid content length", e)
        } catch (e: ReCaptchaException) {
            throw IOException(e)
        }
    }

    @Throws(IOException::class, ReCaptchaException::class)
    override fun execute(request: Request): Response {
        val httpMethod = request.httpMethod()
        val url = request.url()
        val headers = request.headers()
        val dataToSend = request.dataToSend()
        var requestBody: RequestBody? = null
        if (dataToSend != null) {
            requestBody = dataToSend.toRequestBody()
        }
        val requestBuilder: okhttp3.Request.Builder = okhttp3.Request.Builder()
            .method(httpMethod, requestBody).url(url)
            .addHeader("User-Agent", USER_AGENT)
        val cookies = getCookies(url)
        if (!cookies.isEmpty()) {
            requestBuilder.addHeader("Cookie", cookies)
        }
        for ((headerName, headerValueList) in headers) {
            if (headerValueList.size > 1) {
                requestBuilder.removeHeader(headerName)
                for (headerValue in headerValueList) {
                    requestBuilder.addHeader(headerName, headerValue)
                }
            } else if (headerValueList.size == 1) {
                requestBuilder.header(headerName, headerValueList[0])
            }
        }
        val response = client.newCall(requestBuilder.build()).execute()
        if (response.code == 429) {
            response.close()
            throw ReCaptchaException("reCaptcha Challenge requested", url)
        }
        val body = response.body
        var responseBodyToReturn: String? = null
        if (body != null) {
            responseBodyToReturn = body.string()
        }
        val latestUrl = response.request.url.toString()
        return Response(
            response.code, response.message, response.headers.toMultimap(),
            responseBodyToReturn, latestUrl
        )
    }

    companion object {
        const val USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; rv:91.0) Gecko/20100101 Firefox/91.0"
        const val YOUTUBE_RESTRICTED_MODE_COOKIE_KEY = "youtube_restricted_mode_key"
        const val YOUTUBE_DOMAIN = "youtube.com"
        var instance: SimpleDownloader? = null
            private set

        /**
         * It's recommended to call exactly once in the entire lifetime of the application.
         *
         * @param builder if null, default builder will be used
         * @return a new instance of [DownloaderImpl]
         */
        fun init(builder: OkHttpClient.Builder?): SimpleDownloader? {
            instance = SimpleDownloader(
                if (builder != null) builder else OkHttpClient.Builder()
            )
            return instance
        }
    }
}