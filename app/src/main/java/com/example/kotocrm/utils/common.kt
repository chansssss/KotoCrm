package com.example.kotocrm.utils

import android.R
import android.annotation.TargetApi
import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toast


/**
 * 设置状态栏全透明
 *
 * @param activity 需要设置的activity
 */
fun setTransparent(activity: Activity) {
    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
        return
    }
    transparentStatusBar(activity)
    setRootView(activity)
}

/**
 * 使状态栏透明
 */
@TargetApi(Build.VERSION_CODES.KITKAT)
private fun transparentStatusBar(activity: Activity) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        activity.window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        activity.window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        //需要设置这个flag contentView才能延伸到状态栏
        activity.window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
        //状态栏覆盖在contentView上面，设置透明使contentView的背景透出来
        activity.window.statusBarColor = Color.TRANSPARENT
    } else {
        //让contentView延伸到状态栏并且设置状态栏颜色透明
        activity.window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
    }
}

/**
 * 设置根布局参数
 */
private fun setRootView(activity: Activity) {
    val parent = activity.findViewById<View>(R.id.content) as ViewGroup
    var i = 0
    val count = parent.childCount
    while (i < count) {
        val childView: View = parent.getChildAt(i)
        if (childView is ViewGroup) {
            childView.setFitsSystemWindows(true)
            (childView as ViewGroup).clipToPadding = true
        }
        i++
    }
}


fun ToastMsg(context: Context, text: String) {
    val duration = Toast.LENGTH_SHORT

    val toast = Toast.makeText(context, text, duration)
    toast.show()
}