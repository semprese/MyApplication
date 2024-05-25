package com.bignerdranch.android.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.google.android.material.snackbar.Snackbar

class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
    fun onClickDone(view:View){
        Snackbar.make(findViewById(R.id.coordinator), "text", Snackbar.LENGTH_SHORT)
            .setAction("Undo", {
                Toast.makeText(this, "Unded", Toast.LENGTH_SHORT).show()
            }).show()
    }
}