package com.example.curdrealtimeadmin

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.curdrealtimeadmin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnUpload.setOnClickListener {
            changeActivity(UploadActivity())

        }
        binding.btnUpdate.setOnClickListener()
        {

            changeActivity(UpdateActivity())
        }
        binding.btnDelete.setOnClickListener()
        {
            changeActivity(DeleteActivity())
        }

    }

    private fun changeActivity(activity: AppCompatActivity) {
        startActivity(Intent(this@MainActivity, activity::class.java))
        finish()
    }
}