package com.example.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var newsArrayList: ArrayList<News> // Declaring an ArrayList to hold News objects

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Finding the RecyclerView by its ID in the layout
        recyclerView = findViewById(R.id.recyclerview)

        // Array of image resource IDs
        val newsImageArray = arrayOf(
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4,
            R.drawable.image5,
            R.drawable.image6,
            R.drawable.image7,
            R.drawable.image8,
            R.drawable.image9
        )

        // Array of news headlines
        val newsHeadingArray = arrayOf(
            "Biden's war gaffe, says will airdrop food into 'Ukraine' instead of Gaza",
            "Germany plans for Russian chemical attack on its cities and invasion",
            "AIADMK Dares BJP To Field Top 2 Union Ministers From Tamil Nadu",
            "Rahul Gandhi Targeted by Khalistani Protesters at Cambridge, Could Leave Only after Police Intervened: Sources to News18",
            "Laapataa Ladies Box Office Collection Day 1: Kiran Rao Directorial Off To A Slow Start",
            "OpenAI to Name New Board Members in March: Report",
            "'His game is suited for...': Sourav Ganguly on why Delhi Capitals released Sarfaraz Khan",
            "Former minister Jayant Sinha opts out of Lok Sabha polls, appeals to JP Nadda",
            "Taqleef hogi, hone do: Kapil Dev says 'well done' as BCCI scraps Ishan Kishan, Shreyas Iyer's central contracts"
        )

        // Array of news content
        val newsContentArray = arrayOf(
            getString(R.string.news),
            getString(R.string.news),
            getString(R.string.news),
            getString(R.string.news),
            getString(R.string.news),
            getString(R.string.news),
            getString(R.string.news),
            getString(R.string.news),
            getString(R.string.news)
        )

        // Setting the layout manager for the RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Initializing the ArrayList to hold News objects
        newsArrayList = ArrayList()

        // Looping through the arrays to create News objects
        for (index in newsImageArray.indices) {
            // Creating a News object using the headline, image resource ID, and content
            val news = News(newsHeadingArray[index], newsImageArray[index], newsContentArray[index])

            // Adding the News object to the ArrayList
            newsArrayList.add(news)
        }

        // Setting the adapter for the RecyclerView
        val myAdapter = MyAdapter(newsArrayList, this)
        recyclerView.adapter = myAdapter

        // Setting item click listener for RecyclerView items
        myAdapter.setItemClickListener(object : MyAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {
                // On clicking each item, launch MainActivity2 and pass data via Intent
                val intent = Intent(this@MainActivity, MainActivity2::class.java)
                intent.putExtra("heading", newsArrayList[position].heading)
                intent.putExtra("imageId", newsArrayList[position].imageResourceId)
                intent.putExtra("newscontent", newsArrayList[position].content)
                startActivity(intent)
            }
        })
    }
}
