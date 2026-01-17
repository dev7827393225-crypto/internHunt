package com.example.internhunt.data.model.remote

data class InternshipResponse(
    val result: List<Internship>

) {
}
data class Internship(
    val id: String,
    val title: String,
    val company: Company,
    val location: Location,
    val redirect_url: String?
)

data class Company(val display_name: String)
data class Location(val display_name: String)