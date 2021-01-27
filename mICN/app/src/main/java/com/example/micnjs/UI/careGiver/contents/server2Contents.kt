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
            url = "https://conferences.sigcomm.org/co-next/2009/papers/Jacobson.pdf"
            checkVersion(url)
        }

        s2c2Download_btn.setOnClickListener {
            url = "https://redirector.googlevideo.com/videoplayback?expire=1611762781&ei=_TcRYKeAFJm6kwauo5DgDQ&ip=107.161.26.235&id=o-AMH7vFQQXyfTOPrxiOKTzQcxWSE9BwM387U9zxl0VEM6&itag=18&source=youtube&requiressl=yes&mh=K5&mm=31%2C26&mn=sn-a5meknee%2Csn-q4fl6ner&ms=au%2Conr&mv=m&mvi=1&pl=25&initcwndbps=3723750&vprv=1&mime=video%2Fmp4&ns=0yd4CrE-eLwIh5UdjN1wtCgF&gir=yes&clen=19059530&ratebypass=yes&dur=272.393&lmt=1591915208209871&mt=1611740913&fvip=1&c=WEB&txp=6216222&n=htOedDSdBsiidd_AR-f2&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cvprv%2Cmime%2Cns%2Cgir%2Cclen%2Cratebypass%2Cdur%2Clmt&sig=AOq0QJ8wRQIhAKMyM4CJ7pQWGCtlBFaILXRzcA5xWKVy-W9JMQhUQgs0AiAYxbr-WjfRLzMudDlR-7wuoPZjrfc2O2RZpPEJwbdkew%3D%3D&lsparams=mh%2Cmm%2Cmn%2Cms%2Cmv%2Cmvi%2Cpl%2Cinitcwndbps&lsig=AG3C_xAwRQIhAPgb93QeDaUlLyU6V5zycU4Fi0VaCrFYJ-v7o3VskYokAiB6bRfygiTc50IcZ6SaJ80-j2TRRPM5v3mNSUU5YMll2g%3D%3D&title=sdasd"
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