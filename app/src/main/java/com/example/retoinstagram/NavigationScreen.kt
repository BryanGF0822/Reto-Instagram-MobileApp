package com.example.retoinstagram

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.retoinstagram.databinding.ActivityNavigationScreenBinding
import com.example.retoinstagram.databinding.ActivityNavigationScreenBinding.*
import kotlinx.android.synthetic.main.activity_navigation_screen.*

class NavigationScreen : AppCompatActivity() {

    private lateinit var newHomeFragment: HomeFragment
    private lateinit var newPostFragment: PostFragment
    private lateinit var newProfileFragment: ProfileFragment
    private lateinit var newSearchFragment: SearchFragment
    private lateinit var newMarketFragment: MarketFragment
    private lateinit var binding: ActivityNavigationScreenBinding

    private lateinit var preferences: SharedPreferences

    //private lateinit var toolbar:Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setSupportActionBar(toolbar as Toolbar?)

        preferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)

        newHomeFragment = HomeFragment.newInstance()
        newPostFragment = PostFragment.newInstance()
        newProfileFragment = ProfileFragment.newInstance()
        newSearchFragment = SearchFragment.newInstance()
        newMarketFragment = MarketFragment.newInstance()

        showFragment(newHomeFragment)

        binding.navigator.setOnItemSelectedListener { menuItem->
            if(menuItem.itemId == R.id.homeItem){
                showFragment(newHomeFragment)
            }else if(menuItem.itemId == R.id.searchItem){
                showFragment(newSearchFragment)
            }else if (menuItem.itemId == R.id.postItem){
                showFragment(newPostFragment)
            }else if (menuItem.itemId == R.id.marketItem){
                showFragment(newMarketFragment)
            }else if (menuItem.itemId == R.id.profileItem){
                showFragment(newProfileFragment)
            }
            true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.toolbarmenu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.logout -> {

                val editor: SharedPreferences.Editor = preferences.edit()
                editor.clear()
                editor.apply()

                Toast.makeText(this, "Good Bye!", Toast.LENGTH_LONG).show()

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun showFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, fragment)
        transaction.commit()
    }
}