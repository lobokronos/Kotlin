package com.uax.conuntounoydos

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.uax.conuntounoydos.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySecondBinding
    private var recuperadosUno:Bundle?=null
    private var recuperadosDos: Bundle? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val datos = intent.extras

        // Acceder a los datos del Bundle
        binding.resNombre.text = datos?.getString("nombre") ?: "Sin nombre"
        binding.resCheck.text  = datos?.getString("fraseUsuario") ?: "No has querido escribir nada"


        binding.volver.setOnClickListener{finish()}
    }




    }


