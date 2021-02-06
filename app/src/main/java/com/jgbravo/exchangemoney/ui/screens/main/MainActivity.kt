package com.jgbravo.exchangemoney.ui.screens.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jgbravo.exchangemoney.R
import com.jgbravo.exchangemoney.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}