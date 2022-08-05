package com.dev.sampleandroid.destinations

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.activity.addCallback
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.dev.sampleandroid.R


class LoginFragment : Fragment(), View.OnClickListener {

    private lateinit var savedStateHandle: SavedStateHandle


    private lateinit var navController: NavController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         requireActivity().onBackPressedDispatcher.addCallback(this) {
            activity?.finish()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)


        view.findViewById<Button>(R.id.btnLogin).setOnClickListener{

            Toast.makeText(context, "login berhasil", Toast.LENGTH_SHORT).show()

            val bundle = bundleOf(
                "data1" to "ini data 1",
                "data2" to "ini data 2"
            )

            navController.navigate(
                R.id.action_loginFragment_to_albumsFragment2, bundle, NavOptions.Builder()
                    .setPopUpTo(
                        R.id.loginFragment,
                        true
                    ).build()
            )

        }



        view.findViewById<Button>(R.id.btnSignup).setOnClickListener(this)


    }


    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }


}