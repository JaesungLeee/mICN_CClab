package com.example.micnjs.UI.careGiver.contents

import android.Manifest
import android.app.DownloadManager
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.Toast
import com.example.micnjs.R
import com.example.micnjs.UI.careGiver.downloadFolder
import com.example.micnjs.download.urls
import kotlinx.android.synthetic.main.activity_server2_contents.*

class server2Contents : AppCompatActivity() {

    private val STORAGE_PERMISSOIN_CODE: Int = 1000

    var url = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_server2_contents)

        buttonClickListner()

    }

    private fun buttonClickListner() {
        s2c1Download_btn.setOnClickListener {
            url = urls().pdfUrl
            checkVersion(url)
        }

        s2c2Download_btn.setOnClickListener {
            url = urls().videoUrl
            checkVersion(url)
        }

        downloadFolder_btn.setOnClickListener {
            var intent = Intent(this, downloadFolder::class.java)
            startActivity(intent)
        }

        moveBack_btn.setOnClickListener {
            finish()
        }
    }

    private fun checkVersion(url : String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                requestPermissions(arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), STORAGE_PERMISSOIN_CODE)

            }
            else {
                startDownloading(url)

            }
        }
        else {
            startDownloading(url)
        }
    }

    private fun startDownloading(url:String) {

        val request = DownloadManager.Request(Uri.parse(url))
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI or DownloadManager.Request.NETWORK_MOBILE)
                .setTitle("Download")
                .setDescription("The file is downloading..")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
                .setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "${System.currentTimeMillis()}")
                .allowScanningByMediaScanner()

        val manager = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
        manager.enqueue(request)

    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when(requestCode) {
            STORAGE_PERMISSOIN_CODE -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    startDownloading(url)
                }
                else {
                    Toast.makeText(this, "Permission denied", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}