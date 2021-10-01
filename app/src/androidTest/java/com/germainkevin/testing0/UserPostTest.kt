package com.germainkevin.testing0

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class UserPostTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun number_of_like_initially_zero() {
        composeTestRule.onNodeWithText("0 like").assertExists()
    }

    @Test
    fun number_of_like_is_1() {
        composeTestRule.onNodeWithContentDescription("thumbs up").performClick()
        composeTestRule.onNodeWithText("1 like").assertExists()
    }
}