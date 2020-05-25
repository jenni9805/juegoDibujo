package com.example.claseihc1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageSettings.setOnClickListener(){
            val intent = Intent(this, settings::class.java)
            startActivity(intent)
        }


        imageAyuda.setOnClickListener(){
            val intent = Intent(this, Help::class.java)
            startActivity(intent)
        }

        imageLogros.setOnClickListener(){
            val intent = Intent(this, Achivements::class.java)
            startActivity(intent)
        }

        imageWords.setOnClickListener(){
            val intent = Intent(this, words::class.java)
            startActivity(intent)
        }

        btnPlay.setOnClickListener(){
            val intent = Intent(this, Drawing::class.java)
            startActivity(intent)
        }
    }

}
