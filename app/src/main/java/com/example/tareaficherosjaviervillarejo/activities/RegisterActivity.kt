package com.example.tareaficherosjaviervillarejo.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.tareaficherosjaviervillarejo.MainActivity
import com.example.tareaficherosjaviervillarejo.R
import com.example.tareaficherosjaviervillarejo.model.User
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    var registro:Boolean = true
    var usuario = User()

    lateinit var editTextUsuario:EditText
    lateinit var editTextPassword:EditText
    lateinit var editTextNombre:EditText
    lateinit var editTextApellidos:EditText

    lateinit var buttonCancelar: Button
    lateinit var buttonActualizar: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        editTextUsuario = findViewById<EditText>(R.id.editTextUsuario)
        editTextPassword = findViewById<EditText>(R.id.editTextPassword)
        editTextNombre = findViewById<EditText>(R.id.editTextNombre)
        editTextApellidos = findViewById<EditText>(R.id.editTextApellidos)

        buttonCancelar = findViewById<Button>(R.id.buttonCancelar)
        buttonActualizar = findViewById<Button>(R.id.buttonActualizar)


        registro = intent.getBooleanExtra("registro", true)

        if (!registro){
            var bundle:Bundle = intent.getBundleExtra("usuario")
            usuario.setBundle(bundle)

            editTextUsuario.setText(usuario.usuario)
            editTextPassword.setText(usuario.password)
            editTextNombre.setText(usuario.nombre)
            editTextApellidos.setText(usuario.apellidos)

            editTextUsuario.isEnabled = true
            editTextPassword.isEnabled = true
            editTextNombre.isEnabled = true
            editTextApellidos.isEnabled = true

            buttonCancelar.visibility = View.INVISIBLE
            buttonActualizar.visibility = View.VISIBLE
        }
    }

    fun onCancelar(view: View) {
        finish()
    }
    fun onAceptar(view: View) {
        if (registro) {
            usuario.usuario = editTextUsuario.text.toString()
            usuario.password = editTextPassword.text.toString()
            usuario.nombre = editTextNombre.text.toString()
            usuario.apellidos = editTextApellidos.text.toString()

            var resultIntent = Intent(this, MainActivity::class.java)
            resultIntent.putExtra("usuario", usuario.getBundle())

            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
        else{
            finish()
        }
    }

    fun onActualizar(view: View) {
        usuario.usuario = editTextUsuario.text.toString()
        usuario.password = editTextPassword.text.toString()
        usuario.nombre = editTextNombre.text.toString()
        usuario.apellidos = editTextApellidos.text.toString()

        var resultIntent = Intent(this, MainActivity::class.java)
        resultIntent.putExtra("usuario", "")
        resultIntent.putExtra("usuario", usuario.getBundle())

        setResult(Activity.RESULT_OK, resultIntent)
        finish()
    }
}