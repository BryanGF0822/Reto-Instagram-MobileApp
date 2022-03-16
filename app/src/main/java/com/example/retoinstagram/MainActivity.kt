package com.example.retoinstagram

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var navigator:BottomNavigationView
    private lateinit var newHomeFragment: HomeFragment
    private lateinit var newPostFragment: PostFragment
    private lateinit var newProfileFragment: ProfileFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        newHomeFragment = HomeFragment.newInstance()
        newPostFragment = PostFragment.newInstance()
        newProfileFragment = ProfileFragment.newInstance()

        navigator = findViewById(R.id.navigator)

        showFragment(newHomeFragment)

        navigator.setOnItemSelectedListener { menuItem->
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