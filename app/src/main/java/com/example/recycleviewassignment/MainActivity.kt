package com.example.recycleviewassignment

import Adaptors.GmailAdaptor
import Models.Gmail
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recycleView = findViewById<RecyclerView>(R.id.recycle_view)
// this creates a vertical layout Manager
        recycleView.layoutManager = LinearLayoutManager(this)

        val emails = ArrayList<Gmail>()
        val alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".subSequence(0,26)
        for (i in 1..24) {
            emails.add(
                Gmail(alphabet.random() + "ser$i@gmail.com", "$i:00", "content $i: that I want" +
                        " to limit characters of it. Actually, I can do this but the thing that I'm " +
                        "looking for is how to add three dots (...) at the end of string. This one shows" +
                        " the text has continue. This is my XML but there is no dots although it limit " +
                        "my text.")
            )
        }

        val gmailAdaptor = GmailAdaptor(emails)
        recycleView.adapter = gmailAdaptor
    }

    fun starOnClick(view: View) {
        if (view is Button) {
            if (view.text == "selected") {
                view.text = ""
                view.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_star_default, 0, 0, 0)
            } else {
                view.text = "selected"
                view.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_star_selected, 0, 0, 0)
            }
        }
    }

}