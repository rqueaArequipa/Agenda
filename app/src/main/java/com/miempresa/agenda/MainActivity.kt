package com.miempresa.agenda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        list.layoutManager = LinearLayoutManager(this)

        list.adapter = AdapterAgenda(RepositoryAgenda().list() as ArrayList<Agenda>)

        btnAdd.setOnClickListener(){
            val intent = Intent(this, AddAgenda::class.java)
            startActivity(intent)
        }
    }

    override fun onRestart() {
        super.onRestart()
        list.adapter = AdapterAgenda(RepositoryAgenda().list() as ArrayList<Agenda>)
    }
}