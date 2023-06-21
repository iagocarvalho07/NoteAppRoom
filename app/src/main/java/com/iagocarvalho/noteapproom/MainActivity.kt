package com.iagocarvalho.noteapproom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.iagocarvalho.noteapproom.screens.flasCardViewModel
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
                    val flasCardViewModel: flasCardViewModel by viewModels()
                    FlasCardApp(flasCardViewModel = flasCardViewModel)
                }
            }
        }
    }
}

@Composable
fun FlasCardApp(flasCardViewModel: flasCardViewModel = viewModel()) {
    val flascarList = flasCardViewModel.getAllNotes()

    flashCardScreen(
        flasCards = flascarList, addFlasCard = { flasCardViewModel.addFlasCard(it) },
        removeFlasCard = { flasCardViewModel.removeflasCard(it) })
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NoteAppRoomTheme {
        flashCardScreen(flasCards = emptyList(), addFlasCard = {}, removeFlasCard = {})

    }
}