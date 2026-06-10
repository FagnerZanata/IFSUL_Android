package com.example.myapp

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageButton
import android.widget.RadioGroup
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.chip.ChipGroup


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextNome = findViewById<EditText>(R.id.editTextNome)

        editTextNome.setOnFocusChangeListener { _, hasFocus ->

            if (!hasFocus) { // perdeu o foco

                val nome = editTextNome.text.toString().trim()

                if (nome.isEmpty()) {
                    //editTextNome.error = "Nome é obrigatório"
                } else if (nome.length < 3) {
                    //editTextNome.error = "Nome deve ter pelo menos 3 caracteres"
                } else {
                    //editTextNome.error = null
                }
            }
        }

        editTextNome.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Ação antes da mudança
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Ação enquanto o usuário digita
            }

            override fun afterTextChanged(s: Editable?) {
                // Ação depois que o texto foi alterado
                val textoDigitado = s.toString()
            }
        })

        val buttonSalvar = findViewById<Button>(R.id.buttonSalvar)
        val buttonSalvarImagem = findViewById<ImageButton>(R.id.buttonSalvarImagem)

        buttonSalvar.setOnClickListener {
            salvarAluno()
        }

        buttonSalvarImagem.setOnClickListener {
            salvarAluno()
        }
    }

    private fun salvarAluno() {
        // validações

        var valido = true

        val nome = findViewById<EditText>(R.id.editTextNome)
        val email = findViewById<EditText>(R.id.editTextEmail)
        val telefone = findViewById<EditText>(R.id.editTextTelefone)
        val cep = findViewById<EditText>(R.id.editTextCep)
        val complemento = findViewById<EditText>(R.id.editTextComplemento)
        val observacao = findViewById<EditText>(R.id.editTextObservacao)
        val senha = findViewById<EditText>(R.id.editTextSenha)

        val radioGroupSexo = findViewById<RadioGroup>(R.id.radioGroupSexo)

        if (radioGroupSexo.checkedRadioButtonId == -1) {
            Toast.makeText(
                this,
                "Selecione o sexo",
                Toast.LENGTH_SHORT
            ).show()
            valido = false
        }

        if (nome.text.toString().trim().isEmpty()) {
            nome.error = "Nome é obrigatório"
            valido = false
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email.text.toString()).matches()) {
            email.error = "Email inválido"
            valido = false
        }

        val telefoneLimpo = telefone.text.toString()
            .replace("[^0-9]".toRegex(), "")

        if (telefoneLimpo.length !in 10..11) {
            telefone.error = "Telefone inválido"
            valido = false
        }

        val cepLimpo = cep.text.toString()
            .replace("[^0-9]".toRegex(), "")

        if (cepLimpo.length != 8) {
            cep.error = "CEP inválido"
            valido = false
        }

        if (complemento.text.toString().trim().isEmpty()) {
            complemento.error = "Complemento é obrigatório"
            valido = false
        }

        if (observacao.text.toString().trim().isEmpty()) {
            observacao.error = "Observação é obrigatória"
            valido = false
        }

        if (senha.text.toString().length < 8) {
            senha.error = "A senha deve ter pelo menos 8 caracteres"
            valido = false
        }

        val chipGroupStatus = findViewById<ChipGroup>(R.id.chipGroupStatus)
        if (chipGroupStatus.checkedChipId == View.NO_ID) {
            Toast.makeText(
                this,
                "Selecione um turno",
                Toast.LENGTH_SHORT
            ).show()
            valido = false
        }

        val checkAndroid = findViewById<CheckBox>(R.id.checkAndroid)
        val checkIos = findViewById<CheckBox>(R.id.checkIos)
        val checkJava = findViewById<CheckBox>(R.id.checkJava)
        val checkReact = findViewById<CheckBox>(R.id.checkReact)
        val erroTecnologias = findViewById<TextView>(R.id.textViewErroTecnologias)

        val toggleNovidades =
            findViewById<Switch>(R.id.switchNovidades)

        val desejaReceberNovidades =
            toggleNovidades.isChecked

        val possuiTecnologiaSelecionada =
            checkAndroid.isChecked ||
                    checkIos.isChecked ||
                    checkJava.isChecked ||
                    checkReact.isChecked

        if (!possuiTecnologiaSelecionada) {
            erroTecnologias.text = "Selecione pelo menos uma tecnologia"
            erroTecnologias.visibility = View.VISIBLE
            valido = false
        } else {
            erroTecnologias.visibility = View.GONE
        }


        if (valido) {
            Toast.makeText(
                this,
                "Cadastro realizado com sucesso!",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    fun buttonSalvarClicou(view: View) {

        Log.d("MainActivity", "O botão foi clicado!")

    }

}
