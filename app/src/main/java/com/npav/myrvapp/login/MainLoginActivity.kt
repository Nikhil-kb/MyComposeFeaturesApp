package com.npav.myrvapp.login

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.Settings
import android.telephony.TelephonyManager
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.npav.myrvapp.R
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.FileReader
import java.io.FileWriter
import java.io.Writer
import java.util.Random
import java.util.UUID

class MainLoginActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var et_username: TextInputEditText
    lateinit var et_password: TextInputEditText
    lateinit var signInButton: Button
    private lateinit var imei: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_login)

        init()
    }

    fun init() {

        val randomId = UUID.randomUUID()

        et_username = findViewById(R.id.et_username)
        et_password = findViewById(R.id.et_password)
        signInButton = findViewById(R.id.signInButton)
        signInButton.setOnClickListener(this)

        imei = Settings.Secure.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID).trim()
        et_username.setText(imei)
        et_password.setText(randomId.toString())

    }

    override fun onClick(view: View?) {
        var id: Int? = view?.id

        when (id) {
            R.id.signInButton -> {
                var isValid = true

                var username: String? = et_username.text.toString().trim()
                var password: String? = et_password.text.toString().trim()

                if (username?.isNullOrEmpty()!!) {
                    et_username.error = "Please, enter username"
                    isValid = false
                }

                if (password?.isNullOrEmpty()!!) {
                    et_password.error = "Please, enter password"
                    isValid = false
                }

                if (isValid) {
                    signInButton.setBackgroundColor(applicationContext.resources.getColor(R.color.purple_500))
                    Toast.makeText(applicationContext, "Valid", Toast.LENGTH_SHORT).show()
                }

            }
        }
    }

}