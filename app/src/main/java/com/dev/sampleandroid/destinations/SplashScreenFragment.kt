package com.dev.sampleandroid.destinations

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import com.dev.sampleandroid.R
import com.dev.sampleandroid.data.User

@SuppressLint("CustomSplashScreen")
class SplashScreenFragment : Fragment() {

    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        checkUserThanGoNextScreen()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_splash_screen, container, false)
    }

    private fun checkUserThanGoNextScreen() {

        Handler(Looper.getMainLooper()).postDelayed({
            context?.let {
                navController.navigate(
                    R.id.action_splashScreenFragment_to_loginFragment, null, NavOptions.Builder()
                        .setPopUpTo(
                            R.id.splashScreenFragment,
                            true
                        ).build()
                )
            }
        }, 1000)


    }

    private fun getUserData(): User = User("cengiztoru@gmail.com", "Cengiz", "TORU")

}