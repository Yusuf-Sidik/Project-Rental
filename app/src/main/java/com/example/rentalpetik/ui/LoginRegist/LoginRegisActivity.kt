package com.example.rentalpetik.ui.LoginRegist

import SplashScreenFragment
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.rentalpetik.R

class LoginRegisActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login_regis)

        supportActionBar?.hide()
        supportFragmentManager.beginTransaction().replace(R.id.containere, SplashScreenFragment()).commit()

        fun replaceFragment(fragment: Fragment) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.containere, fragment)
                .addToBackStack(null)
                .commit()
        }
}}