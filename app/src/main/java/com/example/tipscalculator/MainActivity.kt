package com.example.tipscalculator

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tipscalculator.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnNext.setOnClickListener {
            val Totaltabletemp = binding.TieTotalTable.text
            val NumPeopletemp = binding.TieTotalPeople.text
            val Percentagetemp = binding.TiePercentage.text

            if (Totaltabletemp?.isEmpty() == true ||
                NumPeopletemp?.isEmpty() == true ||
                Percentagetemp?.isEmpty() == true
                ) {
                Snackbar
                    .make(binding.TieTotalTable, "Fill in the blank space", Snackbar.LENGTH_LONG)
                    .show()
            } else  {
                val TotalTable: Float = Totaltabletemp.toString().toFloat()
                val nPeople: Int = NumPeopletemp.toString().toInt()
                val percentage: Int = Percentagetemp.toString().toInt()

                val Totalwithouttips = TotalTable / nPeople
                val Tips = Totalwithouttips * percentage / 100
                val TotalwithTips = Totalwithouttips + Tips


                val intent = Intent(this, SummaryActivity::class.java)
                intent.apply {
                    putExtra("TotalTable", TotalTable)
                    putExtra("nPeople", nPeople)
                    putExtra("percentage", percentage)
                    putExtra("TotalwithTips", TotalwithTips)
                }
                startActivity(intent)

                clean()

                }
            }

        binding.btnClean.setOnClickListener {
            clean()

            }
        }

        private fun clean () {
            binding.TieTotalTable.setText("")
            binding.TieTotalPeople.setText("")
            binding.TiePercentage.setText("")
        }
    }

