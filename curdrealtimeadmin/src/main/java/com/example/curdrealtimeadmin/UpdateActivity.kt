package com.example.curdrealtimeadmin

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.curdrealtimeadmin.databinding.ActivityUpdateBinding
import com.example.curdrealtimeadmin.databinding.ActivityUploadBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class UpdateActivity : AppCompatActivity() {
    private lateinit var binding:ActivityUpdateBinding
    private lateinit var databaseReference: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnUpdate.setOnClickListener()
        {
        updateData(binding.editTextOwnerName.text.toString(),binding.editTextVehicleBrand.text.toString(),binding.editTextVehicleRto.text.toString()
            ,binding.editTextVehicleNumber.text.toString())

        }

    }

    private fun updateData(ownerName:String,vehicleBrand:String,vehicleRto:String,vehicleNumber:String)
    {
        databaseReference=FirebaseDatabase.getInstance().getReference("Vehicle information")
        val vehicleDate= mapOf<String,String>(("ownerName" to ownerName),("vehicleRto" to vehicleRto),"vehicleBrand" to vehicleBrand)
        databaseReference.child(vehicleNumber).updateChildren(vehicleDate).addOnSuccessListener {
            binding.editTextOwnerName.text.clear()
            binding.editTextVehicleRto.text.clear()
            binding.editTextVehicleNumber.text.clear()
            binding.editTextVehicleBrand.text.clear()

            Toast.makeText(this,"updated", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener{
            Toast.makeText(this,"Unable to update", Toast.LENGTH_SHORT).show()
        }

        }

    }
