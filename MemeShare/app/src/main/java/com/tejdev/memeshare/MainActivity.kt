package com.tejdev.memeshare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest

import com.bumptech.glide.Glide
import com.tejdev.memeshare.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var url:String? = null

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view =binding.root
        setContentView(view)


        loadMeme()


        binding.nextbtn.setOnClickListener{
            loadMeme()
        }

        binding.sharebtn.setOnClickListener {
            val share = Intent(Intent.ACTION_SEND)
            share.putExtra(Intent.EXTRA_TEXT,"Hey Checkout this url $url")
            share.type = "text/plain"
            val chooser = Intent.createChooser(share,"Share this meme using...")
            startActivity(chooser)

        }
    }

    private fun loadMeme(){
        url = "https://meme-api.com/gimme"

        // Request a string response from the provided URL.
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            { response ->
                       val url = response.getString("url")
                Glide.with(this).load(url).into(binding.imageMeme)
            },
            { _ ->
                // TODO: Handle error
            }
        )

// Access the RequestQueue through your singleton class.
        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest)
    }

}