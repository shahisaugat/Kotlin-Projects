package com.example.registrationform

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var buttonLogin: Button
    private lateinit var firstName : EditText
    private lateinit var lastName : EditText
    private lateinit var emailAddress : EditText
    private lateinit var password : EditText
    private lateinit var confirmPassword : EditText
    private lateinit var checkBox : CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        buttonLogin = findViewById(R.id.button)
        firstName = findViewById(R.id.firstNameEntry)
        lastName = findViewById(R.id.lastNameEntry)
        emailAddress = findViewById(R.id.emailEntry)
        password = findViewById(R.id.passwordEntry)
        confirmPassword = findViewById(R.id.cfmPasswordEntry)
        checkBox = findViewById(R.id.checkBox)

        buttonLogin.setOnClickListener {
            val enteredEmail : String = emailAddress.text.toString()
            val enteredPassword : String = password.text.toString()
            val enteredCfmPassword : String = confirmPassword.text.toString()
            val enteredFirstName : String = firstName.text.toString()
            val enteredLastName : String = lastName.text.toString()

            if (enteredEmail.isEmpty()|| enteredPassword.isEmpty() || enteredCfmPassword.isEmpty() || enteredFirstName.isEmpty() || enteredLastName.isEmpty()) {
                Toast.makeText(this, "Please! fill in all the details first.", Toast.LENGTH_LONG).show()
            } else {
                if (enteredPassword.isNotEmpty() && enteredCfmPassword.isNotEmpty() && enteredPassword == enteredCfmPassword) {
                    if (checkBox.isChecked) {
                        val intent = Intent(this@MainActivity, SecondActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, "You need to agree to our Terms and Conditions to continue!", Toast.LENGTH_LONG).show()
                    }
                } else {
                    Toast.makeText(this, "Password didn't match!", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}