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



class FormActivity : AppCompatActivity() {

    private val gson = Gson()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_form)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.formulary)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val btnReturn = findViewById<Button>( R.id.btnReturn)
        val btnSave = findViewById<Button>(R.id.btnSave)



        btnSave.setOnClickListener {
            val user = buildUserOrNull() ?: return@setOnClickListener
            val json = gson.toJson(user)
            val prefs = getSharedPreferences("my_prefs", MODE_PRIVATE)
            prefs.edit().putString("user_json", json).apply()

            startActivity(Intent(this, TimerDisplay::class.java))

        }


        btnReturn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun buildUserOrNull(): User? {
        val username = findViewById<EditText>(R.id.etUsername).text.toString().trim()
        val name = findViewById<EditText>( R.id.etName).text.toString().trim()
        val password = findViewById<EditText>(R.id.etPassword).text.toString().trim()

        if(username.isEmpty() || name.isEmpty() || password.isEmpty()){
            Toast.makeText(this, "All fields required", Toast.LENGTH_SHORT).show()
            return null
        }

        return User(username, name, password)
    }

}