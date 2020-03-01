package com.example.view


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.view.data.User
import kotlinx.android.synthetic.main.fragment_mainfragment.view.*

/**
 * A simple [Fragment] subclass.
 */
class mainfragment : Fragment(), UserAdapter.onListInteraction , View.OnClickListener {

    val users = mutableListOf<User>()
    private var adapter : UserAdapter? = null
    var Count: Int = 0

    lateinit var navcontroller: NavController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_mainfragment, container, false)
        adapter = UserAdapter(users,this)


        view.list.layoutManager = LinearLayoutManager(context)
        view.list.adapter = adapter

        view.floatingActionButton.setOnClickListener {
           users.add(User(nombre = " user " + Count))
                 Count++;
                 adapter!!.updateData()

        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navcontroller = Navigation.findNavController(view)

        view.findViewById<TextView>(R.id.textViewUsername).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
       when(v!!.id){

           R.id.textViewUsername ->{
               navcontroller!!.navigate(R.id.action_mainfragment_to_foto)
           }
       }
    }




    override fun onListItemInteraction(item: User?) {
         Log.d("xRecicleView", "onListItemInteraction"+item!!.nombre)
    }

    override fun onListButtonInteraction(item: User?) {
        users.remove(item)
        adapter!!.updateData();

    }



}
