package com.example.billy.stockwatcher.presentation.view.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.billy.stockwatcher.R

class MainActivity : AppCompatActivity() {
    companion object {
        private const val SHARED_TRANSITION_DURATION = 500L
        private const val FADE_DURATION = 200L
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    private fun addUserListFragment(){

    }
}
