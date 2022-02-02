package com.test.infobad.model.utils

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.test.infobad.model.CharacterModel

interface FragmentsInterface {

    fun hideKeyboard(context: Context, view: View) {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    fun searchList(list: List<CharacterModel>, searchQuery: String?): List<CharacterModel> {
        val auxList = mutableListOf<CharacterModel>()
        searchQuery?.let {
            list.forEach { char ->
                if (char.name.contains(it) ||
                    char.nickname.contains(it) ||
                    char.portrayed.contains(it)
                ) {
                    auxList.add(char)
                }
            }
        }
        return auxList
    }

}