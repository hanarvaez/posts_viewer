package co.com.monkeymobile.post_viewer.di

import co.com.monkeymobile.post_viewer.data.ApiService
import co.com.monkeymobile.post_viewer.data.ApiUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModule {

    private var apiService: ApiService? = null

    fun getApiService(): ApiService {
        apiService?.let { return it }

        val retrofit = Retrofit.Builder()
            .baseUrl(ApiUrl.REST_BASE_URL)
            .client(createOkHttpClient())
            .addConverterFactory(createConverterFactory())
            .build()

        return retrofit.create(ApiService::class.java).also { apiService = it  }
    }

    private fun createOkHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

        return OkHttpClient.Builder().apply {
            cache(null)
            addInterceptor(loggingInterceptor)
        }.build()
    }

    private fun createConverterFactory(): Converter.Factory = GsonConverterFactory.create()
}