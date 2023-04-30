package com.example.android_project.model

import android.widget.Button


data class ItemsViewModel(
    var image: Int,
    var text: String,
    var madartartalom: String,
    var hang:Int,
    var lathatosag: Boolean = false
)
