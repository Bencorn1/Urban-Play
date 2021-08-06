package com.ayotola.urbanplay

import android.content.Context
import android.view.GestureDetector
import android.view.GestureDetector.SimpleOnGestureListener
import android.view.MotionEvent
import android.view.View
import androidx.recyclerview.widget.RecyclerView


class CustomTouchListener : RecyclerView.OnItemTouchListener  {

    //Gesture detector to intercept the touch events
    var gestureDetector: GestureDetector? = null
    private lateinit var clickListener: onItemClickListener


    fun CustomTouchListener(context: Context?, clickListener: onItemClickListener) {
        this.clickListener = clickListener
        gestureDetector = GestureDetector(context, object : SimpleOnGestureListener() {

            override fun onSingleTapUp(e: MotionEvent): Boolean {
                return true
            }
        })
    }

    override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
        val child: View? = rv.findChildViewUnder(e.x, e.y)
        if (child != null && gestureDetector!!.onTouchEvent(e)) {
            clickListener.onClick(child, rv.getChildLayoutPosition(child))
        }
        return false
    }

    override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {
        TODO("Not yet implemented")
    }

    override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {
        TODO("Not yet implemented")
    }
}