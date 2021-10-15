package com.zntkr.figma

import android.graphics.Shader

import android.util.Log

import android.widget.TextView
import java.lang.Exception
import android.graphics.LinearGradient as GraphicsLinearGradient
import android.graphics.LinearGradient as LinearGradient1


object Tvg {
    /**
     * Changes the textview's color to gradient
     *
     * @param tv TextView to change the color
     * @param startColor first color of gradient
     * @param endColor end color of gradient
     */
    fun change(tv: TextView, startColor: Int, endColor: Int) {
        tv.setTextColor(startColor)
        val textShader: Shader = LinearGradient1(
            0,
            0,
            tv.paint.measureText(tv.text.toString()),
            tv.textSize,
            intArrayOf(startColor, endColor),
            floatArrayOf(0f, 1f),
            Shader.TileMode.CLAMP
        )
        tv.paint.shader = textShader
    }

    /**
     * Changes the textview's color to gradient
     *
     * @param tv TextView to change the color
     * @param colors arrays of multiple colors to create the gradient
     */
    fun change(tv: TextView, colors: IntArray) {
        try {
            tv.setTextColor(colors[0])
            val textShader: Shader = LinearGradient1(
                0, 0, tv.paint.measureText(tv.text.toString()), tv.textSize,
                colors,
                null, Shader.TileMode.CLAMP
            )
            tv.paint.shader = textShader
        } catch (e: Exception) {
            Log.e(Tvg::class.java.simpleName, e.toString())
        }
    }

    /**
     * Changes the list of textview's color to gradient
     *
     * @param tvs List of Textviews which are need to be changed
     * @param colors arrays of multiple colors to create the gradient
     */
    fun change(tvs: List<TextView>, colors: IntArray) {
        try {
            for (tv in tvs) {
                tv.setTextColor(colors[0])
                val textShader: Shader = LinearGradient1(
                    0, 0, tv.paint.measureText(tv.text.toString()), tv.textSize,
                    colors,
                    null, Shader.TileMode.CLAMP
                )
                tv.paint.shader = textShader
            }
        } catch (e: Exception) {
            Log.e(Tvg::class.java.simpleName, e.toString())
        }
    }

    /**
     * Changes the list of textview's color to gradient
     *
     * @param tvs List of Textviews which are need to be changed
     * @param startColor first color of gradient
     * @param endColor end color of gradient
     */
    fun change(tvs: List<TextView>, startColor: Int, endColor: Int) {
        try {
            for (tv in tvs) {
                tv.setTextColor(startColor)
                val textShader: Shader = LinearGradient1(
                    0,
                    0,
                    tv.paint.measureText(tv.text.toString()),
                    tv.textSize,
                    intArrayOf(startColor, endColor),
                    floatArrayOf(0f, 1f),
                    Shader.TileMode.CLAMP
                )
                tv.paint.shader = textShader
            }
        } catch (e: Exception) {
            Log.e(Tvg::class.java.simpleName, e.toString())
        }
    }
}