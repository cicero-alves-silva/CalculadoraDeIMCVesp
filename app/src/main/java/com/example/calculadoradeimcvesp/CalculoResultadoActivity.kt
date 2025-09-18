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
            val pesoString = binding.tietPeso.text.toString()
            val alturaString = binding.tietAltura.text.toString()
            if (pesoString.isEmpty()) {
                binding.tilPeso.error = "Digite o valor"
            } else {
                binding.tilPeso.error = ""
            }
            if (alturaString.isEmpty()) {
                binding.tilAltura.error = "Digite o valor"
            } else {
                binding.tilAltura.error = ""
            }

            if (pesoString.isNotEmpty() && alturaString.isNotEmpty()) {
                val peso = pesoString.replace(",", ".").toDouble()
                val altura = alturaString.replace(",", ".").toDouble()

                val bundle = intent.extras
                if (bundle != null) {
                    val categoria = bundle.getString("CATEGORIA")
                    val imc = peso / (altura * altura)

                    when(categoria) {
                        "ADULTO" -> {
                            if (imc < 18.5) {
                                binding.tvResultado.text = "BAIXO PESO"
                            } else if(imc >= 18.5 && imc < 25.0) {
                                binding.tvResultado.text = "PESO NORMAL"
                            } else if(imc >= 25.0 && imc < 30.0) {
                                binding.tvResultado.text = "SOBREPESO"
                            } else if(imc >= 30.0 && imc < 35.0) {
                                binding.tvResultado.text = "OBESIDADE CLASSE I"
                            } else if(imc >= 35.0 && imc < 40.0) {
                                binding.tvResultado.text = "OBESIDADE CLASSE II"
                            } else {
                                binding.tvResultado.text = "OBESIDADE CLASSE III"
                            }
                        }
                        "IDOSO" -> {
                            if(imc <= 22.0) {
                                binding.tvResultado.text = "BAIXO PESO"
                            } else if(imc > 22.0 && imc < 27.0) {
                                binding.tvResultado.text = "PESO NORMAL"
                            } else {
                                binding.tvResultado.text = "SOBREPESO"
                            }
                        }
                    }
                }
            }
        }

        binding.includeAppBar.materialToolbar.setOnMenuItemClickListener { menuItem ->
            when(menuItem.itemId) {
                R.id.miDireitosAutorais -> {
                    //ABRIR TELA PARA MOSTRAR OS CRÉDITO DO APP
                    true
                }
                else -> false
            }
        }
    }
}