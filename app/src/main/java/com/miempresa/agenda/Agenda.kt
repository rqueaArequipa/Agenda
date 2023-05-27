package com.miempresa.agenda

import com.orm.dsl.Table
import java.io.Serializable

//nombres, correo, telefeno y observaciones
@Table
data class Agenda(
    var id: Long? = null,
    var name: String? = null,
    var email: String? = null,
    var phone: String? = null,
    var remarks: String? = null): Serializable {
    constructor(name: String?, email: String?, phone: String?, remarks: String?): this(){
        this.name = name
        this.email = email
        this.phone = phone
        this.remarks = remarks
    }
}