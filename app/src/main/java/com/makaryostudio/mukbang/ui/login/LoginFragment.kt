package com.makaryostudio.mukbang.ui.login

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.makaryostudio.mukbang.R
import com.makaryostudio.mukbang.databinding.LoginFragmentBinding

class LoginFragment : Fragment() {

    private lateinit var binding: LoginFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.login_fragment, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonLogin.setOnClickListener {
            if (binding.editLoginName.text.toString() == "") {
                binding.editLoginName.error = "Nama nggak boleh kosong ya!"
                binding.editLoginName.requestFocus()
            } else {
                val userNameSharedPreferences =
                    requireActivity().getSharedPreferences("username", Context.MODE_PRIVATE)
                with(userNameSharedPreferences.edit()) {
                    putString("username", binding.editLoginName.text.toString())
                    apply()
                }

                findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
                val oldUserSharedPreferences =
                    requireActivity().getSharedPreferences("oldUser", Context.MODE_PRIVATE)
                        ?: return@setOnClickListener
                with(oldUserSharedPreferences.edit()) {
                    putBoolean("oldUser", true)
                    apply()
                }
            }
        }

        binding.textSkip.setOnClickListener {
            if (!oldUser()) {
                Snackbar.make(
                    binding.root,
                    "Kamu belum pernah login sebelumnya",
                    Snackbar.LENGTH_SHORT
                ).show()
            } else {
                findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
            }
        }
    }

    private fun oldUser(): Boolean {
        val sharedPreferences =
            requireActivity().getSharedPreferences("oldUser", Context.MODE_PRIVATE) ?: return false
        return sharedPreferences.getBoolean("oldUser", false)
    }
}