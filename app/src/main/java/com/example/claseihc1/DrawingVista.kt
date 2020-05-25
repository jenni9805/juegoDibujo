package com.example.claseihc1

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.DisplayMetrics
import android.view.MotionEvent
import android.view.View

class DrawingVista @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private lateinit var nCanvas: Canvas
    private lateinit var rBitmap: Bitmap
    var equis = 50.0f
    var ye = 50.0f
    var accion = ""
    val path = Path()

    fun init(metrics: DisplayMetrics){
        val heigth = metrics.heightPixels
        val with = metrics.widthPixels

        rBitmap = Bitmap.createBitmap(with, heigth,Bitmap.Config.ARGB_8888)
        nCanvas= Canvas(rBitmap)
    }

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.BLUE
        style = Paint.Style.STROKE
        strokeWidth = 15f
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        
        canvas.drawBitmap(rBitmap, 0f, 0f, null)
        
        if(accion.equals("down")){
            path.reset()
            path.moveTo(equis,ye)
        }else if(accion.equals("move")){
            path.lineTo(equis,ye)
            nCanvas.drawPath(path, paint)
        }

        canvas.drawPath(path, paint)

    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        equis = event.x
        ye = event.y

        if (event.action == MotionEvent.ACTION_DOWN){
            accion="down"
        }
        if (event.action == MotionEvent.ACTION_MOVE){
            accion = "move"
        }

        invalidate()

        return true

    }

    fun changeColor(newColor: Int){
        paint.color = newColor
    }

    fun eraser(){
        paint.color = Color.WHITE
    }

    fun clear(){
        nCanvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR)
    }

    fun pencilMore(){
        paint.strokeWidth +=10f
    }

    fun pencilLess(){
        paint.strokeWidth -=10f
    }
}


