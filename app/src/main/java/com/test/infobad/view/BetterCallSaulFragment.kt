package com.test.infobad.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.test.infobad.databinding.FragmentBetterCallSaulBinding
import com.test.infobad.model.CharacterModel
import com.test.infobad.model.utils.Constants
import com.test.infobad.model.utils.FragmentsInterface
import com.test.infobad.viewmodel.BetterCallSaulViewModel

private const val TAG = "BetterCallSaulFragment"

class BetterCallSaulFragment : Fragment(), FragmentsInterface,androidx.appcompat.widget.SearchView.OnQueryTextListener {

    private lateinit var betterCallSaulViewModel: BetterCallSaulViewModel
    private lateinit var binding: FragmentBetterCallSaulBinding
    private lateinit var adapter: CharactersListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBetterCallSaulBinding.inflate(inflater, container, false)

        setViewModel()
        initRecyclerView()
        setSearchView()
        setObserverData()

        return binding.root
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        TODO("Not yet implemented")
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        betterCallSaulViewModel.listBetterSaul.value?.let {
            return if (newText != null && newText.isNotEmpty()) {
                adapter.setCharacterList(searchList(it, newText))
                true
            } else {
                adapter.setCharacterList(it)
                true
            }
        } ?: return false
    }

    private fun setViewModel() {
        betterCallSaulViewModel = ViewModelProvider(this).get(BetterCallSaulViewModel::class.java)
    }

    private fun initRecyclerView() {
        adapter = CharactersListAdapter(listOf(), listener)
        binding.recyclerBetterSaul.layoutManager = GridLayoutManager(this.context, 2)
        binding.recyclerBetterSaul.adapter = adapter
    }

    private fun setSearchView() {
        binding.searchView.setOnQueryTextListener(this)
    }

    private fun setObserverData() {
        betterCallSaulViewModel.listBetterSaul.observe(viewLifecycleOwner, {charList ->
            adapter.setCharacterList(charList)
        })
    }

    val listener = object: CharactersListAdapter.OnCustomClickListener {
        override fun clickListener(character: CharacterModel) {
            val intent = Intent(activity, CharacterDetailsActivity::class.java)
            intent.extras?.putBundle(Constants.EXTRA_BUNDLE, character.toBundle())
            startActivity(intent)
        }
    }

    companion object {
        fun newInstance(): BetterCallSaulFragment = BetterCallSaulFragment()
    }

}