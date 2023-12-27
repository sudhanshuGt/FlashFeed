package com.app.flashfeed.presentation.component

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.flashfeed.R
import com.app.flashfeed.presentation.Dimens
import com.app.flashfeed.presentation.onboarding.Page
import com.app.flashfeed.presentation.onboarding.pages
import com.app.flashfeed.ui.theme.FlashFeedTheme


@Composable
fun OnBoardingPage(
    modifier: Modifier = Modifier,
    page: Page
){

    Column(modifier = Modifier) {
        Image(painter = painterResource(id = page.image), contentDescription = null,
              modifier = Modifier
                  .fillMaxWidth()
                  .fillMaxHeight(fraction = 0.5f), contentScale = ContentScale.Fit)

        Spacer(modifier = Modifier.height(Dimens.MediumPadding1))
        Text(
            text = page.title,
            modifier = Modifier.padding(horizontal = Dimens.MediumPadding1),
            style = MaterialTheme.typography.displaySmall.copy(fontWeight =  FontWeight.Bold),
            color = colorResource(id = R.color.display_small),
            fontSize = 18.sp
        )
        Text(
            text = page.description,
            modifier = Modifier.padding(horizontal = Dimens.MediumPadding1, vertical = Dimens.MediumPadding1),
             color = colorResource(id = R.color.text_medium),
            fontSize = 16.sp
        )
    }
}

@Preview(showBackground = true)
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun OnBoardingPagePreview(){
    FlashFeedTheme {
        OnBoardingPage( page = pages[0])
    }
}