package com.example.internhunt.data.model.remote

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


interface InternshipApi {

    @GET("v1/api/jobs/in/search/1")
    suspend fun getInternships(
        @Query("app_id") appId: String,
        @Query("app_key") appKey: String,
        @Query("what") keyword: String = "internship",
        @Query("where") location: String = "India"
    ): Response<InternshipResponse>
}
object RetrofitInstance {

    private const val BASE_URL = "https://api.adzuna.com/"

    val api: InternshipApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(InternshipApi::class.java)
    }
}

