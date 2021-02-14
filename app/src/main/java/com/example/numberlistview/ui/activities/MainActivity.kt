package com.example.numberlistview.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.numberlistview.R
import com.example.numberlistview.ui.fragments.MainFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            val mainFragment = MainFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, mainFragment)
                .commitNow()
        }
    }
}