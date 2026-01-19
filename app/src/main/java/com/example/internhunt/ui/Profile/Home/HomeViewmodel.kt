package com.example.internhunt.ui.Profile.Home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.internhunt.data.model.remote.Internship
import com.example.internhunt.data.model.repo.InternshipRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewmodel(
    private val repository: InternshipRepository
) : ViewModel() {

    private val _internships =
        MutableStateFlow<List<Internship>>(emptyList())

    val internships = _internships.asStateFlow()

    init {
        fetchInternships()
    }

    private fun fetchInternships() {
        viewModelScope.launch {
            try {
                val response = repository.fetchInternships()
                if (response.isSuccessful) {
                    println("Internships size = ${_internships.value.size}")

                    _internships.value =
                        response.body()?.results ?: emptyList()
                }
                else{
                    println("API ERROR :${response.code()}")
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}

class HomeViewmodelFactory(
    private val repository: InternshipRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewmodel::class.java)) {
            return HomeViewmodel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
