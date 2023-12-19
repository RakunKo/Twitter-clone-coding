package com.example.twitter

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.twitter.databinding.ActivityStartBinding

class StartActivity: AppCompatActivity()  {
    private lateinit var binding : ActivityStartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginLoginBtn.setOnClickListener {
            //화면전환
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        binding.loginMakeAccountBtn.setOnClickListener {
            //화면전환
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
    }
}