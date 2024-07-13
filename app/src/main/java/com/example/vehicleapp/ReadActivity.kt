package com.example.vehicleapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.vehicleapp.databinding.ActivityReadBinding

class ReadActivity : AppCompatActivity() {
    private lateinit var binding: ActivityReadBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityReadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        }
    }
}