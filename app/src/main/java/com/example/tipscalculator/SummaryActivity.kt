package com.example.tipscalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tipscalculator.databinding.ActivitySummaryBinding

class SummaryActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySummaryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySummaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val totaltable = intent.getFloatExtra("TotalTable", 0.0f)
        val npeople = intent.getIntExtra("nPeople", 0)
        val percentage = intent.getIntExtra("percentage", 0)
        val totalwithtips = intent.getFloatExtra("TotalwithTips", 0.0f)


        binding.tvPercentage.text = "$percentage"
        binding.tvNpeople.text = "$npeople"
        binding.tvTotalTable.text = "$totaltable"
        binding.tvTotal.text = "$totalwithtips"

        binding.btnRefresh.setOnClickListener {
            finish()
        }

        }
    }
