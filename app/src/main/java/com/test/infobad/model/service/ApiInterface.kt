package com.test.infobad.model.service

import com.test.infobad.model.CharacterModel
import com.test.infobad.model.QuotesModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {

    @GET("characters?category=Better+Call+Saul")
    suspend fun getBCSList(): Response<List<CharacterModel>>

    @GET("characters?category=Breaking+Bad")
    suspend fun getBBList(): Response<List<CharacterModel>>

    @GET("characters/{char_id}")
    suspend fun getFullChar(@Query("char_id") charId: Int): Response<CharacterModel>

    @GET("quote}")
    suspend fun getCharQuotes(@Query("author") name: String): Response<List<QuotesModel>>
}