package com.example.mybottomsheetstate.library

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.graphics.RectF
import android.os.Build
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.example.mybottomsheetstate.R

/**
 * 作者: LiangKe
 * 时间: 2021/10/6 22:01
 * 描述:
 */
class DrawArc:View {
    private  var  circleRadius=100f  //园半径

    private  var  strokeWidth=5f  //线条宽度

    private  var  pullLeftAndRight=5F

    private val paint = Paint()
    private val path = Path()

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)

    @SuppressLint("CustomViewStyleable", "Recycle")
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ){
        val a=context.obtainStyledAttributes(attrs, R.styleable.BottomNavigationView)
        circleRadius= a.getDimension(R.styleable.BottomNavigationView_circleRadius, 100f)

        strokeWidth=a.getDimension(R.styleable.BottomNavigationView_strokeWidthK,20f)
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
Log.e(width.toString(),height.toString())
    /*    val circleRadius=100  //圆半径

        val strokeWidth=20f*/

        paint.style = Paint.Style.STROKE
        paint.strokeWidth=strokeWidth
        val xWidth = width
        val  half=xWidth/2  //一半
        val left=  half-circleRadius

        val lineCompatible =  strokeWidth/2

        val mRectF = RectF()
        mRectF.left = left  -pullLeftAndRight
        mRectF.top =lineCompatible
        mRectF.right = (circleRadius * 2+left) +pullLeftAndRight
        mRectF.bottom = (circleRadius * 2)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            path.arcTo(mRectF, 180f, 180f, false)
        }

        canvas.drawPath(path, paint)

    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
         val measuredHeight=circleRadius.toInt()

        setMeasuredDimension(widthMeasureSpec, measuredHeight)

    }

}