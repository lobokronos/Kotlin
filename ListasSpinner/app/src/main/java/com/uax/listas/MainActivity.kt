package com.uax.listas

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener
import com.google.android.material.snackbar.Snackbar
import com.uax.listas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener, AdapterView.OnItemSelectedListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var listaCiclos: ArrayList<CharSequence>
    private lateinit var adapterCiclos: ArrayAdapter<CharSequence>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        instancias()

        binding.btnEnviar.setOnClickListener(this)
        binding.btnBorrar.setOnClickListener(this)
        binding.spinnerHabilitado.onItemSelectedListener = this
        binding.spinnerCiclos.onItemSelectedListener = this
    }


    private fun instancias() {
        listaCiclos = arrayListOf("DAM", "DAW")
        adapterCiclos =
            ArrayAdapter(applicationContext, android.R.layout.simple_spinner_item, listaCiclos)
        adapterCiclos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerCiclos.adapter = adapterCiclos
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            binding.btnEnviar.id -> {
                val seleccion = binding.spinnerHabilitado.selectedItem.toString()
                //Snackbar.make(binding.root,"Has seleccionado $seleccion",Snackbar.LENGTH_SHORT).show()

                var ciclo = binding.editCiclo.text.toString()
                listaCiclos.add(ciclo)
                adapterCiclos.notifyDataSetChanged()
            }

            binding.btnBorrar.id->{
                listaCiclos.remove(binding.editCiclo.text.toString())
                adapterCiclos.notifyDataSetChanged()
            }
        }
    }

    override fun onItemSelected(p0: AdapterView<*>?, view: View?, p2: Int, id: Long) {
        when (p0?.id) {
            binding.spinnerHabilitado.id -> {
                val seleccion = p0.adapter.getItem(p2).toString()
                // Snackbar.make(binding.root,"Has seleccionado $seleccion",Snackbar.LENGTH_SHORT).show()


                if (p2 == 0) {
                    binding.btnEnviar.isEnabled = true
                } else {
                    binding.btnEnviar.isEnabled = false
                }

            }

            binding.spinnerCiclos.id -> {
                var seleccion = adapterCiclos.getItem(p2)
                binding.textoCiclo.text = seleccion.toString()


            }
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }


}
