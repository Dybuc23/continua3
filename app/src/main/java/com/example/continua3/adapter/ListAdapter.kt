package com.example.continua3.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.continua3.R
import com.example.continua3.model.ListModel

class ListAdapter (private val list : List<ListModel>
) : RecyclerView.Adapter<ListAdapter.ListViewHolder>() {
    class ListViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val listName = view.findViewById<TextView>(R.id.list_name)
        val listPrice = view.findViewById<TextView>(R.id.list_price)
        val listImage = view.findViewById<ImageView>(R.id.list_image)
        val listDescription = view.findViewById<TextView>(R.id.list_description)
        fun bindProduct(product: ListModel){
            listName.text = product.name
            listPrice.text = product.price
            listDescription.text = product.description
            Glide.with(itemView.context).load(product.image).into(listImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bindProduct(list.get(position))
    }
}