package com.app.flashfeed

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.lifecycleScope
import com.app.flashfeed.domain.usecases.AppEntryUseCases
import com.app.flashfeed.presentation.onboarding.OnBoardingScreen
import com.app.flashfeed.presentation.onboarding.OnBoardingViewModel
import com.app.flashfeed.ui.theme.FlashFeedTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var appEntryUseCases: AppEntryUseCases
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()


        lifecycleScope.launch {
            appEntryUseCases.readAppEntry().collect{
                Log.d("TEST", it.toString())
            }
        }


        setContent {
            FlashFeedTheme {
                // A surface container using the 'background' color from the theme
                Box(modifier = Modifier.background(color = MaterialTheme.colorScheme.background)){
                    val viewModel: OnBoardingViewModel = hiltViewModel()
                    OnBoardingScreen(event = viewModel::onEvent)
                }
            }
        }
    }




}




