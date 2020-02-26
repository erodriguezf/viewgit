package com.example.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.view.data.User
import com.example.view.databinding.RowBinding

class UserAdapter(private val mValue: List<User>,
                  private val mListener: onListInteraction
): RecyclerView.Adapter<UserAdapter.ViewHolder>() {
     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.ViewHolder {
      // val view = LayoutInflater.from(parent.context).inflate(R.layout.row,parent, false)
        // return ViewHolder(view)
         var binder : RowBinding
         binder = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.row, parent, false)
         return ViewHolder(binder)
     }

     override fun getItemCount(): Int = mValue.size



     override fun onBindViewHolder(holder: UserAdapter.ViewHolder, position: Int) {
        val item = mValue[position]
         holder.mView.user = item
         holder.mView.executePendingBindings()
        /* holder.mView.thelayout.setOnClickListener {
             mListener?.onListButtonInteraction(item)
         }*/

        // holder.textView.text = item.nombre

       /*  holder.mView.setOnClickListener {
             mListener?.onListItemInteraction(item)
         }*/

         holder.mView.buttonUser.setOnClickListener {
             mListener?.onListButtonInteraction(item)
        }

     }


     public fun updateData(){
          notifyDataSetChanged()
     }

     inner class ViewHolder (val mView: RowBinding  ): RecyclerView.ViewHolder(mView.root){

     }

    interface onListInteraction{
        fun onListItemInteraction(item: User?)
        fun onListButtonInteraction(item: User?)
    }
 }