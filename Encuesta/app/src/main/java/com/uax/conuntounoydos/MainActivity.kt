package com.uax.conuntounoydos

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.uax.conuntounoydos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener,
    CompoundButton.OnCheckedChangeListener {
    private lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.btnEnviar.setOnClickListener(this)
        binding.btnReset.setOnClickListener(this)
        binding.checkBox.setOnCheckedChangeListener(this)


    }

    override fun onClick(v: View?) {
        when (v?.id) {
            binding.btnEnviar.id->{
                var intent:Intent=Intent(this.applicationContext,SecondActivity::class.java)
                var bundle:Bundle=Bundle()
                bundle.putString("nombre", binding.editText.text.toString())
                bundle.putString("fraseUsuario",binding.txtUsuario.text.toString())
                intent.putExtras(bundle)
                startActivity(intent)
            }
            binding.btnReset.id -> {
                limpiar()
            }
        }

    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        when (buttonView?.id) {
            binding.checkBox.id -> {
                binding.txtUsuario.isEnabled = isChecked
            }
        }
    }

    fun limpiar() {
        if (binding.editText.text.isNotEmpty()) {
            binding.editText.text.clear()
        }
        if (binding.txtUsuario.text.isNotEmpty()){
            binding.txtUsuario.text.clear()
        }
    }

    override fun onRestart() {
        super.onRestart()
        limpiar()
    }
}

