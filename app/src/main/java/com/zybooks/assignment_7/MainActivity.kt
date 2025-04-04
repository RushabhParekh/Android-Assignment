package com.zybooks.assignment_7

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zybooks.assignment_7.ui.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Load MainFragment as the default fragment
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, MainFragment())  // 'fragment_container' is the ID of your fragment container in activity_main.xml
                .commit()
        }
    }
}
