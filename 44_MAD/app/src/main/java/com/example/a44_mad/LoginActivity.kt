package com.example.a44_mad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    val ref= FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun loginf(view: View)
    {
        val email=findViewById<EditText>(R.id.login_email)
        val password=findViewById<EditText>(R.id.login_password)
        val loginbtn=findViewById<Button>(R.id.login_btn)

            ref.signInWithEmailAndPassword(

                email.text.toString().trim(),
                password.text.toString().trim())
                .addOnCompleteListener(){
                    if (it.isSuccessful){
                        val intent =Intent(this@LoginActivity, Home::class.java)
                        startActivity(intent)
                        Toast.makeText(this, " Login  Success", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this, " Login Failed, Try Again", Toast.LENGTH_SHORT).show()

                    }
                }
        }

    fun click2(view: View)
    {
        val intent = Intent(this@LoginActivity, MainActivity::class.java)
        startActivity(intent)
    }
}