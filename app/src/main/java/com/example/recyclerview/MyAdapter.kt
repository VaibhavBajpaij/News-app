package com.example.recyclerview

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Adapter class for the RecyclerView
class MyAdapter(private var newsArrayList: ArrayList<News>, private val context: Activity) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    // Listener interface for item click events
    private lateinit var myListener: onItemClickListener

    // Interface for defining item click behavior
    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    // Setter method for setting the item click listener
    fun setItemClickListener(listener: onItemClickListener) {
        myListener = listener
    }

    // Inflate the layout for each item and create a new view holder instance
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.eachitem, parent, false)
        return MyViewHolder(itemView, myListener)
    }

    // Populate each item with data
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = newsArrayList[position]
        holder.hTitle.text = currentItem.heading
        holder.hImage.setImageResource(currentItem.imageResourceId)
    }

    // Return the number of items present in the array
    override fun getItemCount(): Int {
        return newsArrayList.size
    }

    // Define the view holder class
    class MyViewHolder(itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView) {
        val hTitle: TextView = itemView.findViewById(R.id.header_title)
        val hImage: ImageView = itemView.findViewById(R.id.header_image)

        init {
            // Set click listener for each item
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }
}
