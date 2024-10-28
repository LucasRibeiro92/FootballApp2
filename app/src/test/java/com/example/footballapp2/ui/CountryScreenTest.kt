package com.example.footballapp2.ui
/*
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.footballapp2.ui.CountryListScreen
import com.example.footballapp2.ui.composable.CountryScreen
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CountryListScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testLoadingState() {
        composeTestRule.setContent {
            CountryScreen(state = CountryState.Loading)
        }

        composeTestRule.onNodeWithTag("loading_animation").assertIsDisplayed()
    }

    @Test
    fun testSuccessState() {
        val mockCountries = listOf(/* mock Country data here */)
        composeTestRule.setContent {
            CountryListScreen(state = CountryListState.Success(mockCountries))
        }

        composeTestRule.onNodeWithTag("country_list").assertIsDisplayed()
    }

    @Test
    fun testErrorState() {
        composeTestRule.setContent {
            CountryListScreen(state = CountryListState.Error("Network Error"))
        }

        composeTestRule.onNodeWithTag("error_message").assertIsDisplayed()
    }
}
*/