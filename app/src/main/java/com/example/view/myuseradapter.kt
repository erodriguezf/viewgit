package com.example.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.view.data.User
import kotlinx.android.synthetic.main.row.view.*

class myuseradapter(private val mValue: List<User>,
                     private val mListener: onListInteraction
): RecyclerView.Adapter<myuseradapter.ViewHolder>() {
     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myuseradapter.ViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.row,parent, false)
         return ViewHolder(view)
     }

     override fun getItemCount(): Int = mValue.size



     override fun onBindViewHolder(holder: myuseradapter.ViewHolder, position: Int) {
        val item = mValue[position]
         holder.textView.text = item.nombre

         holder.mView.setOnClickListener {
             mListener?.onListItemInteraction(item)
         }

         holder.button.setOnClickListener {
             mListener?.onListButtonInteraction(item)
         }

     }


     public fun updateData(){
          notifyDataSetChanged()
     }

     inner class ViewHolder (val mView: View  ): RecyclerView.ViewHolder(mView){
         val button: Button = mView.buttonUser
         val textView: TextView = mView.textViewUsername
     }

    interface onListInteraction{
        fun onListItemInteraction(item: User?)
        fun onListButtonInteraction(item: User?)
    }
 }