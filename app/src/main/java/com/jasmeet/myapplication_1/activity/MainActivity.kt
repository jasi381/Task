package com.jasmeet.myapplication_1.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jasmeet.myapplication_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)



        setContentView(binding.root)

    }

}