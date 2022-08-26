package me.hamsah.musiccompose.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import me.hamsah.musiccompose.model.Movie
import me.hamsah.musiccompose.model.Recommendation
//import me.hamsah.musiccompose.repo.Repo
import timber.log.Timber
import javax.inject.Inject

//@HiltViewModel
//class MainViewModel @Inject constructor (
//    private val repo: Repo
//) : ViewModel() {
//
//    private val _recommendation = MutableStateFlow(emptyList<Recommendation>())
//    val recommendation: StateFlow<List<Recommendation>> get() = _recommendation
//
//    fun getRecommendation() = viewModelScope.launch {
//        try {
//            val result = repo.getRecommendation()
//            _recommendation.value = result
//
//        } catch (e: Exception) {
//            Timber.e(e.localizedMessage)
//        }
//    }
//
//}