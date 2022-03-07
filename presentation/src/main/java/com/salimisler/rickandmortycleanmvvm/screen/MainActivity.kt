package com.salimisler.rickandmortycleanmvvm.screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.salimisler.rickandmortycleanmvvm.R
import com.salimisler.rickandmortycleanmvvm.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    var binding: ActivityMainBinding? = null
    lateinit var navHostFragmentMainActivity: NavHostFragment
    lateinit var navControllerMainActivity: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        initNav()
    }

    private fun initNav() {
        navHostFragmentMainActivity = supportFragmentManager
            .findFragmentById(R.id.container_main_activity) as NavHostFragment
        navControllerMainActivity = navHostFragmentMainActivity.navController
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}