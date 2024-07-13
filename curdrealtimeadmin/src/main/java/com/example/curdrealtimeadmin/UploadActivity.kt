package com.example.curdrealtimeadmin

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.curdrealtimeadmin.databinding.ActivityUploadBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class UploadActivity : AppCompatActivity() {

    private lateinit var binding:ActivityUploadBinding
    private lateinit var databaseReference:DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityUploadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener{
            val vehicleNumber=binding.editTextVehicleNumber.text.toString()
            val ownerName=binding.editTextOwnerName.text.toString()
            val  vehicleBrand=binding.editTextVehicleBrand.text.toString()
            val  vehicleRto=binding.editTextVehicleRto.text.toString()

            databaseReference=FirebaseDatabase.getInstance().getReference("Vehicle information")
            val dataClass=DataClass(ownerName,vehicleBrand,vehicleRto,vehicleNumber)
            databaseReference.child(vehicleNumber).setValue(dataClass).addOnSuccessListener {
                binding.editTextOwnerName.text.clear()
                binding.editTextVehicleRto.text.clear()
                binding.editTextVehicleNumber.text.clear()
                binding.editTextVehicleBrand.text.clear()

                Toast.makeText(this,"Saved",Toast.LENGTH_SHORT).show()
                startActivity  (Intent(this@UploadActivity,MainActivity::class.java))
                finish()
           }.addOnFailureListener{
                Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()

            }



        }

        }
    }
