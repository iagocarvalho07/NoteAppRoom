package com.iagocarvalho.noteapproom.di

import android.content.Context
import androidx.room.Room
import com.iagocarvalho.noteapproom.data.FlasCardDataBase
import com.iagocarvalho.noteapproom.data.FlasCardDataBaseDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun providesNotesDao(FlasCarddatabase: FlasCardDataBase ): FlasCardDataBaseDao
    = FlasCarddatabase.flascardaDao()

    @Singleton
    @Provides
    fun providesAppDataBase(@ApplicationContext context: Context): FlasCardDataBase
    = Room.databaseBuilder(
        context,
        FlasCardDataBase::class.java,
        "flascard_Db")
        .fallbackToDestructiveMigration()
        .build()

}