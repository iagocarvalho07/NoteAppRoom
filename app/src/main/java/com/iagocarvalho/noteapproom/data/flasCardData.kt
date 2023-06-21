package com.iagocarvalho.noteapproom.data

import com.iagocarvalho.noteapproom.model.FlasCard

class flasCardDataSource {
    fun loadflasCards(): List<FlasCard> {
        return listOf(
            FlasCard(pergunta = "A good day", resposta = "We went on a vacation by the lake"),
            FlasCard(pergunta = "Android Compose", resposta = "Working on Android Compay"),
            FlasCard(pergunta = "Keep at it...", resposta = "Sometimes things just happen"),
            FlasCard(pergunta = "A movie day", resposta = "Watching a movie with family today"),
            FlasCard(pergunta = "A movie day", resposta = "Watching a movie with family today"),
            FlasCard(pergunta = "A movie day", resposta = "Watching a movie with family today"),
            FlasCard(pergunta = "A movie day", resposta = "Watching a movie with family today"),
            FlasCard(pergunta = "A movie day", resposta = "Watching a movie with family today"),
            FlasCard(pergunta = "A movie day", resposta = "Watching a movie with family today"),
            FlasCard(pergunta = "A movie day", resposta = "Watching a movie with family")
        )
    }
}