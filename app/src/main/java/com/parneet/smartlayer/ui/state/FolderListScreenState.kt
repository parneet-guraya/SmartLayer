package com.parneet.smartlayer.ui.state

import com.parneet.smartlayer.model.Folder

data class FolderListScreenState(
    val isLoading: Boolean = false,
    val folderList: List<Folder> = listOf(),
    val errorMessage: String = ""
)