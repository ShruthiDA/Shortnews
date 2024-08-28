package com.mlsg.shortnews

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ShortNewsApp : Application() {

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "Inside Application's onCreate")
    }

    companion object {
        const val TAG = "ShortNewsApp"
    }
}