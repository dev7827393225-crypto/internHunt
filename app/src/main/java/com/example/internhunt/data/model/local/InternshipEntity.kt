package com.example.internhunt.data.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "internshipTable")
data class InternshipEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val company: String,
    val location: String,
    val applyUrl: String
    )