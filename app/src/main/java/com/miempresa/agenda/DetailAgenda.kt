package com.miempresa.agenda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_add_agenda.*
import kotlinx.android.synthetic.main.activity_detail_agenda.*

class DetailAgenda : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_agenda)

        val received: Bundle? = intent.extras
        if (received != null){
            val agenda = received?.get("agenda") as Agenda
            lblNameDetail.setText(agenda.name)
            lblEmailDetail.setText(agenda.email)
            lblPhoneDetail.setText(agenda.phone)
            lblRemarksDetail.setText(agenda.remarks)
        }
    }
}