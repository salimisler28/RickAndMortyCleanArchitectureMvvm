package com.salimisler.data.di

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.salimisler.data.BuildConfig
import com.salimisler.data.network.api.CharacterApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideRetrofit(
        gsonConverterFactory: GsonConverterFactory,
        coroutineCallAdapterFactory: CoroutineCallAdapterFactory,
        httpClient: OkHttpClient
    ) = Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/api")
        .addConverterFactory(gsonConverterFactory)
        .addCallAdapterFactory(coroutineCallAdapterFactory)
        .client(httpClient)
        .build()

    @Provides
    @Singleton
    fun provideGsonConverterFactory() = GsonConverterFactory.create()

    @Provides
    @Singleton
    fun provideCoroutineCallAdapterFactory() = CoroutineCallAdapterFactory.invoke()

    @Provides
    @Singleton
    fun provideOkHttpClient() = OkHttpClient.Builder()
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()

    @Provides
    @Singleton
    fun provideCharacterApi(retrofit: Retrofit) = retrofit.create(CharacterApi::class.java)
}