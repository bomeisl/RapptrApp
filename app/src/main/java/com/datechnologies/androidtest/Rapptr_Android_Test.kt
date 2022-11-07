package com.datechnologies.androidtest

import android.app.Application
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class Rapptr_Android_Test: Application() {
    val executorService: ExecutorService = Executors.newFixedThreadPool(2)

}