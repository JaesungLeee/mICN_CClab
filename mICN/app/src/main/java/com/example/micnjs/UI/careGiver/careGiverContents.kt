package com.example.micnjs.UI.careGiver

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.micnjs.R
import com.example.micnjs.RVadapters.careGiverContentsAdapter
import com.example.micnjs.RVmodels.careGiverContentsModel
import kotlinx.android.synthetic.main.activity_care_giver_contents.*

class careGiverContents : AppCompatActivity() {
    //난수
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_care_giver_contents)

        val cNameList = arrayListOf<careGiverContentsModel>(
            careGiverContentsModel("pdf"),
            careGiverContentsModel("pdf")
        )

        careGiverContents_rV.layoutManager = LinearLayoutManager(this)
        careGiverContents_rV.setHasFixedSize(true)
        careGiverContents_rV.adapter = careGiverContentsAdapter(cNameList)

        downloadFolder_btn.setOnClickListener {
//            openDownloadedFolder()
        }
    }
}