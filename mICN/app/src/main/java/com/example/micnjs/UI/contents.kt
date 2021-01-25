package com.example.micnjs.UI

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import com.example.micnjs.R
import com.example.micnjs.adapters.contentsAdapter
import com.example.micnjs.download.checkSDCard
import com.example.micnjs.models.contentsModel
import kotlinx.android.synthetic.main.activity_contents.*
import java.io.File
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
                contentsModel("pdf"),
                contentsModel("pdf")
        )

        contents_rV.layoutManager = LinearLayoutManager(this)
        contents_rV.setHasFixedSize(true)
        contents_rV.adapter = contentsAdapter(cNameList)

        isConnectingToInternet()

        downloadFolder_btn.setOnClickListener {
            openDownloadedFolder()
        }
    }

    private fun openDownloadedFolder() {
        //First check if SD Card is present or not
        if (checkSDCard().isSDCardPresent()) {

            //Get Download Directory File
            val apkStorage = File(Environment.getExternalStorageDirectory().toString() + "/" + "Androhub Downloads")

            //If file is not present then display Toast
            if (!apkStorage.exists()) {
                Toast.makeText(this, "Right now there is no directory. Please download some file first.", Toast.LENGTH_SHORT).show()
            }
            else {
                //If directory is present Open Folder
                /** Note: Directory will open only if there is a app to open directory like File Manager, etc.   */
                val intent = Intent(Intent.ACTION_GET_CONTENT)
                val uri: Uri = Uri.parse(Environment.getExternalStorageDirectory().path.toString() + "/" + "Androhub Downloads")

                intent.setDataAndType(uri, "file/*")
                startActivity(Intent.createChooser(intent, "Open Download Folder"))
            }
        }
        else {
            Toast.makeText(this, "Oops!! There is no SD Card.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun isConnectingToInternet(): Boolean {
        val connectivityManager: ConnectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }
}