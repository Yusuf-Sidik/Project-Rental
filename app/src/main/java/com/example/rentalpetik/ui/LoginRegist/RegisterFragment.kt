package com.example.rentalpetik.ui.LoginRegist

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rentalpetik.MainActivity
import com.example.rentalpetik.R
import com.example.rentalpetik.databinding.FragmentRegisterBinding


class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvHaveAccount.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.containere, LoginFragment()).commit()
        }

        binding.btnSubmit.setOnClickListener {
            val sharedPreferences : SharedPreferences = requireActivity().getSharedPreferences("MYPREF", MODE_PRIVATE)
            val newUsername = binding.loginEdtUsername.getText().toString()
            val newName = binding.loginEdtName.getText().toString()
            val newEmail = binding.loginEdtEmail.getText().toString()
            val newPassword = binding.loginEdtPassword.getText().toString()
            val editor : SharedPreferences.Editor = sharedPreferences.edit()

            editor.putString(newUsername + newPassword + "data", newUsername + newName + newEmail + newPassword  )
            editor.putBoolean("isLoggedIn",true)
            editor.apply()

            startActivity(Intent(requireActivity(), MainActivity::class.java))
        }
    }

}