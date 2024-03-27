package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // Retrieve data from the intent
        val heading = intent.getStringExtra("heading")
        val imageId = intent.getIntExtra("imageId", R.drawable.image1) // Use getIntExtra for retrieving image resource ID
        val content = intent.getStringExtra("newscontent") // Corrected the key name

        // Find views by their IDs
        val headingTextView = findViewById<TextView>(R.id.textView)
        val headingImageView = findViewById<ImageView>(R.id.imageView)
        val contentTextView = findViewById<TextView>(R.id.news_content)

        // Set the retrieved data to the views
        headingTextView.text = heading
        contentTextView.text = content
        headingImageView.setImageResource(imageId)
    }
}
