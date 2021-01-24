package com.example.micnjs.download

import android.content.Context
import android.os.AsyncTask
import android.os.Environment
import android.os.Handler
import android.util.Log
import android.widget.Toast
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL

class downloadContents(context : Context, downloadURL : String) {
    private val context : Context = context
    private var downloadURL = ""
    private var downloadFileName = ""

    private inner class DownloadingContents : AsyncTask<Void?, Void?, Void>() {
        var apkStorage : File? = null
        var outputFile : File? = null

        override fun onPreExecute() {
            super.onPreExecute()
            Toast.makeText(context, "Download Started", Toast.LENGTH_SHORT).show()

        }

        override fun onPostExecute(result: Void?) {
            try {
                if (outputFile != null) {
                    Toast.makeText(context, "Download Completed", Toast.LENGTH_SHORT).show()

                }
                else {
                    Toast.makeText(context, "Download Failed", Toast.LENGTH_SHORT).show()
                    Handler().postDelayed(Runnable {
                        Toast.makeText(context, "Download Again", Toast.LENGTH_SHORT).show()

                    }, 3000)
                    Log.e("POSTDELAYED", "Download Failed")
                }
            }
            catch (e : Exception) {
                e.printStackTrace()

                Toast.makeText(context, "Download Failed", Toast.LENGTH_SHORT).show()
                Handler().postDelayed(Runnable {
                    Toast.makeText(context, "Download Again", Toast.LENGTH_SHORT).show()

                }, 3000)
                Log.e("POSTDELAYED", "Download Failed - " + e.localizedMessage)
            }
            super.onPostExecute(result)
        }

        override fun doInBackground(vararg p0: Void?): Void? {
            try {
                val url = URL(downloadURL)
                val connection : HttpURLConnection = url.openConnection() as HttpURLConnection
                connection.requestMethod = "GET"
                connection.connect()

                if (connection.responseCode != HttpURLConnection.HTTP_OK) {
                    Log.e("HTTPCONNECTION", "HTTP CODE : " + connection.responseCode.toString() + "-" + connection.responseMessage)
                }

                if (checkSDCard().isSDCardPresent()) {
                    apkStorage = File(Environment.getExternalStorageDirectory().toString() + "/" + "mICN Downloads")
                }
                else {
                    Toast.makeText(context, "No SD Card", Toast.LENGTH_SHORT).show()
                }
                if (!apkStorage?.exists()!!) {
                    apkStorage?.mkdir()
                    Log.e("MAKEDIRECTORY", "Directory Created")
                }
                outputFile = File(apkStorage, downloadFileName)

                if (!outputFile!!.exists()) {
                    outputFile!!.createNewFile()
                    Log.e("OUTPUTFILE", "File Created")
                }

                val fos = FileOutputStream(outputFile)
                val inputStream : InputStream = connection.inputStream
                val buffer = ByteArray(1024)
                var initlen = 0

                while (inputStream.read(buffer).also { initlen = it } != -1) {
                    fos.write(buffer, 0, initlen)
                }

                fos.close()
                inputStream.close()
            }
            catch (e : Exception) {
                e.printStackTrace()
                outputFile = null
                Log.e("DOWNLOAD", "Download Error : " + e.message)
            }
            return null
        }
    }

    init {
        this.downloadURL = downloadURL
        downloadFileName = downloadURL.replace("https://jaesungleee.github.io/mICN_WebServer/source/", "")
        Log.e("DOWNLOAD", downloadFileName)

        DownloadingContents().execute()
    }
}