package com.example.a44_mad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

    fun gotoadd(view: View)
    {
        val intent = Intent(this@Home, AddDataWindow::class.java)
        startActivity(intent)
    }

    fun newsfeed(view: View?){
        val intent =Intent(this, NewUserList::class.java)
        startActivity(intent)
    }
}