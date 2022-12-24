package com.example.presentaion.screens.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.example.presentaion.R
import com.example.presentaion.databinding.ActivityMainBinding
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.androidx.AppNavigator
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : FragmentActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModel()
    private val navigator = AppNavigator(this, R.id.container)
    private val navigatorHolder: NavigatorHolder by inject()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel
    }


    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }


    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

}