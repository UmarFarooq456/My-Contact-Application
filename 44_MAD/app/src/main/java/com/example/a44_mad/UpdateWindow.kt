package com.example.a44_mad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

class UpdateWindow : AppCompatActivity() {
    var dbref= FirebaseDatabase.getInstance().getReference("user")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_window)
    }

    // Update function which I had Commented
    fun updatef(view: View){

        val titleu=findViewById<EditText>(R.id.update_title).toString()
        val descu=findViewById<EditText>(R.id.update_desc).toString()
        val updatebtn=findViewById<Button>(R.id.updatebtn_popup)


        updatebtn.setOnClickListener(){
            updatedata(titleu, descu)
            intent.getStringExtra("title").toString()
            intent.getStringExtra("desc").toString()

        }


    }

 private  fun  updatedata(titleu: String, descu: String) {


     val user = mapOf<String,String>(

         "titleu" to titleu,
         "descu" to descu,

     )


     //dbref.child("user").updateChildren(user).addOnSuccessListener

     dbref.child("user").child("title").updateChildren(user)
         .addOnSuccessListener{

//         titleu.text.clear()
//         descu.text.clear()
//         binding.lastname.text.clear()
//         binding.age.text.clear()
         Toast.makeText(this,"Successfuly Updated",Toast.LENGTH_SHORT).show()


     }.addOnFailureListener{

         Toast.makeText(this,"Failed to Update",Toast.LENGTH_SHORT).show()

     }

}