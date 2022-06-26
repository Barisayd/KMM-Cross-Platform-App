package com.example.ps_eis.android;

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.util.DisplayMetrics
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.camera.core.*
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.content.ContextCompat
import com.example.ps_eis.android.R
import com.example.ps_eis.android.ScanActivity
import com.google.mlkit.vision.barcode.BarcodeScanner
import com.google.mlkit.vision.barcode.BarcodeScanning
import com.google.mlkit.vision.common.InputImage
import java.util.concurrent.ExecutionException
import java.util.concurrent.Executors
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

//@source https://github.com/davit-kamavosyan/Android-QR-code-scanner

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        lateinit var progressBar: ProgressBar
        var i = 0
        var txtView: TextView? = null
        val handler = Handler()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_scan: Button = findViewById(R.id.btn_scan)
        val btn_request: Button = findViewById(R.id.btn_request)
        val btn_codes: Button = findViewById(R.id.btn_codes)

        btn_scan.setOnClickListener{
            val intent = Intent(this, ScanActivity::class.java)
            startActivity(intent)
        }

        btn_codes.setOnClickListener{
            val intent_code = Intent(this, QRCodeListActivity::class.java)
            startActivity(intent_code)
        }


        progressBar = findViewById<ProgressBar>(R.id.progress_Bar) as ProgressBar



        btn_request.setOnClickListener{
            progressBar.visibility = View.VISIBLE
            i = progressBar.progress

            Thread(Runnable {
                // this loop will run until the value of i becomes 99

                    // Update the progress bar and display the current value
                    handler.post(Runnable {
                        progressBar.progress
                        // setting current progress to the textview

                    })
                    try {
                        Thread.sleep(100)
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }



                progressBar.visibility = View.INVISIBLE




            }).start()

            // setting the visibility of the progressbar to invisible
            // or you can use View.GONE instead of invisible
            // View.GONE will remove the progressbar
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)

        }


        }







    }

