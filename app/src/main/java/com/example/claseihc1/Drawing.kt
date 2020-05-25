package com.example.claseihc1

import android.graphics.Color
import android.os.Bundle
import android.util.DisplayMetrics
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_drawing.*
import yuku.ambilwarna.AmbilWarnaDialog

class Drawing : AppCompatActivity() {

    var nDefaultColor =0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawing)

        nDefaultColor = ContextCompat.getColor(this, R.color.colorPrimary)
        btn_colorpicker.setOnClickListener(){
            openColorPicker()
        }

        val metrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(metrics)
        drawingView.init(metrics)

        btn_pencilMore.setOnClickListener(){
            drawingView.pencilMore()
        }

        btn_pencilLess.setOnClickListener(){
            drawingView.pencilLess()
        }

        btn_eraser.setOnClickListener(){
            drawingView.eraser()
        }
    }

    fun openColorPicker(){
        val colorPicker =
            AmbilWarnaDialog(this, nDefaultColor,object:AmbilWarnaDialog.OnAmbilWarnaListener{
                override fun onCancel(dialog: AmbilWarnaDialog){}
                override fun onOk(dialog: AmbilWarnaDialog, color: Int){
                    nDefaultColor = color
                }
            })
        colorPicker.show()
    }

}