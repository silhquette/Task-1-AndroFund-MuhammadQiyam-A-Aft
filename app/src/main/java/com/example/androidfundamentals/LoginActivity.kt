package com.example.androidfundamentals

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var tvHistory: TextView

    val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data: Intent? = result.data
            val returnString: String? = data?.getStringExtra("history")
            tvHistory.text = returnString
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        tvHistory = findViewById(R.id.loginHistory)

        val btnToRegister: TextView = findViewById(R.id.btn_to_register)
        btnToRegister.setOnClickListener(this)

        val btnLogin: Button = findViewById(R.id.btn_login)
        btnLogin.setOnClickListener(this)

        etUsername = findViewById(R.id.et_username)
        etPassword = findViewById(R.id.et_password)

        // unpack Bundle
        val bundle = intent.extras
        if (bundle != null) {
            etUsername.setText(bundle.getString("username"))
            etPassword.setText(bundle.getString("password"))
        }
    }

    override fun onClick(view: View) {
        when(view.id) {
            R.id.btn_to_register -> {
                val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
                startActivity(intent)
            }

            R.id.btn_login -> {
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                intent.putExtra("User", User(etUsername.text.toString(), etPassword.text.toString()))
                resultLauncher.launch(intent)
            }
        }
    }
}