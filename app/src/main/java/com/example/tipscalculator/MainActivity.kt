package com.example.tipscalculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.tipscalculator.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import java.security.KeyStore.TrustedCertificateEntry

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var percentage: Int = 0

        binding.Option1.setOnCheckedChangeListener { _, isChecked ->
            println("Naldo Option one:$isChecked")
            if (isChecked) {
                percentage = 10
            }
        }

        binding.Option2.setOnCheckedChangeListener { _, isChecked ->
            println("Naldo Option two:$isChecked")
            if (isChecked) {
                percentage = 15
            }
        }

        binding.Option3.setOnCheckedChangeListener { _, isChecked ->
            println("Naldo Option three:$isChecked")
            if (isChecked) {
                percentage = 20
            }
        }

        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.Sharing_People,
            android.R.layout.simple_spinner_item
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.SharingPeople.adapter = adapter

        var numOfPeopleSelected = 0

        binding.SharingPeople.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {

                override fun onItemSelected(
                    p0: AdapterView<*>?,
                    p1: View?,
                    p2: Int,
                    p3: Long
                ) {
                    numOfPeopleSelected = p2
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                }
            }

        binding.btnNext.setOnClickListener {
            val Totaltabletemp = binding.TieTotal.text

            if (Totaltabletemp?.isEmpty() == true
                ) {
                Snackbar
                    .make(binding.TieTotal, "Fill in the blank space", Snackbar.LENGTH_LONG)
                    .show()
            } else  {
                val TotalTable: Float = binding.TieTotal.toString().toFloat()
                val nPeople: Int = numOfPeopleSelected

                val Totalwithouttips = TotalTable / nPeople
                val Tips = Totalwithouttips * percentage / 100
                val TotalwithTips = Totalwithouttips + Tips
                println("Naldo1 " + TotalwithTips)
                    }
            }

        binding.btnClean.setOnClickListener {
            binding.TieTotal.setText("")
            binding.Option1.isChecked = false
            binding.Option2.isChecked = false
            binding.Option3.isChecked = false
            }
         }
    }