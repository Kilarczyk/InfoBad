package com.test.infobad.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.test.infobad.databinding.ActivityCharacterDetailsBinding
import com.test.infobad.model.utils.Constants
import com.test.infobad.viewmodel.CharacterDetailsViewModel

private const val TAG = ""

class CharacterDetailsActivity : AppCompatActivity() {

    private lateinit var characterDetailsViewModel: CharacterDetailsViewModel
    private lateinit var binding: ActivityCharacterDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setViewModel()
        setCharDetails()
    }

    private fun setViewModel() {
        characterDetailsViewModel = ViewModelProvider(this).get(CharacterDetailsViewModel::class.java)
    }

    private fun setCharDetails() {
        intent.extras?.let {
            if (it.containsKey(Constants.EXTRA_IMG)) {
                Glide.with(this).load(it.getString(Constants.EXTRA_IMG)).into(binding.charImage)
            }
            if (it.containsKey(Constants.EXTRA_PORTRAYED)){
                binding.charActor.text = it.getString(Constants.EXTRA_PORTRAYED)
            }
            if (it.containsKey(Constants.EXTRA_NICKNAME)){
                binding.charNickname.text = it.getString(Constants.EXTRA_NICKNAME)
            }
            if (it.containsKey(Constants.EXTRA_BIRTHDAY)){
                binding.charBirthday.text = it.getString(Constants.EXTRA_BIRTHDAY)
            }
            if (it.containsKey(Constants.EXTRA_APPEARANCE)){
                binding.charAppearance.text = it.getString(Constants.EXTRA_APPEARANCE)
            }
            if (it.containsKey(Constants.EXTRA_QUOTES)){
                binding.charQuotes.text = it.getString(Constants.EXTRA_QUOTES)
            }
        }
    }

}