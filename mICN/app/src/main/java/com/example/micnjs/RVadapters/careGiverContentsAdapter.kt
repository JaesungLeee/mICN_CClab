package com.example.micnjs.RVadapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.micnjs.R
import com.example.micnjs.RVmodels.careGiverContentsModel
import kotlinx.android.synthetic.main.care_giver_contents_layout.view.*

class careGiverContentsAdapter(val careGiverContentsName : ArrayList<careGiverContentsModel>) : RecyclerView.Adapter<careGiverContentsAdapter.ViewHolder>() {
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        fun bindItems(data : careGiverContentsModel) {
            itemView.contentName_tV.text = data.content
        }

        init {
            itemView.contentsDownload_btn.setOnClickListener { v : View ->
                Toast.makeText(itemView.context, "Download Start", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.care_giver_contents_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return careGiverContentsName.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(careGiverContentsName[position])
    }
}