package com.example.internhunt.ui.Profile.Search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.internhunt.data.model.remote.Internship
import com.example.internhunt.data.model.repo.InternshipRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SearchViewModel(val repo: InternshipRepository ): ViewModel() {

    private val _internships = MutableStateFlow<List<Internship>>(emptyList())
val internship=_internships.asStateFlow()

    fun searchInternships(query: String) {
        viewModelScope.launch {
            if(query.isBlank()) {return@launch}
            try {
                val response = repo.searchInternships(query)
                _internships.value = response
            }catch (e: Exception) {
                e.printStackTrace()
            }
        }

        }

    }


