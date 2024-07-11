package com.npav.myrvapp.service

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.provider.Settings
import android.util.Log

class MyService : Service() {

    lateinit var mediaPlayer: MediaPlayer

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.e("Inside :", "Service")
        mediaPlayer = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI)
        mediaPlayer.setLooping(true)
        mediaPlayer.start()
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("Inside :", "onDestroy()")
        mediaPlayer.stop()
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }
}