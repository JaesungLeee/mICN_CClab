package com.example.micnjs.download

import android.media.audiofx.EnvironmentalReverb
import android.os.Environment

class checkSDCard {
    fun isSDCardPresent() : Boolean {
        return Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED
    }
}