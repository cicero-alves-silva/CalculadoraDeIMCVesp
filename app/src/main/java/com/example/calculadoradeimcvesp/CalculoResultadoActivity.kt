package com.example.calculadoradeimcvesp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.calculadoradeimcvesp.databinding.ActivityCalculoResultadoBinding
import kotlin.math.pow

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
            if (!erroDeValidacao) {
                val bundle = intent.extras
                if (bundle != null && peso != null && altura != null){
                    val categoria = bundle.getString("CATEGORIA")
                    val imc = peso / altura.pow(2)
                    val imcArredondado = "%.2f".format(imc).toDouble()
                    binding.tvResultado.text = when(categoria) {
                        "ADULTO" -> {
                            if (imcArredondado < 18.5) "BAIXO PESO"
                            else if (imcArredondado < 25.0) "PESO NORMAL"
                            else if (imcArredondado < 30.0) "SOBREPESO"
                            else if (imcArredondado < 35.0) "OBESIDADE CLASSE I"
                            else if (imcArredondado < 40.0) "OBESIDADE CLASSE II"
                            else "OBESIDADE CLASSE III"
                        }

                        "IDOSO" -> {
                            if (imcArredondado < 22.0) "BAIXO PESO"
                            else if (imcArredondado < 27.0) "PESO NORMAL"
                            else "SOBREPESO"
                        }

                        else -> "Categoria Inválida!"
                    }
                }
            }
        }

        binding.includeAppBar.materialToolbar.setOnMenuItemClickListener { menuItem ->
            when(menuItem.itemId) {
                R.id.miDireitosAutorais -> {
                    //ABRIR A TELA DOS CRÉDITOS DA APP
                    true
                }
                else -> false
            }
        }
    }
}