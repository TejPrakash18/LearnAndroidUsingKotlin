package com.tejdev.gitwrapper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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
        getData()


    }

    fun getData(){
        RetrofitIntance.apiInterface.getData("TejPrakash18").enqueue(object : Callback<DataModel?> {
            override fun onResponse(call: Call<DataModel?>, response: Response<DataModel?>) {
                if (response.isSuccessful){
                    var bio = response.body()?.bio
                    binding.username.text = "Hey $bio"
                }
                else{
                    binding.username.text = "Sorry, there is no response"
                }

            }

            override fun onFailure(call: Call<DataModel?>, t: Throwable) {
               Toast.makeText(this@MainActivity,t.localizedMessage,Toast.LENGTH_LONG).show()
            }
        })

    }
}