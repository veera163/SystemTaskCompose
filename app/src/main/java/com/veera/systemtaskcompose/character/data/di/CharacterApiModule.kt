package com.veera.systemtaskcompose.character.data.di

import com.veera.systemtaskcompose.Utils.ApiConstants
import com.veera.systemtaskcompose.character.data.network.CharacterApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CharacterApiModule {

    @Provides
    @Singleton
    fun provideApi(builder:Retrofit.Builder): CharacterApi{
        return builder
            .build()
            .create(CharacterApi::class.java)
    }

     @Provides
    @Singleton
    fun provideRetrofit(): Retrofit.Builder{
        return Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
    }



}