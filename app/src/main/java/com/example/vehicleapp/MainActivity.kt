package com.example.vehicleapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.vehicleapp.databinding.ActivityMainBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private lateinit var databaseReference:DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnSearch.setOnClickListener{

            val vehicleNumber:String=binding.editTextSearchBox.text.toString()
            if(vehicleNumber.isNotEmpty())
            readData(vehicleNumber)
            else
                Toast.makeText(this,"Please enter vehicle number",Toast.LENGTH_SHORT).show()
        }



    }
   private fun readData(vehicleNumber:String)
    {
        databaseReference=FirebaseDatabase.getInstance().getReference("Vehicle information")
        databaseReference.child(vehicleNumber).get().addOnSuccessListener {
            if(it.exists())
            {
                binding.editTextSearchBox.text.clear()
                binding.textViewOwnerName.text=it.child("ownerName").value.toString()
                binding.textViewVehicleNumber.text=it.child("vehicleNumber").value.toString()
                binding.textViewVehiclebrand.text=it.child("vehicleBrand").value.toString()
                binding.textViewVehicleRto.text=it.child("vehicleRto").value.toString()
            }
            else
            {
                Toast.makeText(this,"Vehicle number does not exits",Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener()
        {
            Toast.makeText(this,"Something went wrong",Toast.LENGTH_SHORT).show()

        }
    }
}