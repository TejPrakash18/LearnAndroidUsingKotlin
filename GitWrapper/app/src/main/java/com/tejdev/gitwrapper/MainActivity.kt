package com.tejdev.gitwrapper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.tejdev.gitwrapper.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityMainBinding.inflate(layoutInflater)
        val view =binding.root
        setContentView(view)
//        getData()
        binding.btnusersearch.setOnClickListener {
            getData()
        }

    }

    private fun getData(){
        val username = binding.userinputid.editableText.toString()
        RetrofitIntance.apiInterface?.getData(username)?.enqueue(object : Callback<DataModel?> {
            override fun onResponse(call: Call<DataModel?>, response: Response<DataModel?>) {
                if (response.isSuccessful){

                    val name = response.body()?.name
                    binding.name.text = "$name"

                    val username = response.body()?.login
                    binding.username.text = "$username"

                    val bio = response.body()?.bio
                    binding.bio.text = "$bio"

                    val url = response.body()?.avatar_url
                    Glide.with(this@MainActivity).load(url).into(binding.profileimg)

                }
                else{
                    binding.name.text = "Sorry, there is no response"
                }

            }

            override fun onFailure(call: Call<DataModel?>, t: Throwable) {
               Toast.makeText(this@MainActivity,t.localizedMessage,Toast.LENGTH_LONG).show()
            }
        })

    }
}