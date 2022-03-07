package com.salimisler.data.di

import android.content.Context
import com.salimisler.data.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideAppDatabase(
        @ApplicationContext context: Context
    ) = AppDatabase.newInstance(context)


    @Provides
    @Singleton
    fun provideFavDao(appDatabase: AppDatabase) = appDatabase.getFavDao()
}