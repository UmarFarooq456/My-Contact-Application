package com.example.a44_mad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AddDataWindow : AppCompatActivity() {
    private lateinit var db: DatabaseReference
    private lateinit var title: TextView
    private  lateinit var desc:TextView
    private lateinit var popup: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_data_window)
    }

    fun realadd(view: View){
        title= findViewById(R.id.popup_add_titile)
        desc=findViewById(R.id.popup_desc)
        popup=findViewById(R.id.popup_add_btn)

        popup.setOnClickListener(){
            val mtitle=title.text.toString()
            val mdesc=desc.text.toString()
            db= FirebaseDatabase.getInstance().getReference("user")
            val user= List(mtitle, mdesc)
            db.child(mtitle).setValue(user).addOnSuccessListener {

                Toast.makeText(this@AddDataWindow, "Data Saved", Toast.LENGTH_SHORT).show();
                val intent = Intent(this@AddDataWindow, Home::class.java)
                startActivity(intent)
            }
                .addOnFailureListener{
                    Toast.makeText(this@AddDataWindow, "Failed, Data Not Saved !!", Toast.LENGTH_SHORT).show();
                }
        }


    }

}