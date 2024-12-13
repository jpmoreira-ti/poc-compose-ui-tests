package com.example.learntogether

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learntogether.ui.theme.LearnTogetherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearnTogetherTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    GreetingImage(
                        title = stringResource(R.string.tutorial_title),
                        subtitle = stringResource(R.string.tutorial_text),
                        description = stringResource(R.string.tutorial_description)

                    )
                }
            }
        }
    }
}

@Composable
fun GreetingText(title: String, subtitle: String, description: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier
            .padding(
                top = 16.dp,
                bottom = 16.dp,
                start = 16.dp,
                end = 16.dp,
                )
        )
        Text(
            text = subtitle,
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    end = 16.dp
                ),
                textAlign = TextAlign.Justify
        )
        Text(
            text = description,
            modifier = Modifier
                .padding(
                    top = 16.dp,
                    bottom = 16.dp,
                    start = 16.dp,
                    end = 16.dp,
                ),
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun GreetingImage(title: String, subtitle: String, description: String, modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.bg_compose_background)
    Box(modifier) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Fit,
        )
        GreetingText(title = title, subtitle = subtitle, description = description, modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LearnTogetherTheme {
        GreetingImage(title = stringResource(R.string.tutorial_title),
            subtitle = stringResource(R.string.tutorial_text),
            description = stringResource(R.string.tutorial_description)
        )
    }
}