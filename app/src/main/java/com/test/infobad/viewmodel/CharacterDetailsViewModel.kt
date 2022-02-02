package com.test.infobad.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.test.infobad.model.CharacterModel

class CharacterDetailsViewModel : ViewModel() {

    private val _listCharDetail = MutableLiveData<CharacterModel>().apply {

    }
    val listCharDetails = _listCharDetail

}