package com.example.learntogether

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

@LargeTest
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    private lateinit var textTitle: String
    private lateinit var textMsg: String
    private lateinit var textDescription: String

    @Before
    fun setUp() {
        println("Setup before test")
    }

    @After
    fun tearDown() {
        println("Teardown after test")
    }

    @Test
    fun checkPackageName_onAndroid() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.learntogether", appContext.packageName)
    }

    @Test
    fun checkTexts_onAndroid() {
        textTitle = composeTestRule.activity.getString(R.string.tutorial_title)
        textMsg = composeTestRule.activity.getString(R.string.tutorial_text)
        textDescription = composeTestRule.activity.getString(R.string.tutorial_description)

        composeTestRule.onNodeWithText(textTitle).assertIsDisplayed()
        composeTestRule.onNodeWithText(textMsg).assertIsDisplayed()
        composeTestRule.onNodeWithText(textDescription).assertIsDisplayed()
    }
}