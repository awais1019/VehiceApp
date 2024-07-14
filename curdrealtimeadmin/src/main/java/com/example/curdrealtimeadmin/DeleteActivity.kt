package com.example.curdrealtimeadmin

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.curdrealtimeadmin.databinding.ActivityDeleteBinding
import com.example.curdrealtimeadmin.databinding.ActivityUpdateBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class DeleteActivity : AppCompatActivity() {
   private lateinit var binding: ActivityDeleteBinding
    private lateinit var databaseReference:DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding= ActivityDeleteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val vehicleNumber=binding.editTextVehicleNumber.text.toString()
        binding.btnDelete.setOnClickListener()
        {
            if (vehicleNumber.isNotEmpty())
          deleteData(vehicleNumber)
            else
                Toast.makeText(this,"Enter vehicle number ", Toast.LENGTH_SHORT).show()

        }
    }

    private fun deleteData(vehicleNumber: String) {
         databaseReference = FirebaseDatabase.getInstance().getReference("Vehicle information")
        databaseReference.child(vehicleNumber).removeValue().addOnSuccessListener {
            binding.editTextVehicleNumber.text.clear()


            Toast.makeText(this,"Deleted", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener{
            Toast.makeText(this,"Unable to delete", Toast.LENGTH_SHORT).show()
        }

    }

    }
