package com.droid.galla.di

import android.content.Context
import androidx.room.Room
import com.droid.galla.data.Constant
import com.droid.galla.data.source.local.MainDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {


    @Module
    @InstallIn(SingletonComponent::class)
    object DatabaseModule {
        @Provides
        @Singleton
        fun provideMainDatabase(@ApplicationContext context: Context): MainDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                MainDatabase::class.java,
                Constant.DATABASE_NAME
            ).build()
        }
    }

}