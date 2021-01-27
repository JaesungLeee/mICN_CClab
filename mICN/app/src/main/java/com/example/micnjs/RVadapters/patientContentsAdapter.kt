package com.example.micnjs.RVadapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.micnjs.R
import com.example.micnjs.UI.patient.patientContents
import com.example.micnjs.RVmodels.patientContentsModel
import kotlinx.android.synthetic.main.patient_contents_layout.view.*

class patientContentsAdapter(val patientContentsName: ArrayList<patientContentsModel>) : RecyclerView.Adapter<patientContentsAdapter.ViewHolder>() {

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(data : patientContentsModel) {
            itemView.contentName_tV.text = data.content
        }

        init {
            itemView.contentsDownload_btn.setOnClickListener { v: View ->
//                val position: Int = adapterPosition
//                Toast.makeText(itemView.context, "You Clicked on item #${position + 1}", Toast.LENGTH_SHORT).show()
                Toast.makeText(itemView.context, "Download Start", Toast.LENGTH_SHORT).show()
                downloadPdf()
            }
        }

        private fun downloadPdf() {
            downloadContents(context = patientContents().applicationContext, downloadURL = urls().pdfUrl)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.patient_contents_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return patientContentsName.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(patientContentsName[position])
    }

}