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
            when (position) {
                0 -> {
                    tab.text = "Text"
                    tab.setIcon(R.drawable._621521691571183084_128)
                }
                1 -> {
                    tab.text = "LR"
                    // add an icon here
                }
                2 -> {
                    tab.text = "Colors"
                    tab.setIcon(R.drawable._7755608461595340913_128)
                }
                3 -> {
                    tab.text = "Profile"
                    // add icon here
                }
                4 -> {
                    tab.text = "Choices"
                    // add icon here
                }
                5 -> {
                    tab.text = "ToDo"
                    tab.setIcon(R.drawable.checklist)
                }
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
                5 -> TodoFragment()
                else -> PlaceholderFragment.newInstance(position)
            }
        }
    }
}
