package com.test.infobad.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.test.infobad.databinding.FragmentBreakingBadBinding
import com.test.infobad.model.CharacterModel
import com.test.infobad.model.utils.Constants
import com.test.infobad.model.utils.FragmentsInterface
import com.test.infobad.viewmodel.BreakingBadViewModel

private const val TAG = "BetterCallSaulFragment"

class BreakingBadFragment : Fragment(), FragmentsInterface ,androidx.appcompat.widget.SearchView.OnQueryTextListener {

    private lateinit var breakingBadViewModel: BreakingBadViewModel
    private lateinit var binding: FragmentBreakingBadBinding
    private lateinit var adapter: CharactersListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBreakingBadBinding.inflate(inflater, container, false)

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
        breakingBadViewModel.listBreakingBad.value?.let {
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
        breakingBadViewModel = ViewModelProvider(this).get(BreakingBadViewModel::class.java)
    }

    private fun initRecyclerView() {
        adapter = CharactersListAdapter(listOf(), listener)
        binding.recyclerBreakingBad.layoutManager = GridLayoutManager(this.context, 2)
        binding.recyclerBreakingBad.adapter = adapter
    }

    private fun setSearchView() {
        binding.searchView.setOnQueryTextListener(this)
    }

    private fun setObserverData() {
        breakingBadViewModel.listBreakingBad.observe(viewLifecycleOwner, {charList ->
            adapter.setCharacterList(charList)
        })
    }

    private val listener = object: CharactersListAdapter.OnCustomClickListener {
        override fun clickListener(character: CharacterModel) {
            val intent = Intent(activity, CharacterDetailsActivity::class.java)
            intent.extras?.putBundle(Constants.EXTRA_BUNDLE, character.toBundle())
            startActivity(intent)
        }
    }

    companion object {
        fun newInstance(): BreakingBadFragment = BreakingBadFragment()
    }

}