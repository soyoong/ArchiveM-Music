package dev.vaibhav.musicx.data

import dev.vaibhav.musicx.data.models.Character
import dev.vaibhav.musicx.data.models.Movie
import retrofit2.http.GET

interface ApiCaller {

    @GET("characters")
    suspend fun getCharacter():List<Character>

    @GET("movielist.json")
    suspend fun getAllMovies():List<Movie>

}