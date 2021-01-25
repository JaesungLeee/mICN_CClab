package com.example.micnjs.RVadapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.micnjs.R
import com.example.micnjs.RVmodels.myDoctorsModel
import kotlinx.android.synthetic.main.my_doctors_layout.view.*

class myDoctorsAdapter(val doctorList : ArrayList<myDoctorsModel>) : RecyclerView.Adapter<myDoctorsAdapter.ViewHolder>() {
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(data : myDoctorsModel) {
            itemView.doctorsName_tV.text = data.doctorName
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.my_doctors_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return doctorList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(doctorList[position])
    }
}