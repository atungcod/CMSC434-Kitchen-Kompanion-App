package com.example.kitchenkompanion

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

class PieChartView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val textPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.BLACK
        textSize = 40f
        textAlign = Paint.Align.CENTER
        isFakeBoldText = true
    }
    private val rectF = RectF()
    private val colors = intArrayOf(
        Color.parseColor("#B05060"),
        Color.parseColor("#CD91E6"),
        Color.parseColor("#EEDD82")
    )
    
    private val labels = arrayOf("300", "500", "100")
    private val data = floatArrayOf(300f, 500f, 100f)
    private val total = data.sum()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val width = width.toFloat()
        val height = height.toFloat()
        val size = if (width < height) width else height
        val margin = 80f
        val left = (width - size) / 2 + margin
        val top = (height - size) / 2 + margin
        val right = left + size - 2 * margin
        val bottom = top + size - 2 * margin
        
        rectF.set(left, top, right, bottom)
        
        var startAngle = -90f
        val centerX = width / 2
        val centerY = height / 2
        val radius = (size - 2 * margin) / 2

        for (i in data.indices) {
            paint.color = colors[i]
            paint.style = Paint.Style.FILL
            val sweepAngle = (data[i] / total) * 360f
            canvas.drawArc(rectF, startAngle, sweepAngle, true, paint)
            
            paint.color = Color.WHITE
            paint.style = Paint.Style.STROKE
            paint.strokeWidth = 4f
            canvas.drawArc(rectF, startAngle, sweepAngle, true, paint)

            val angle = Math.toRadians((startAngle + sweepAngle / 2).toDouble())
            val labelRadius = if (i == 1) radius + 65f else radius + 40f
            var xOffset = 0f
            var yOffset = 0f
            if (i == 1) {
                xOffset = -20f
                yOffset = 10f
            }

            val x = (centerX + labelRadius * Math.cos(angle)).toFloat() + xOffset
            val y = (centerY + labelRadius * Math.sin(angle)).toFloat() + yOffset
            canvas.drawText(labels[i], x, y, textPaint)
            startAngle += sweepAngle
        }
    }
}
