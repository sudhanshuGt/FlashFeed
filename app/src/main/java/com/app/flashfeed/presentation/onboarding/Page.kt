package com.app.flashfeed.presentation.onboarding

import androidx.annotation.DrawableRes
import com.app.flashfeed.R

data class Page(
    val title :String,
    val description : String,
    @DrawableRes val image : Int
)

val  pages = listOf(
    Page(
        title = "Hello, this is title",
        description =  "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500.",
        image = R.drawable.onboard1
    ),
    Page(
        title = "Hello, this is title",
        description =  "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500.",
        image = R.drawable.onboard2
    ),
    Page(
        title = "Hello, this is title",
        description =  "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500.",
        image = R.drawable.onboard2
    )
)