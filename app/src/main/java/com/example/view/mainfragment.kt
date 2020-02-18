package com.example.view


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.view.data.User
import kotlinx.android.synthetic.main.fragment_mainfragment.view.*

/**
 * A simple [Fragment] subclass.
 */
class mainfragment : Fragment(), myuseradapter.onListInteraction {
    val users = mutableListOf<User>()
    private var adapter : myuseradapter? = null
    var Count: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_mainfragment, container, false)
        adapter = myuseradapter(users,this)


        view.list.layoutManager = LinearLayoutManager(context)
        view.list.adapter = adapter

        view.floatingActionButton.setOnClickListener {
           users.add(User(nombre = " user " + Count))
                 Count++;
                 adapter!!.updateData()

        }

        return view
    }

    override fun onListItemInteraction(item: User?) {
         Log.d("xRecicleView", "onListItemInteraction"+item!!.nombre)
    }

    override fun onListButtonInteraction(item: User?) {
        users.remove(item)
        adapter!!.updateData();

    }



}
