package com.miempresa.agenda

import com.orm.SugarRecord

class RepositoryAgenda {
    fun add(name: String, email: String, phone: String, remarks: String){
        SugarRecord.save(Agenda(name, email, phone, remarks))
    }

    fun list(): List<Agenda>{
        return SugarRecord.listAll(Agenda::class.java)
    }

    fun delete(id: Long){
        SugarRecord.delete(SugarRecord.findById(Agenda::class.java, id))
    }

    fun read(id: Long): Agenda{
        return SugarRecord.findById(Agenda::class.java, id)
    }

    fun update(id: Long, name: String, email: String, phone: String, remarks: String){
        val agenda: Agenda = SugarRecord.findById(Agenda::class.java, id)
        agenda.name = name
        agenda.email = email
        agenda.phone = phone
        agenda.remarks = remarks
        SugarRecord.save(agenda)
    }
}