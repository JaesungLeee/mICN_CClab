package com.example.micnjs.adapters

import android.content.Context
import android.net.ConnectivityManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import androidx.recyclerview.widget.RecyclerView
import com.example.micnjs.R
import com.example.micnjs.UI.contents
import com.example.micnjs.download.downloadContents
import com.example.micnjs.download.urls
import com.example.micnjs.models.contentsModel
import kotlinx.android.synthetic.main.contents_layout.view.*
import kotlin.coroutines.coroutineContext

class contentsAdapter(val contentsName: ArrayList<contentsModel>) : RecyclerView.Adapter<contentsAdapter.ViewHolder>() {

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(data : contentsModel) {
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
            downloadContents(context = contents().applicationContext, downloadURL = urls().pdfUrl)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contents_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return contentsName.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(contentsName[position])
    }

}