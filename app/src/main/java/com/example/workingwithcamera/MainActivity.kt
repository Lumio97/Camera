package com.example.workingwithcamera

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity() {

    private val PHOTO_REQUEST = 42
    //lateinit позволяет инициализировать переменную позже
//    lateinit var currentPhotoPath: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        takePhoto.setOnClickListener {
            Intent(MediaStore.ACTION_IMAGE_CAPTURE).let { takePhotoIntent ->
                takePhotoIntent.resolveActivity(packageManager)?.let {
                    startActivityForResult(takePhotoIntent, PHOTO_REQUEST)
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PHOTO_REQUEST && resultCode == RESULT_OK) {
            photo.setImageBitmap(data?.extras?.get("data") as Bitmap)

        }
    }

}