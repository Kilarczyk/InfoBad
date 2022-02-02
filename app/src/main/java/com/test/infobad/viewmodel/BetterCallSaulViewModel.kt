package com.test.infobad.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.test.infobad.model.CharacterModel
import com.test.infobad.model.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BetterCallSaulViewModel : ViewModel() {

    private val _listCharsBetterCallSaul = MutableLiveData<List<CharacterModel>>().apply {
        CoroutineScope(Dispatchers.IO).launch {
            this@apply.postValue(Repository().getBetterCalSaulList())
        }
    }
    val listBetterSaul = _listCharsBetterCallSaul

}