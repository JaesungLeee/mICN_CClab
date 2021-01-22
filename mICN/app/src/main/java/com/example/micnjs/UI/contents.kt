package com.example.micnjs.UI

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import com.example.micnjs.R
import com.example.micnjs.adapters.contentsAdapter
import com.example.micnjs.models.contentsModel
import kotlinx.android.synthetic.main.activity_contents.*
import java.util.ArrayList

class contents : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contents)

//        val contentsList : ArrayList<String> = ArrayList()
//
//        for (i in 0..3) {
//            contentsList.add("pdf")
//        }
//        Log.d("CHECK", contentsList.toString())

//        val contentsList : Array<String> = arrayOf("pdf", "doc", "mp3", "mp4")
//        Log.d("CHECK", contentsList.toString())
//
//        val cNameList = arrayListOf<contentsModel>()
//        for (i in contentsList.indices) {
//            cNameList.add(contentsModel(contentsList[i]))
//        }
//        Log.d("CHECK", cNameList.toString())


        val cNameList = arrayListOf<contentsModel>(
                contentsModel("doc"),
                contentsModel("doc"),
                contentsModel("mp4"),
                contentsModel("mp3"),
                contentsModel("hwp"),
                contentsModel("pdf"),
                contentsModel("doc"),
                contentsModel("doc"),
                contentsModel("mp4"),
                contentsModel("mp3"),
                contentsModel("hwp"),
                contentsModel("pdf")
        )

        contents_rV.layoutManager = LinearLayoutManager(this)
        contents_rV.setHasFixedSize(true)
        contents_rV.adapter = contentsAdapter(cNameList)

    }

}