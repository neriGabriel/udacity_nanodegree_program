package com.udacity.shoestore.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container,
            false)
        binding.signin.setOnClickListener {
            navigateToWelcomeScreen()
        }

        binding.newAccount.setOnClickListener {
            navigateToWelcomeScreen()
        }

        return binding.root
    }

    private fun navigateToWelcomeScreen() {
        findNavController().navigate(
                LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
    }
}