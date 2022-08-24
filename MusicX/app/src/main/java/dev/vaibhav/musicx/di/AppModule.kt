package dev.vaibhav.musicx.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.vaibhav.musicx.data.ApiCaller
import dev.vaibhav.musicx.data.ApiConstants
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideApi(builder: Retrofit.Builder): ApiCaller{
        return builder
            .build()
            .create(ApiCaller::class.java)
    }

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit.Builder{
        return Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
    }
}