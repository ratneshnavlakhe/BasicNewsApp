package com.example.hiltintegrationexample.di

import com.example.hiltintegrationexample.BuildConfig
import com.example.hiltintegrationexample.data.network.ApiKeyInterceptor
import com.example.hiltintegrationexample.data.network.NewsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {
    @ApiKey
    @Provides
    fun providesApiKey(): String = BuildConfig.API_KEY

    @BaseUrl
    @Provides
    fun provideBaseUrl(): String = "https://newsapi.org/v2/"

    @Singleton
    @Provides
    fun providesGsonConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

    @Singleton
    @Provides
    fun providesNetworkService(
        @BaseUrl baseUrl: String,
        gsonConverterFactory: GsonConverterFactory,
        apiKeyInterceptor: ApiKeyInterceptor
    ): NewsApi {
        val okHttpClient = OkHttpClient.Builder().addInterceptor(apiKeyInterceptor).build()
        return Retrofit.Builder().client(okHttpClient).baseUrl(baseUrl)
            .addConverterFactory(gsonConverterFactory).build().create(NewsApi::class.java)
    }
}