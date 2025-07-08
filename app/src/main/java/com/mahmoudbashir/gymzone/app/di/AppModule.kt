package com.mahmoudbashir.gymzone.app.di

import android.app.Application
import androidx.room.Room
import com.mahmoudbashir.gymzone.ui.data.db.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val appModule = module {

    single { provideDatabase(androidApplication()) }
    // Provide the DAOs
    single { get<AppDatabase>().exerciseDao() }
    single { get<AppDatabase>().playerDao() }
}

fun provideDatabase(application: Application): AppDatabase {
    return Room.databaseBuilder(application, AppDatabase::class.java, AppDatabase.DATABASE_NAME)
        .fallbackToDestructiveMigration()
        .build()
}