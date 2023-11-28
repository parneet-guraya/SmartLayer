package com.parneet.smartlayer.ui.service.tokenizer

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import opennlp.tools.tokenize.Tokenizer
import opennlp.tools.tokenize.TokenizerME
import opennlp.tools.tokenize.TokenizerModel
import java.io.InputStream

class OpenNLPTokenizer(private val context: Context) {
    private lateinit var modelInputStream: InputStream
    private lateinit var tokenizer: Tokenizer

    suspend fun initialize() {
        withContext(Dispatchers.IO) {
            modelInputStream = context.assets.open(MODEL_FILE_NAME)
            val model = TokenizerModel(modelInputStream)
            tokenizer = TokenizerME(model)
        }
    }

    suspend fun tokenizeString(string: String): List<String> {
        return withContext(Dispatchers.Default) {
            val tokens = tokenizer.tokenize(string)
            tokens.toList()
        }
    }

    fun release() {
        modelInputStream.close()
    }

    companion object {
    private const val MODEL_FILE_NAME = "opennlp-en-ud-ewt-tokens-1.0-1.9.3.bin"
    }
}