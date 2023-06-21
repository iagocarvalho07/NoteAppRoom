package com.iagocarvalho.noteapproom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.iagocarvalho.noteapproom.data.flasCardDataSource
import com.iagocarvalho.noteapproom.model.FlasCard
import com.iagocarvalho.noteapproom.screens.flashCardScreen
import com.iagocarvalho.noteapproom.ui.theme.NoteAppRoomTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteAppRoomTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val flascard = remember {
                        mutableStateListOf<FlasCard>()
                    }
                    flashCardScreen(flasCards = flascard, addFlasCard = {flascard.add(it)}, removeFlasCard ={flascard.remove(it)} )

                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NoteAppRoomTheme {
        flashCardScreen(flasCards = emptyList(), addFlasCard = {}, removeFlasCard ={} )

    }
}