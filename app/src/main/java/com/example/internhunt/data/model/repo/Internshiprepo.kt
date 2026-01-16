package com.example.internhunt.data.model.repo

import com.example.internhunt.data.model.local.InternshipDao
import com.example.internhunt.data.model.local.InternshipEntity
import com.example.internhunt.data.model.remote.InternshipApi

class InternshipRepository(
    private val api: InternshipApi,
    private val dao: InternshipDao
) {

    suspend fun fetchInternships() =
        api.getInternships(
            appId = "YOUR_APP_ID",
            appKey = "YOUR_API_KEY"
        )

    suspend fun saveInternship(internship: InternshipEntity) =
        dao.insertInternship(internship)

    suspend fun getSavedInternships() =
        dao.getAllInternships()
}
