package org.tobap.com.firebasedatabase

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_database_create_input.setOnClickListener {
            databaseCreate()
        }
    }

    private fun databaseCreate()
    {
        var userDTO = UserDTO(editText_database_name.text.toString(),
                editText_database_age.text.toString().toInt(),
                editText_database_city.text.toString())

        FirebaseFirestore.getInstance().collection("users").document().set(userDTO)
        .addOnCompleteListener {
             Toast.makeText(this, "데이터 입력이 성공하였습니다", Toast.LENGTH_LONG).show()
        }.addOnFailureListener {
             exception ->
             Toast.makeText(this, exception.toString(), Toast.LENGTH_LONG).show()
        }
    }
}
