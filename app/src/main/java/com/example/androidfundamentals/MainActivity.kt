package com.example.androidfundamentals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var tvGreeting: TextView
    private lateinit var tvPassword: TextView
    private lateinit var btnLogout: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnHello: Button = findViewById(R.id.btn_send)
        btnHello.setOnClickListener(this)

        // get data form Parcle
        val username: String? = intent.getParcelableExtra<User>("User")?.username
        val password: String? = intent.getParcelableExtra<User>("User")?.password
        tvGreeting = findViewById(R.id.tv_greeting)
        tvPassword = findViewById(R.id.tv_password)
        tvGreeting.text = "Halo $username!"
        tvPassword.text = "ingat, password anda adalah $password"

        btnLogout = findViewById(R.id.btn_logout)
        btnLogout.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_send -> {
                val intent = Intent()
                intent.action = Intent.ACTION_SEND
                intent.putExtra(Intent.EXTRA_TEMPLATE, "Halo aku sedang belajar!")
                intent.type = "text/plain"
                startActivity(intent)
            }

            R.id.btn_logout -> {
                val intent = Intent()
                intent.putExtra("history", "anda sudah login!")
                setResult(RESULT_OK, intent)
                finish()
            }
        }
    }
}