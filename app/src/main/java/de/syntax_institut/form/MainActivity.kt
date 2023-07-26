package de.syntax_institut.form

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // name views
    lateinit var firstName: EditText
    lateinit var lastName: EditText

    // gender views
    lateinit var genderText: TextView
    lateinit var gender: RadioGroup

    // cat and dog views
    lateinit var cat: CheckBox
    lateinit var dog: CheckBox

    // submit and reset views
    lateinit var submit: Button
    lateinit var submitText: TextView
    lateinit var reset: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Init views
        // name views
        firstName = findViewById(R.id.etVorname)
        lastName = findViewById(R.id.etNachname)

        // gender views
        genderText = findViewById(R.id.tvGeschlecht)
        gender = findViewById(R.id.radio_group)

        // cat and dog views
        cat = findViewById(R.id.cbCat)
        dog = findViewById(R.id.cbDog)

        // submit and reset views
        submit = findViewById(R.id.bEinreichen)
        submitText = findViewById(R.id.tvAntwort)
        reset = findViewById(R.id.bReset)

        // Set onClickListener
        // Button "Einreichen"
        submit.setOnClickListener {

            // Get selected gender
            var selectedGender: String? = null
            when (gender.checkedRadioButtonId) {
                R.id.radio_button_frau -> selectedGender = getString(R.string.woman)
                R.id.radio_button_mann -> selectedGender = getString(R.string.man)
                R.id.radio_button_divers -> selectedGender = getString(R.string.diverse)
            }

            // Check here, if user has made all required inputs (first name, last name and gender selected)
            val isFirstNameEntered = firstName.text.toString().isNotEmpty()
            val isLastNameEntered = lastName.text.toString().isNotEmpty()
            val isGenderSelected = selectedGender != null
            if (isFirstNameEntered && isLastNameEntered && isGenderSelected)
            {
                submitText.text = getString(R.string.answer, firstName.text, lastName.text, selectedGender)
            } else {

                // Build error message
                val msg: String
                if ((!isFirstNameEntered || !isLastNameEntered) && isGenderSelected)
                    msg = getString(R.string.error_name_missing)
                else if ((!isFirstNameEntered || !isLastNameEntered))
                    msg = getString(R.string.error_name_gender_missing)
                else
                    msg = getString(R.string.error_gender_missing)

                // Set error message
                submitText.text = msg
            }
        }

        // Button "Reset"
        reset.setOnClickListener {
            firstName.setText("")
            lastName.setText("")
            gender.clearCheck()
            cat.isChecked = false
            dog.isChecked = false
            submitText.text = ""
        }
    }
}