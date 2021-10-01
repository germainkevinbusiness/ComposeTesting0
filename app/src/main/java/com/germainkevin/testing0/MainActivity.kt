package com.germainkevin.testing0

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.germainkevin.testing0.ui.theme.Purple200
import com.germainkevin.testing0.ui.theme.Testing0Theme

/**
 * Testing your Compose layout, part 1
 * */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Testing0Theme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    UserPost()
                }
            }
        }
    }
}

@Composable
fun UserPost() {
    var isPostLiked by remember { mutableStateOf(false) }
    val likeCountText =
        if (isPostLiked) stringResource(id = R.string.clicks, 1)
        else stringResource(id = R.string.clicks, 0)
    val likeIconTintColor = if (isPostLiked) Purple200 else Color.White

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.karsten_winegeart_1_unsplash),
            contentDescription = "Cute doggo",
            modifier = Modifier
                .size(300.dp)
                .padding(top = 16.dp)
        )
        Text(
            text = likeCountText,
            modifier = Modifier.padding(top = 16.dp)
        )
        Button(onClick = { isPostLiked = !isPostLiked }, modifier = Modifier.padding(16.dp)) {
            Icon(
                imageVector = Icons.Default.ThumbUp,
                contentDescription = "thumbs up",
                tint = likeIconTintColor
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Testing0Theme {
        UserPost()
    }
}