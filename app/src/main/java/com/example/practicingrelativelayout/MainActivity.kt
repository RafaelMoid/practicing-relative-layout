package com.example.practicingrelativelayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //I'm having problems to make it work if anyone can help me, please let me know.
    private fun setListeners(){
        alturaEDT?.doAfterTextChanged {  }
        pesoEDT.doOnTextChanged{text, _, _, _ ->  }

        buttonCalc.setOnClickListener{
            calcularIMC(pesoEDT.text.toString(), alturaEDT.text.toString())
        }
    }

    //função criada para impedir o crash caso seja dado entrada com valor nulo
    private fun calcularIMC(peso: String, altura: String){
        val peso = peso.toFloatOrNull()
        val altura = altura.toFloatOrNull()

        if (peso != null && altura != null){
            val imc = peso / (altura * altura)
            imcText.text = "Seu IMC é:".format(imc)

        }


    }
}
