package com.vibe.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.vibe.composearticle.ui.theme.ComposeArticleTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                   ComposeArticleApp()
                }
            }
        }
    }
}


@Composable
fun ComposeArticleApp() {
   ArticleCard(
       title = stringResource(R.string.title_jetpack_compose_tutorial),
       shortDescription = stringResource(R.string.compose_short_desc),
       longDescription = stringResource(R.string.compose_long_desc),
       footer_information = stringResource(R.string.footer_information),
       //continue_btn = stringResource(R.string.continue_btn),
       imagePainter = painterResource(R.drawable.bg_compose_background)
   )
}
@Composable
private fun ArticleCard(
    title: String,
    shortDescription: String,
    longDescription: String,
    footer_information: String,
    imagePainter: Painter,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        Image(painter = imagePainter, contentDescription = null)

        Text(
            text = title,
            modifier = Modifier.padding(16.dp),
            fontSize = 24.sp
        )
        Text(
            text = shortDescription,
            modifier = Modifier.padding(
                start = 16.dp,
                end = 16.dp,
                //bottom = 16.dp,{ /*TODO*/ }
                //top = 16.dp
            ),
            textAlign = TextAlign.Justify
        )
        Text(
            text = longDescription,
            modifier = Modifier.padding(
                start = 16.dp,
            )
        )

        Text(
            text = footer_information,
            modifier = Modifier.padding(
                start = 16.dp,
                end=50.dp,
                top = 130.dp,
                bottom = 16.dp
            ),
        textAlign= TextAlign.Right,
        )
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeArticleTheme {
       ComposeArticleApp()
    }
}