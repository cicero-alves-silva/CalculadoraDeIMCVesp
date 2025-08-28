package com.example.calculadoradeimcvesp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.calculadoradeimcvesp.databinding.ActivityCalculoResultadoBinding

class CalculoResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityCalculoResultadoBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}