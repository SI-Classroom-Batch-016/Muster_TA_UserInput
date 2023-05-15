package de.syntax_institut.form

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // name views
    lateinit var firstName: EditText
    lateinit var lastName: EditText

    // gender views
    lateinit var genderText: TextView
    lateinit var gender: RadioGroup

    // submit and reset views
    lateinit var submit: Button
    lateinit var submitText: TextView
    lateinit var reset: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Init
        // name views
        firstName = findViewById(R.id.etVorname)
        lastName = findViewById(R.id.etNachname)

        // gender views
        genderText = findViewById(R.id.tvGeschlecht)
        gender = findViewById(R.id.radio_group)

        // submit and reset views
        submit = findViewById(R.id.bEinreichen)
        submitText = findViewById(R.id.tvAntwort)
        reset = findViewById(R.id.bReset)



        // Button "Einreichen"
        submit.setOnClickListener {

            var selectedGender: String? = null
            when (gender.checkedRadioButtonId) {
                R.id.radio_button_frau -> selectedGender = "Frau"
                R.id.radio_button_mann -> selectedGender = "Mann"
                R.id.radio_button_divers -> selectedGender = "Divers"
            }

            // Check here, if user has made all required inputs
            val isGenderSelected = selectedGender != null
            if (isGenderSelected) {
                submitText.text = getString(R.string.antwort, firstName.text, lastName.text, selectedGender)
            } else {
                submitText.text = "Fail"
            }
        }

    }
}