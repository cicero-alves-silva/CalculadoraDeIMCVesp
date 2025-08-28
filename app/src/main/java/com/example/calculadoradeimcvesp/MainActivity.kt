package com.example.calculadoradeimcvesp

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.calculadoradeimcvesp.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btOk.setOnClickListener { view ->
            var categoria = ""
            when(binding.rgCategorias.checkedRadioButtonId){
                binding.rbAdultos.id -> categoria = "ADULTO"
                binding.rbIdosos.id -> categoria = "IDOSO"
                else ->
                    Snackbar
                        .make(
                            view,
                            "Selecione uma as opções acima antes de clicar",
                            Snackbar.LENGTH_LONG
                        )
                        .setBackgroundTint(Color.RED)
                        .setTextColor(Color.WHITE)
                        .show()
            }
            if (categoria.isNotEmpty()) {
                //ABRIR A TELA DE CÁLCULO
                val intent = Intent(this, CalculoResultadoActivity::class.java)
                intent.putExtra("CATEGORIA", categoria)
                startActivity(intent)
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