package com.test.infobad.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.test.infobad.R
import com.test.infobad.databinding.ActivityMainBinding

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setOnNavigationItemSelected()
        binding.navView.selectedItemId = R.id.nav_breaking_bad
    }

    private fun setOnNavigationItemSelected(){
        binding.navView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_breaking_bad -> {
                    val breakingBadFragment = BreakingBadFragment.newInstance()
                    openFragment(breakingBadFragment)
                    return@setOnItemSelectedListener true
                }
                R.id.nav_better_call_saul -> {
                    val betterCallSaulFragment = BetterCallSaulFragment.newInstance()
                    openFragment(betterCallSaulFragment)
                    return@setOnItemSelectedListener true
                }
            }
            false
        }
    }

    private fun openFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            this.replace(R.id.container, fragment)
            this.addToBackStack(null)
            this.commit()
        }
    }

}