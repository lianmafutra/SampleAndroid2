package com.dev.sampleandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.dev.sampleandroid.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_SampleAndroid);
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        binding.bottomNavView.visibility = View.VISIBLE
        navHostFragment.navController.addOnDestinationChangedListener { _, destination, _ ->
            if(destination.id == R.id.splashScreenFragment || destination.id == R.id.loginFragment) {
                binding.bottomNavView.visibility = View.GONE
            } else {
                binding.bottomNavView.setupWithNavController(navHostFragment.navController)

//                binding.bottomNavView.removeBadge(R.id.albumsFragment) // remove badge
                binding.bottomNavView.getOrCreateBadge(R.id.albumsFragment) // Show badge

                binding.bottomNavView.visibility = View.VISIBLE
            }
        }


        }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.nav_host_fragment)
        return navController.navigateUp()
    }
}