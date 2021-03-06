package com.example.micnjs.RVadapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.micnjs.R
import com.example.micnjs.RVmodels.patientReportsModel
import kotlinx.android.synthetic.main.patient_reports_layout.view.*

class patientReportsAdapter(val reportsList : List<patientReportsModel>) : RecyclerView.Adapter<patientReportsAdapter.ViewHolder>() {
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        var reportsNumber : TextView = itemView.reportsNumber_tV
        var ePatientName : TextView = itemView.expand_reportsNumber_tV
        var eDoctorName : TextView = itemView.expand_doctorName_tV
        var eHospitalName : TextView = itemView.expand_hospitalName_tV
        var linearLayout : LinearLayout = itemView.linearLayout
        var expandableLayout : RelativeLayout = itemView.expandable_layout

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.patient_reports_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return reportsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val reports : patientReportsModel = reportsList[position]
        holder.reportsNumber.text = reports.reportsNumber
        holder.ePatientName.text = reports.reportsNumber
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