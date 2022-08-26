package dev.vaibhav.musicx.data.viewmodel

import dev.vaibhav.musicx.data.models.Character
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.vaibhav.musicx.data.repo.CharacterRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val characterRepo: CharacterRepo
) : ViewModel() {

    private val _stateCharacter = MutableStateFlow(emptyList<Character>())
    val stateCharacter: StateFlow<List<Character>> get() = _stateCharacter

    fun getAllHarryPorter() = viewModelScope.launch {
        try {
            val characters = characterRepo.getCharacters()
            _stateCharacter.value = characters
        } catch (e: Exception) {
            Timber.e(e.localizedMessage)
        }
    }

    fun getAllMovies() = viewModelScope.launch {
        try {
            val movies = characterRepo.getAllMovies()

        } catch (e: Exception) {
            Timber.e(e.localizedMessage)
        }
    }

}