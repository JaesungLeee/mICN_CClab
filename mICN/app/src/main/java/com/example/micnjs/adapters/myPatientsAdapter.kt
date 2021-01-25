package com.example.micnjs.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.micnjs.R
import com.example.micnjs.models.myPatientsModel
import kotlinx.android.synthetic.main.my_patients_layout.view.*

class myPatientsAdapter(val patientsList : ArrayList<myPatientsModel>) : RecyclerView.Adapter<myPatientsAdapter.ViewHolder>() {
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(data : myPatientsModel) {
            itemView.patientsName_tV.text = data.patientName
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.my_patients_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return patientsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(patientsList[position])
    }
}