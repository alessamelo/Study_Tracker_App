package com.ale.studysessiontracker

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.gson.Gson



class Login : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.log_in)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

            val etUsername = findViewById<EditText>(R.id.etUsername)
            val etPassword = findViewById<EditText>(R.id.etPassword)


            val btnReturn = findViewById<Button>( R.id.btnReturn)
            val btnContinue = findViewById<Button>( R.id.btnContinue)

        btnReturn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

            btnContinue.setOnClickListener {

                val prefs = getSharedPreferences("my_prefs", MODE_PRIVATE)
                val json = prefs.getString("user_json", null)

                if (json == null){
                    Toast.makeText(this, "No registered user", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener

                } else {
                    val gson = Gson()
                    val savedUser = gson.fromJson(json, User::class.java)

                    val inputUsername = etUsername.text.toString().trim()
                    val inputPassword = etPassword.text.toString().trim()


                    if(inputUsername == savedUser.username &&
                        inputPassword == savedUser.password) {

                        startActivity(Intent(this, TimerDisplay::class.java))

                    } else {
                        Toast.makeText(this, "Wrong credentials", Toast.LENGTH_SHORT).show()
                    }
            }

    }

    }
}