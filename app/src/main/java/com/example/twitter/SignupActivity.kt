package com.example.twitter

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.twitter.databinding.ActivitySignupBinding
import com.example.twitter.databinding.ActivityStartBinding
import com.google.firebase.auth.FirebaseAuth

class SignupActivity: AppCompatActivity() {
    var mAuth:FirebaseAuth?= null
    lateinit var binding:ActivitySignupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mAuth = FirebaseAuth.getInstance()
        signInAnonymously()
    }
    fun signInAnonymously() {
        mAuth!!.signInAnonymously().addOnCompleteListener(this, {task->
            Log.d("LoginInfo:", task.isSuccessful.toString())
        })
    }

}