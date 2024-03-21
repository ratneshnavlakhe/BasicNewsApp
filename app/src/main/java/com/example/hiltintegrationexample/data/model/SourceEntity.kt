package com.example.hiltintegrationexample.data.model

import com.google.gson.annotations.SerializedName

data class SourceEntity(
    @SerializedName("sourceId")
    val id: String?,
    @SerializedName("sourceName")
    val name: String?
)