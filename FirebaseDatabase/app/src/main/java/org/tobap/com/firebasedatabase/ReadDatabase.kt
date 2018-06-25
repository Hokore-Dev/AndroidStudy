package org.tobap.com.firebasedatabase

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_read_database.*

class ReadDatabase : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_read_database)

        var userDTO = UserDTO("test", 1, "test1")
        var arrayList = arrayListOf<UserDTO>()

        FirebaseFirestore.getInstance().collection("users").get().addOnSuccessListener {
            querySnapshot ->
            for (item in querySnapshot.documents){
                var userDTO = item.toObject(UserDTO::class.java)
                arrayList.add(userDTO)
            }
            recyclerview_read_database.adapter = ReadRecyclerViewAdapter(arrayList)
            recyclerview_read_database.layoutManager = LinearLayoutManager(this)
        }
    }

    class ReadRecyclerViewAdapter(initList:ArrayList<UserDTO>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
        var list: ArrayList<UserDTO>? = initList

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            var view = LayoutInflater.from(parent!!.context).inflate(R.layout.item_recyclerview, parent, false)
            return CustomViewHolder(view)
        }

        class CustomViewHolder(view: View?) : RecyclerView.ViewHolder(view) {
            var textview_name = view!!.findViewById<TextView>(R.id.textView_name)
            var textview_age = view!!.findViewById<TextView>(R.id.textView_age)
            var textview_city = view!!.findViewById<TextView>(R.id.textView_city)
        }

        override fun getItemCount(): Int {
            return list!!.size
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            var customViewHolder = holder as CustomViewHolder
            customViewHolder.textview_name.text = list!!.get(position).name
            customViewHolder.textview_age.text = list!!.get(position).age.toString()
            customViewHolder.textview_city.text = list!!.get(position).city
        }

    }
}
