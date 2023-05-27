package com.miempresa.agenda

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import java.io.Serializable

class AdapterAgenda(val ListAgenda: ArrayList<Agenda>): RecyclerView.Adapter<AdapterAgenda.ViewHolder>(){
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val fName = itemView.findViewById<TextView>(R.id.lblName)
        val fEmail = itemView.findViewById<TextView>(R.id.lblEmail)
        val fPhone = itemView.findViewById<TextView>(R.id.lblPhone)
        val fRemarks = itemView.findViewById<TextView>(R.id.lblRemarks)
        val fDelete = itemView.findViewById<ImageButton>(R.id.btnDelete)
        val fEdit = itemView.findViewById<ImageButton>(R.id.btnEdit)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_user, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return ListAgenda.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val agenda = this.ListAgenda.get(position)
        holder.fName.text = ListAgenda[position].name
        holder.fEmail.text = "Email: ${ListAgenda[position].email}"
        holder.fPhone.text = "Cel. ${ListAgenda[position].phone}"
        holder.fRemarks.text = ListAgenda[position].remarks
        holder.fDelete.setOnClickListener(){
            val builder = AlertDialog.Builder(holder.itemView.context)
            builder.setTitle("Confirmar eliminación")
            builder.setMessage("¿Estás seguro de que deseas eliminar esta agenda?")

            builder.setPositiveButton("Confirmar") { dialog, which ->
                RepositoryAgenda().delete(agenda.id!!)
                this.ListAgenda.removeAt(position)
                notifyItemRemoved(position)
                notifyItemRangeChanged(position, itemCount)
            }
            builder.setNegativeButton("Cancelar", null)
            val dialog = builder.create()
            dialog.show()
        }
        holder.fEdit.setOnClickListener(){
            val AgendaEdit = Intent(holder.itemView.context, AddAgenda::class.java)
            AgendaEdit.putExtra("agenda", RepositoryAgenda().read(agenda.id!!) as Serializable)
            holder.itemView.context.startActivity(AgendaEdit)
        }

        holder.itemView.setOnClickListener(){
            val AgendaView = Intent(holder.itemView.context, DetailAgenda::class.java)
            AgendaView.putExtra("agenda", RepositoryAgenda().read(agenda.id!!) as Serializable)
            holder.itemView.context.startActivity(AgendaView)
        }
    }

}