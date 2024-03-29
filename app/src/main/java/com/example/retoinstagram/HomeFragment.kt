package com.example.retoinstagram

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.retoinstagram.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var homebinding:FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        homebinding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = homebinding.root

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    companion object {

        fun newInstance() = HomeFragment()
    }
}