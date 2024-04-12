package com.example.androidapptest


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import com.example.androidapptest.api.RetrofitClient
import com.example.androidapptest.DataModel.Person
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonGetHuman: Button = findViewById(R.id.btn_joke)
        val textViewJoke: TextView = findViewById(R.id.tv_joke)
        val loadingProgressBar: ProgressBar = findViewById(R.id.idLoadingPB)

        buttonGetHuman.setOnClickListener {
            loadingProgressBar.visibility = View.VISIBLE
            RetrofitClient.service.getHumans().enqueue(object : Callback<List<Person>> {
                override fun onResponse(call: Call<List<Person>>, response: Response<List<Person>>) {
                    loadingProgressBar.visibility = View.GONE
                    if (response.isSuccessful) {
                        val humans = response.body()
                        textViewJoke.text = humans?.joinToString(separator = "\n") {
                            "${it.name} is ${it.age} years old."
                        }
                    } else {
                        textViewJoke.text = "Error: ${response.errorBody()?.string()}"
                    }
                }

                override fun onFailure(call: Call<List<Person>>, t: Throwable) {
                    loadingProgressBar.visibility = View.GONE
                    textViewJoke.text = "Failure: ${t.message}"
                }
            })
        }
    }
}