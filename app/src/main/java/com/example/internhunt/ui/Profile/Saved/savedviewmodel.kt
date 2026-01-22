package com.example.internhunt.ui.Profile.Saved

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.internhunt.data.model.local.InternshipEntity
import com.example.internhunt.data.model.repo.InternshipRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class savedviewmodel(private val repo: InternshipRepository): ViewModel() {


    val internships: StateFlow<List<InternshipEntity>> =
        repo.getSavedInternships()
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = emptyList()
            )

    fun deleteInternship(internship: InternshipEntity) {
        viewModelScope.launch {
            repo.deleteInternship(internship)
        }
    }


}
class savedviewmodelfactory(private val repo: InternshipRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(savedviewmodel::class.java)){
            return savedviewmodel(repo) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")

   }

}