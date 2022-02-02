package com.test.infobad.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.test.infobad.model.CharacterModel
import com.test.infobad.model.Repository
import kotlinx.coroutines.*

class BreakingBadViewModel : ViewModel() {

    private val _listCharsBreakingBad = MutableLiveData<List<CharacterModel>>().apply {
        CoroutineScope(Dispatchers.IO).launch {
            this@apply.postValue(Repository().getBreakingBadList())
        }
    }

    val listBreakingBad = _listCharsBreakingBad
}