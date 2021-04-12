package com.example.to_do_list.di

import android.app.Application
import androidx.room.Room
import com.example.to_do_list.data.Task
import com.example.to_do_list.data.TaskDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    // this used to handle between the classes and to find teh classes when need it

    @Provides
    @Singleton
    fun provideDatabase(
        appContext: Application,
        callback: TaskDatabase.Callback
    ) = Room.databaseBuilder(appContext, TaskDatabase::class.java, "task_database")
        .fallbackToDestructiveMigration()
        .addCallback(callback)
        .build()

    @Provides
    fun provideTaskDao(db: TaskDatabase) = db.taskDao()

}