package com.example.kitchenkompanion

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.kitchenkompanion.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ViewPagerAdapter(this)
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Text"
                1 -> "LR"
                2 -> "Colors"
                3 -> "Profile"
                4 -> "Choices"
                5 -> "ToDo"
                else -> null
            }
            
            // Setting icons based on the files you just added
            tab.icon = when (position) {
                0 -> ContextCompat.getDrawable(this, R.drawable._621521691571183084_128)
                2 -> ContextCompat.getDrawable(this, R.drawable._7755608461595340913_128)
                else -> null
            }
        }.attach()
        
        binding.viewPager.setCurrentItem(0, false)
    }

    private inner class ViewPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
        override fun getItemCount(): Int = 6

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> TextFragment()
                2 -> ColorsFragment()
                4 -> ChoicesFragment()
                else -> PlaceholderFragment.newInstance(position)
            }
        }
    }
}
