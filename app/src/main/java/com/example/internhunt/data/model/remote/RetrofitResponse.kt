package com.example.internhunt.data.model.remote

data class InternshipResponse(
    val result: List<Internship>

) {
}
data class Internship(
    val id: String,
    val title: String,
    val company: String,
    val location: String,
    val redirect_url: String
)

data class Company(val display_name: String)
data class Location(val display_name: String)