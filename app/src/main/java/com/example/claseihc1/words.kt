package com.example.claseihc1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_words.*
import java.util.ArrayList

class words : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_words)

        val arrayAchivement = ArrayList<Achivement>()
        arrayAchivement.add(Achivement("Beginner", "Draw 3 words", 100))
        arrayAchivement.add(Achivement("Beginner", "Draw 4 words", 100))
        arrayAchivement.add(Achivement("Beginner", "Draw 5 words", 100))
        arrayAchivement.add(Achivement("Beginner", "Draw 9 words", 100))
        arrayAchivement.add(Achivement("Beginner", "Draw 13 words", 100))
        arrayAchivement.add(Achivement("Beginner", "Draw 20 words", 100))
        arrayAchivement.add(Achivement("Beginner", "Draw 24 words", 100))

        val recycler = recyclerWords

        recycler.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL, false)

        val recycleAdapter = AdaptedAchivement(arrayAchivement)

        recycler.adapter = recycleAdapter
    }
}
