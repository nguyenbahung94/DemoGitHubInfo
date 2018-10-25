package com.example.billy.stockwatcher.presentation.view

import android.app.Activity
import android.media.Image
import android.os.Build
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.billy.stockwatcher.CustomApplication
import java.time.Duration

fun ViewGroup.inflate(layoutRes: Int): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, false)
}

fun ImageView.loadUrl(url: String) {
    Glide.with(context).load(url).into(this)
}

fun isLollipopOrAbove(func: () -> Unit) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        func()
    }
}

fun Activity.shortToast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}

fun Fragment.shortToast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(context, message, duration).show()
}

val Activity.customApplication: CustomApplication
    get() = application as CustomApplication

val Fragment.customApplication: CustomApplication
    get() = activity?.application as CustomApplication
