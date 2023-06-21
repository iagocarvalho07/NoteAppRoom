package com.iagocarvalho.noteapproom.model

import java.time.LocalDateTime

data class FlasCard (
    val id: Int = 0,
    val pergunta: String,
    val resposta: String,
    //val data: LocalDateTime = LocalDateTime.now()
)