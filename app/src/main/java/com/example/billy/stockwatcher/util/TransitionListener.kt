package com.example.billy.stockwatcher.util

import android.annotation.SuppressLint
import android.transition.Transition

/*
 By default, all classes in Kotlin are final
* open class can  overridable
* */
@SuppressLint("NewApi")
open class TransitionListener : Transition.TransitionListener {
    override fun onTransitionEnd(p0: Transition?) {
        //do something
    }

    override fun onTransitionResume(p0: Transition?) {
        //do something
    }

    override fun onTransitionPause(p0: Transition?) {
        //do something
    }

    override fun onTransitionCancel(p0: Transition?) {
        //do something
    }

    override fun onTransitionStart(p0: Transition?) {
        //do something
    }

}