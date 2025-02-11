package com.uax.clasecinco

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.CompoundButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.uax.clasecinco.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener, CompoundButton.OnCheckedChangeListener {
    private lateinit var binding: ActivityMainBinding
    private var contador:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        contador=savedInstanceState?.getInt("contador")?:0
        binding.txtPalabras.text=contador.toString()

        binding.btnAnadir.setOnClickListener(this)
        binding.checkEdicion.setOnCheckedChangeListener(this)
        binding.btnReset?.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            binding.btnAnadir.id -> {
                if (binding.editText.text.isNotEmpty()){
                    contador++
                    binding.txtPalabras.text=contador.toString()
                    binding.editText.text.clear()
                }
            }
            binding.btnReset?.id->{
                contador=0
                binding.txtPalabras.text=contador.toString()
            }
        }
    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        when(buttonView?.id){
            binding.checkEdicion.id->{
                binding.editText.isEnabled=isChecked

            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("contador",contador)
    }


}


