package com.example.androidfundamentals

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class RegisterActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val btnRegister: TextView = findViewById(R.id.btn_register)
        btnRegister.setOnClickListener(this)

        etUsername = findViewById(R.id.et_username)
        etPassword = findViewById(R.id.et_password)
    }

    override fun onClick(view: View) {
        when(view.id) {
            R.id.btn_register -> {
                val bundle = Bundle()
                bundle.putString("username", etUsername.text.toString())
                bundle.putString("password", etPassword.text.toString())

                val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                intent.putExtras(bundle)
                startActivity(intent)
            }
        }
    }
}