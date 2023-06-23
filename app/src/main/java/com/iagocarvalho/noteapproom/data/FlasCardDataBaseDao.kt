package com.iagocarvalho.noteapproom.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.iagocarvalho.noteapproom.model.FlasCard
import kotlinx.coroutines.flow.Flow

@Dao
interface FlasCardDataBaseDao {
    @Query("SELECT * from FlasCard_tbl ORDER BY PerguntasFlas ASC")
    fun getAllItems(): Flow<List<FlasCard>>

    @Query("SELECT * from FlasCard_tbl WHERE id = :id")
    fun getItem(id: Int): Flow<FlasCard>

    // Specify the conflict strategy as IGNORE, when the user tries to add an
    // existing Item into the database Room ignores the conflict.
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: FlasCard)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(item: FlasCard)

    @Delete
    suspend fun delete(item: FlasCard)

}
