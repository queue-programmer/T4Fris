package com.example.t4fris

import android.app.Application

class FrisApp: Application() {

    companion object {

        lateinit var application: FrisApp
    }


    override fun onCreate() {
        super.onCreate()

        application = this
    }
}