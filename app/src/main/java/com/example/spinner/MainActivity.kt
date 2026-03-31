package com.example.spinner

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var lbl: TextView
    lateinit var spn: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        lbl = findViewById<TextView>(R.id.textView)
        lbl.text = "(nothing seletcted)"
        spn = findViewById<Spinner>(R.id.spinner)

        val arrAdapter = ArrayAdapter.createFromResource(
            this,R.array.myList,android.R.layout.simple_spinner_item)
        arrAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spn.adapter = arrAdapter

        spn.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val lst = getResources().getStringArray(R.array.myList)
                lbl.text = lst[position]            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                lbl.text = "(nothing seletcted)"
            }
        }
    }
}