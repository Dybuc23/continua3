package com.example.continua3.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.continua3.R
import com.example.continua3.model.MessageModel

class MessageAdapter(private val list : List<MessageModel>
) : RecyclerView.Adapter<MessageAdapter.MessageViewHolder>() {
    class MessageViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val messageName = view.findViewById<TextView>(R.id.message_name)
        val messageImage = view.findViewById<ImageView>(R.id.message_image)
        val messageDescription = view.findViewById<TextView>(R.id.message_description)
        fun bindProduct(mess: MessageModel){
            messageName.text = mess.name
            messageDescription.text = mess.description
            Glide.with(itemView.context).load(mess.image).into(messageImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        return MessageViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.message_item, parent, false)
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        holder.bindProduct(list.get(position))
    }
}