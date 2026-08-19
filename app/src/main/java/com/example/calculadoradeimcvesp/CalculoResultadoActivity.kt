package com.example.calculadoradeimcvesp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.calculadoradeimcvesp.databinding.ActivityCalculoResultadoBinding

class CalculoResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityCalculoResultadoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btCalcular.setOnClickListener { view ->
            binding.tvResultado.text = ""
            val peso = binding.tietPeso.text.toString().replace(",", ".").trim().toDoubleOrNull()
            val altura = binding.tietAltura.text.toString().replace(",", ".").trim().toDoubleOrNull()

            var erroDeValidacao = false
            if (peso == null || peso <= 0) {
                binding.tilPeso.error = "Digite um peso válido"
                erroDeValidacao = true
            } else binding.tilPeso.error = ""

            if (altura == null || altura <= 0) {
                binding.tilAltura.error = "Digite uma altura válida"
                erroDeValidacao = true
            } else binding.tilAltura.error = ""
        }
    }
}