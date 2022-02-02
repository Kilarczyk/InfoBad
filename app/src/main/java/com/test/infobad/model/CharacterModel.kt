package com.test.infobad.model

import android.os.Bundle
import com.google.gson.annotations.SerializedName
import com.test.infobad.model.utils.Constants
import kotlin.text.StringBuilder

data class CharacterModel (
    @SerializedName("id") val id: Int,
    @SerializedName("name") var name: String,
    @SerializedName("birthday") var birthday: String,
    @SerializedName("occupation") var occupation: List<String>,
    @SerializedName("img") var img: String,
    @SerializedName("status") var status: String,
    @SerializedName("nickname") var nickname: String,
    @SerializedName("appearance") var appearance: List<String>,
    @SerializedName("portrayed") var portrayed: String,
    @SerializedName("category") var category: String,
    var quotes: List<QuotesModel> = listOf()
    )
{

    fun getAppearanceToString(): String {
        val appearance = StringBuilder()
        this.appearance.forEach { season ->
            appearance.append("$season, ")
        }
        return appearance.toString()
    }

    fun getQuotesToString(): String {
        val quotes = StringBuilder()
        this.quotes.forEach { quote ->
            quotes.append("$quote" + "\n")
        }
        return quotes.toString()
    }

    fun toBundle(): Bundle {
        return Bundle().apply {
            this.putInt(Constants.EXTRA_ID, id)
            this.putString(Constants.EXTRA_IMG, img)
            this.putString(Constants.EXTRA_PORTRAYED, portrayed)
            this.putString(Constants.EXTRA_NICKNAME, nickname)
            this.putString(Constants.EXTRA_BIRTHDAY, birthday)
            this.putString(Constants.EXTRA_APPEARANCE, getAppearanceToString())
            this.putString(Constants.EXTRA_QUOTES, getQuotesToString())
        }
    }

}