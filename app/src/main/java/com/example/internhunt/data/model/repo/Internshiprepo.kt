package com.example.internhunt.data.model.repo

import com.example.internhunt.data.model.local.InternshipDao
import com.example.internhunt.data.model.local.InternshipEntity
import com.example.internhunt.data.model.remote.Internship
import com.example.internhunt.data.model.remote.InternshipApi

class InternshipRepository(
    private val api: InternshipApi,
    private val dao: InternshipDao
) {

    suspend fun fetchInternships() =
        api.getInternships(
            appId = "026d6ef6",
            appKey =  "fbbfa2a3a15bd7afbc4e444c1f43b013"
        )
    suspend fun searchInternships(query: String): List<Internship> {
        val response = api.getInternships(
            appId = "026d6ef6",
            appKey = "fbbfa2a3a15bd7afbc4e444c1f43b013",
            keyword = query
        )

        if (response.isSuccessful) {
            return response.body()?.results ?: emptyList()
        } else {
            throw Exception("API Error ${response.code()}")
        }
    }

    suspend fun saveInternship(internship: Internship) =
        dao.insertInternship(internship.toEntity())

    suspend fun getSavedInternships() =
        dao.getAllInternships()
}

fun Internship.toEntity(): InternshipEntity {
    return InternshipEntity(
        id = this.id.toLong(),  // Long
        title = this.title,
        company = this.company.display_name,
        location = this.location.display_name,
        applyUrl = this.redirect_url
    )
}
