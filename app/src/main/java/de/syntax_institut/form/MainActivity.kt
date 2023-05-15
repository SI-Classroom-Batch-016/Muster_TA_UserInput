package de.syntax_institut.form

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // name views
    lateinit var firstName: EditText
    lateinit var lastName: EditText

    // gender views
    lateinit var genderText: TextView
    lateinit var genderFemale: Button
    lateinit var genderMale: Button
    lateinit var genderDiverse: Button

    // age views
    lateinit var ageText: TextView
    lateinit var age: SeekBar

    // size views
    lateinit var sizeText: TextView
    lateinit var size: SeekBar

    // submit and reset views
    lateinit var submit: Button
    lateinit var submitText: TextView
    lateinit var reset: Button

    // vars
    var selectedGender: String? = null
    var selectedAge = 0.0
    var selectedSize = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Init
        // name views
        firstName = findViewById(R.id.etVorname)
        lastName = findViewById(R.id.etNachname)

        // gender views
        genderText = findViewById(R.id.tvGeschlecht)
        genderFemale = findViewById(R.id.bFrau)
        genderMale = findViewById(R.id.bMann)
        genderDiverse = findViewById(R.id.bDivers)

        // age views
        ageText = findViewById(R.id.tvAlter)
        age = findViewById(R.id.sbAlter)

        // size views
        sizeText = findViewById(R.id.tvGewicht)
        size = findViewById(R.id.sbGewicht)

        // submit and reset views
        submit = findViewById(R.id.bEinreichen)
        submitText = findViewById(R.id.tvAntwort)
        reset = findViewById(R.id.bReset)

        // Set listener

        // Button "Frau"
        genderFemale.setOnClickListener {
            selectedGender = "Frau"
            genderText.text = getString(R.string.geschlecht, "Frau")
        }

        // Button "Mann"
        genderMale.setOnClickListener {
            selectedGender = "Mann"
            genderText.text = getString(R.string.geschlecht, "Mann")
        }

        // Button "Divers"
        genderDiverse.setOnClickListener {
            selectedGender = "Divers"
            genderText.text = getString(R.string.geschlecht, "Divers")
        }

        // Button "Einreichen"
        submit.setOnClickListener {
            submitText.text = getString(R.string.antwort, firstName.text, lastName.text, selectedGender, selectedAge, selectedSize)
        }

        // Seekbar "Alter"


        // Seekbar "Gewicht"

        // Button "Reset"


    }
}