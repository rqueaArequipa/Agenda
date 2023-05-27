package com.miempresa.agenda

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_agenda.*
import kotlinx.android.synthetic.main.activity_main.*

class AddAgenda : AppCompatActivity() {
    var edit: Boolean = false
    var id: Long = -1
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_agenda)

        btnAddAgenda.setOnClickListener(){
            val name = txtname.text.toString()
            val email = txtmail.text.toString()
            val phone = txtphone.text.toString()
            val remarks = txtremarks.text.toString()

            if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || remarks.isEmpty()){
                Toast.makeText(this, "Algunos campos estan vacios", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (edit){
                RepositoryAgenda().update(id, name, email, phone, remarks)
            }else{
                RepositoryAgenda().add(name, email, phone, remarks)
            }
            finish()
            //Toast.makeText(this, "Datos guardados ${RepositoryAgenda().list().size}", Toast.LENGTH_SHORT).show()
        }

        val received: Bundle? = intent.extras
        if (received != null){
            val agenda = received?.get("agenda") as Agenda
            edit = true
            id = agenda.id!!
            txtname.setText(agenda.name)
            txtmail.setText(agenda.email)
            txtphone.setText(agenda.phone)
            txtremarks.setText(agenda.remarks)
            lblTitleEdit.setText("Editar Agenda")
            btnAddAgenda.setText("Actualizar")
        }
    }
}