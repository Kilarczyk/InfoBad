package com.test.infobad.model

import com.google.gson.annotations.SerializedName

data class QuotesModel(
    @SerializedName("quote_id") val id: Int,
    @SerializedName("quote") var quote: String,
    @SerializedName("author") var author: String,
)
