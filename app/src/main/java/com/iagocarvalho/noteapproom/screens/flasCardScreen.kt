package com.iagocarvalho.noteapproom.screens

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.iagocarvalho.noteapproom.R
import com.iagocarvalho.noteapproom.components.FlasCardButton
import com.iagocarvalho.noteapproom.components.FlasCardTextFild
import com.iagocarvalho.noteapproom.data.flasCardDataSource
import com.iagocarvalho.noteapproom.model.FlasCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun flashCardScreen(
    flasCards: List<FlasCard>,
    addFlasCard: (FlasCard) -> Unit,
    removeFlasCard: (FlasCard) -> Unit,
) {

    var pergunta by remember { mutableStateOf("") }
    var resposta by remember { mutableStateOf("") }

    val context = LocalContext.current

    Column(modifier = Modifier.padding(6.dp)) {
        TopAppBar(
            title = {
                Text(
                    text = stringResource(id = R.string.app_name)
                )
            },
            actions = {
                Icon(
                    imageVector = Icons.Rounded.Notifications,
                    contentDescription = "Icons"
                )
            },
            colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.LightGray)
        )
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            FlasCardTextFild(
                modifier = Modifier.padding(top = 9.dp, bottom = 8.dp),
                text = pergunta,
                label = "Pergunta",
                maxline = 1,
                OntextChange = {
                    if (it.all { char ->
                            char.isLetter() || char.isWhitespace()
                        }) pergunta = it
                })
            FlasCardTextFild(
                modifier = Modifier.padding(top = 9.dp, bottom = 8.dp),
                text = resposta,
                label = "Resposta",
                maxline = 1,
                OntextChange = {
                    if (it.all { char ->
                            char.isLetter() || char.isWhitespace()
                        }) resposta = it
                })
            FlasCardButton(text = "Save", onClick = {
                if (resposta.isNotEmpty() && pergunta.isNotEmpty()) {
                    addFlasCard(FlasCard(pergunta = pergunta, resposta = resposta))
                    //salvar ou add a list
                    pergunta = ""
                    resposta = ""
                    Toast.makeText(context, "FlashCard Adicionado", Toast.LENGTH_SHORT).show()
                }
            })
        }
        Divider(modifier = Modifier.padding(10.dp))
        LazyColumn {
            items(flasCards) { card ->
                FlasCardRow(flascard = card, onFlasCardClicked = {
                    removeFlasCard(card)
                })
            }
        }
    }
}

@Composable
fun FlasCardRow(
    modifier: Modifier = Modifier,
    flascard: FlasCard,
    onFlasCardClicked: (FlasCard) -> Unit
) {
    var expanded = remember {
        mutableStateOf(false)
    }
    Surface(
        modifier = Modifier
            .padding(4.dp)
            .clip(
                RoundedCornerShape(
                    topEnd = 33.dp,
                    bottomStart = 33.dp
                )
            )
            .fillMaxWidth(),
        color = Color.LightGray,
        shadowElevation = 6.dp
    ) {
        Row(modifier, verticalAlignment = Alignment.CenterVertically) {
            Column(
                modifier
                    .clickable { }
                    .padding(
                        horizontal = 15.dp,
                        vertical = 6.dp
                    )
                    .weight(1f),
                horizontalAlignment = Alignment.Start
            ) {
                Text(text = flascard.pergunta, style = MaterialTheme.typography.bodyMedium)
                if (expanded.value)Text(text = flascard.resposta, style = MaterialTheme.typography.bodyMedium)


            }
            Icon(
                imageVector =
                if (expanded.value) {
                    Icons.Default.KeyboardArrowUp
                } else {
                    Icons.Default.KeyboardArrowDown
                }, contentDescription = "",
                modifier.clickable { expanded.value = !expanded.value }
            )
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = "",
                modifier.clickable { onFlasCardClicked(flascard) })


        }

    }

}


@Preview(showBackground = true)
@Composable
fun FlashCardScreenPreview() {
    flashCardScreen(
        flasCards = flasCardDataSource().loadflasCards(),
        addFlasCard = {},
        removeFlasCard = {})
}