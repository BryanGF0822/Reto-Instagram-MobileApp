package com.example.retoinstagram

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.retoinstagram.databinding.ActivityNavigationScreenBinding
import com.example.retoinstagram.databinding.ActivityNavigationScreenBinding.*

class NavigationScreen : AppCompatActivity() {

    private lateinit var newHomeFragment: HomeFragment
    private lateinit var newPostFragment: PostFragment
    private lateinit var newProfileFragment: ProfileFragment
    private lateinit var binding: ActivityNavigationScreenBinding


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        newHomeFragment = HomeFragment.newInstance()
        newPostFragment = PostFragment.newInstance()
        newProfileFragment = ProfileFragment.newInstance()

        showFragment(newHomeFragment)

        binding.navigator.setOnItemSelectedListener { menuItem->
            if(menuItem.itemId == R.id.homeItem){
                showFragment(newHomeFragment)
            }else if(menuItem.itemId == R.id.searchItem){
                //showFragment()
            }else if (menuItem.itemId == R.id.postItem){
                showFragment(newPostFragment)
            }else if (menuItem.itemId == R.id.marketItem){
                //showFragment()
            }else if (menuItem.itemId == R.id.profileItem){
                showFragment(newProfileFragment)
            }
            true
        }
    }

    fun showFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, fragment)
        transaction.commit()
    }
}