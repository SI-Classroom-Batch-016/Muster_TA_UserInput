package de.syntax_institut.form

import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    /**
     * Test, on button "submit" clicked, no first and last name entered, no gender selected
     * returns error message "Bitte gib deinen vollständigen Namen und dein Geschlecht ein!"
     */
    @Test
    fun testSubmitButtonOnClick1() {
        // Launch App
        val scenario = ActivityScenario.launch(MainActivity::class.java)

        // Press "submit" button and save response under tmp
        var tmp = ""
        scenario.onActivity {
            it.submit.callOnClick()
            tmp = it.submitText.text.toString()
        }

        // Create expected/actual
        val expected = "Bitte gib deinen vollständigen Namen und dein Geschlecht ein!"
        val actual = String(tmp.toCharArray())

        // Test
        assertEquals(actual, expected)
    }

    /**
     * Test, on button "submit" clicked, only first and not last name entered, no gender selected
     * returns error message "Bitte gib deinen vollständigen Namen und dein Geschlecht ein!"
     */
    @Test
    fun testSubmitButtonOnClick2() {
        // Launch App
        val scenario = ActivityScenario.launch(MainActivity::class.java)

        // Press "submit" button and save response under tmp
        var tmp = ""
        scenario.onActivity {
            it.firstName.setText("Luke")
            it.submit.callOnClick()
            tmp = it.submitText.text.toString()
        }

        // Create expected/actual
        val expected = "Bitte gib deinen vollständigen Namen und dein Geschlecht ein!"
        val actual = String(tmp.toCharArray())

        // Test
        assertEquals(actual, expected)
    }

    /**
     * Test, on button "submit" clicked, no first and only last name entered, no gender selected
     * returns error message "Bitte gib deinen vollständigen Namen und dein Geschlecht ein!"
     */
    @Test
    fun testSubmitButtonOnClick3() {
        // Launch App
        val scenario = ActivityScenario.launch(MainActivity::class.java)

        // Press "submit" button and save response under tmp
        var tmp = ""
        scenario.onActivity {
            it.lastName.setText("Skywalker")
            it.submit.callOnClick()
            tmp = it.submitText.text.toString()
        }

        // Create expected/actual
        val expected = "Bitte gib deinen vollständigen Namen und dein Geschlecht ein!"
        val actual = String(tmp.toCharArray())

        // Test
        assertEquals(actual, expected)
    }

    /**
     * Test, on button "submit" clicked, both first and last name entered, no gender selected
     * returns error message "Bitte gib dein Geschlecht ein"
     */
    @Test
    fun testSubmitButtonOnClick4() {
        // Launch App
        val scenario = ActivityScenario.launch(MainActivity::class.java)

        // Press "submit" button and save response under tmp
        var tmp = ""
        scenario.onActivity {
            it.firstName.setText("Luke")
            it.lastName.setText("Skywalker")
            it.submit.callOnClick()
            tmp = it.submitText.text.toString()
        }

        // Create expected/actual
        val expected = "Bitte gib dein Geschlecht ein"
        val actual = String(tmp.toCharArray())

        // Test
        assertEquals(actual, expected)
    }

    /**
     * Test, on button "submit" clicked, no first and last name entered, but gender selected
     * returns error message "Bitte gib deinen vollständigen Namen ein!"
     */
    @Test
    fun testSubmitButtonOnClick5() {
        // Launch App
        val scenario = ActivityScenario.launch(MainActivity::class.java)

        // Press "submit" button and save response under tmp
        var tmp = ""
        scenario.onActivity {
            it.gender.check(R.id.radio_button_frau)
            it.submit.callOnClick()
            tmp = it.submitText.text.toString()
        }

        // Create expected/actual
        val expected = "Bitte gib deinen vollständigen Namen ein!"
        val actual = String(tmp.toCharArray())

        // Test
        assertEquals(actual, expected)
    }

    /**
     * Test, on button "submit" clicked, only first name and no last name entered, but gender selected
     * returns error message "Bitte gib deinen vollständigen Namen ein!"
     */
    @Test
    fun testSubmitButtonOnClick6() {
        // Launch App
        val scenario = ActivityScenario.launch(MainActivity::class.java)

        // Press "submit" button and save response under tmp
        var tmp = ""
        scenario.onActivity {
            it.firstName.setText("Luke")
            it.gender.check(R.id.radio_button_frau)
            it.submit.callOnClick()
            tmp = it.submitText.text.toString()
        }

        // Create expected/actual
        val expected = "Bitte gib deinen vollständigen Namen ein!"
        val actual = String(tmp.toCharArray())

        // Test
        assertEquals(actual, expected)
    }

    /**
     * Test, on button "submit" clicked, no first name but last name entered, but gender selected
     * returns error message "Bitte gib deinen vollständigen Namen ein!"
     */
    @Test
    fun testSubmitButtonOnClick7() {
        // Launch App
        val scenario = ActivityScenario.launch(MainActivity::class.java)

        // Press "submit" button and save response under tmp
        var tmp = ""
        scenario.onActivity {
            it.lastName.setText("Skywalker")
            it.gender.check(R.id.radio_button_frau)
            it.submit.callOnClick()
            tmp = it.submitText.text.toString()
        }

        // Create expected/actual
        val expected = "Bitte gib deinen vollständigen Namen ein!"
        val actual = String(tmp.toCharArray())

        // Test
        assertEquals(actual, expected)
    }

    /**
     * Test, on button "submit" clicked, first name and last name entered, also gender selected
     * returns error message "Bitte gib deinen vollständigen Namen ein!"
     */
    @Test
    fun testSubmitButtonOnClick8() {
        // Launch App
        val scenario = ActivityScenario.launch(MainActivity::class.java)

        // Press "submit" button and save response under tmp
        var tmp = ""
        scenario.onActivity {
            it.firstName.setText("Luke")
            it.lastName.setText("Skywalker")
            it.gender.check(R.id.radio_button_frau)
            it.submit.callOnClick()
            tmp = it.submitText.text.toString()
        }

        // Create expected/actual
        val expected = "Hallo Luke Skywalker! Deinen Eingaben zufolge ist dein Geschlecht Frau."
        val actual = String(tmp.toCharArray())

        // Test
        assertEquals(actual, expected)
    }
}