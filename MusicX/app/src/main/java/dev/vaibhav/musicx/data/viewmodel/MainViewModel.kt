package dev.vaibhav.musicx.data.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.character.data.api.model.Character
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

    var listCharacter

    fun getAllHarryPorter() = viewModelScope.launch {
        try {
            val characters = characterRepo.getCharacters()
            _stateCharacter.value = characters
        } catch (e: Exception) {
            Timber.e(e.localizedMessage)
        }
    }

    private val _state = MutableStateFlow(emptyList<Character>())
    val listCharacter: StateFlow<List<Character>> get() = _state

    fun getAllMovies() = viewModelScope.launch {
        try {
            val movies = characterRepo.getAllMovies()

        } catch (e: Exception) {
            Timber.e(e.localizedMessage)
        }
    }

}