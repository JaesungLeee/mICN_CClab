package com.example.micnjs.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.micnjs.R
import com.example.micnjs.models.myReportsModel
import kotlinx.android.synthetic.main.my_reports_layout.view.*

class myReportsAdapter(val reportsList : List<myReportsModel>) : RecyclerView.Adapter<myReportsAdapter.ViewHolder>() {
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        var patientName : TextView = itemView.patientName_tV
        var ePatientName : TextView = itemView.expand_patientName_tV
        var eDoctorName : TextView = itemView.expand_doctorName_tV
        var eHospitalName : TextView = itemView.expand_hospitalName_tV
        var linearLayout : LinearLayout = itemView.linearLayout
        var expandableLayout : RelativeLayout = itemView.expandable_layout

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.my_reports_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return reportsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val reports : myReportsModel = reportsList[position]
        holder.patientName.text = reports.patientName
        holder.ePatientName.text = reports.patientName
        holder.eDoctorName.text = reports.doctorName
        holder.eHospitalName.text = reports.hospitalName

        val isExpandable : Boolean = reportsList[position].expandable
        holder.expandableLayout.visibility = if (isExpandable) View.VISIBLE else View.GONE

        holder.linearLayout.setOnClickListener {
            val reports = reportsList[position]
            reports.expandable = !reports.expandable
            notifyItemChanged(position)
        }
    }
}