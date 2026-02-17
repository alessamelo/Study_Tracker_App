package com.ale.studysessiontracker

import android.content.Intent
import android.content.IntentSender
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.os.CountDownTimer
import android.widget.EditText
import android.widget.TextView
import android.widget.Button
import android.widget.Toast

class TimerDisplay : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_timer_display)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.timer)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etMinutes = findViewById<EditText>(R.id.etSetTimer)
        val btnStartTimer =  findViewById<Button>(R.id.btnStartTimer)
        val tvTimer =  findViewById<TextView>(R.id.tvTimer)
        val btnReturn = findViewById<Button>( R.id.regresar)

        btnStartTimer.setOnClickListener {
            val minutesinput = etMinutes.text.toString()

            if (minutesinput.isEmpty()){
                Toast.makeText(this, "Please set the timer in minutes :)", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }


            val minutes = minutesinput.toLong()
            val millis = minutes * 60 * 1000

            object : CountDownTimer(millis, 1000) {
                override fun onTick(millisUntilFinished: Long){
                    val seconds = millisUntilFinished /1000
                    val mins = seconds /60
                    val secs = seconds %60

                    tvTimer.text = String.format("%02d:%02d", mins, secs)
                }

                override fun onFinish() {
                    tvTimer.text = "00:00"
                }
            }.start()



        }

        btnReturn.setOnClickListener {
            Toast.makeText(this, "Thanks for using this app :)", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}