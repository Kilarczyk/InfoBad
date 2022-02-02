package com.test.infobad.model

import com.test.infobad.model.service.RetrofitService

class Repository{


    suspend fun getBreakingBadList() : List<CharacterModel>? {
        val list = RetrofitService.service.getBBList().body()

        list?.forEach { char ->
            RetrofitService.service
                .getCharQuotes(char.name)
                .body()
                ?.let { quotes ->
                char.quotes = quotes
            }
        }
        return list
    }

    suspend fun getBetterCalSaulList() : List<CharacterModel>? {
        val list = RetrofitService.service.getBCSList().body()

        list?.forEach {char ->
            RetrofitService.service
                .getCharQuotes(char.name)
                .body()
                ?.let { quotes ->
                char.quotes = quotes
            }
        }
        return list
    }

}