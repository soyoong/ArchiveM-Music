package dev.vaibhav.musicx.data.repo

import com.example.character.data.api.model.Character
import dev.vaibhav.musicx.data.ApiCaller
import dev.vaibhav.musicx.data.models.Movie
import javax.inject.Inject

class CharacterRepo @Inject constructor(
    private val characterApi: ApiCaller
) {
    suspend fun getCharacters(): List<Character> {
        return characterApi.getCharacter()
    }

    suspend fun getAllMovies(): List<Movie> {
        return characterApi.getAllMovies()
    }
}