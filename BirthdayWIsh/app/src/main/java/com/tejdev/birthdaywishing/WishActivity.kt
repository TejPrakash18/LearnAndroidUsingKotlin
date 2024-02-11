package com.tejdev.birthdaywishing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.w3c.dom.Text

class WishActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wish)

        val name = intent.getStringExtra("name")
        val id = findViewById<TextView>(R.id.tvsetdata)
        id.text = "Happy birthday $name"
    }
}