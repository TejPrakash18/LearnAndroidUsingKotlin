package com.tejdev.birthdaywishing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.btnview)
        btn.setOnClickListener{
            val name = findViewById<EditText>(R.id.editview).editableText.toString()
            val i = Intent(this, WishActivity::class.java)
            i.putExtra("name", name)
            Toast.makeText(this, "my name is $name", Toast.LENGTH_LONG).show()
            startActivity(i)
        }
    }
}