package com.iagocarvalho.noteapproom.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "FlasCard_tbl")
data class FlasCard (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "PerguntasFlas")
    val pergunta: String,
    @ColumnInfo(name = "RespostasFlas")
    val resposta: String,
    //val data: Data = Data.from(Instant.now())
)