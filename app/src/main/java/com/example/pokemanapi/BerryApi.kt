package com.example.pokemanapi

import retrofit2.http.GET

interface BerryApi {

    @GET("berry")
    suspend fun getBerries() : Results


//
}