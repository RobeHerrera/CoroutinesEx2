package com.example.corrutinesfull.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import com.example.corrutinesfull.R
import com.example.corrutinesfull.ui.main.viewmodel.MainViewModel

class MainActivityView : AppCompatActivity() {
    val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_view)
    }
}