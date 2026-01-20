package com.example.internhunt.ui.Profile.Search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.internhunt.data.model.local.InternshipEntity
import com.example.internhunt.data.model.remote.Internship
import com.example.internhunt.data.model.repo.InternshipRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SearchViewModel(val repo: InternshipRepository ): ViewModel() {

    private val _internships = MutableStateFlow<List<Internship>>(emptyList())
val internship=_internships.asStateFlow()

    init{
        fetchInternships()
    }
    private fun fetchInternships() {
        viewModelScope.launch {
            delay(400)
            try {
                val response = repo.fetchInternships()
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
    fun searchInternships(query: String) {
        viewModelScope.launch {
            delay(400)
            if(query.isBlank()) {return@launch}
            try {
                val response = repo.searchInternships(query)
                _internships.value = response
            }catch (e: Exception) {
                e.printStackTrace()
            }
        }

        }
    fun saveInternship(internship: Internship) {
        viewModelScope.launch {
            repo.saveInternship(internship)
        }
    }


}
class SearchViewModelFactory(
    private val repository: InternshipRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SearchViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return SearchViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

fun Internship.toEntity(): InternshipEntity {
    return InternshipEntity(
        id = this.id,  // Long
        title = this.title,
        company = this.company.display_name,
        location = this.location.display_name,
        applyUrl = this.redirect_url,
    )
}



