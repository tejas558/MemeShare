package com.tejas558.memeshare

import android.app.DownloadManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.android.volley.Response
import com.android.volley.toolbox.Volley
import com.android.volley.*
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.bumptech.glide.Glide
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    private lateinit var memeImageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadMeme()
    }

    private fun loadMeme(){

        // Instantiate the RequestQueue.
                val queue = Volley.newRequestQueue(this)
                val url = "https://meme-api.herokuapp.com/gimme"

        // Request a string response from the provided URL.
                val jsonObjectRequest = JsonObjectRequest(
                    Request.Method.GET, url, null,
                    { response ->
                        val url = response.getString("url")
                        Glide.with(this).load(url).into(memeImageView)
                    },
                    {
                        Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG).show()
                    })

        // Add the request to the RequestQueue.
                queue.add(jsonObjectRequest)
    }

    fun shareMeme(view: View) {

    }
    fun nextMeme(view: View) {

    }
}