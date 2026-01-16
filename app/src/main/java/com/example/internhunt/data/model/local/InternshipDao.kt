package com.example.internhunt.data.model.local

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface InternshipDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertInternship(internship: InternshipEntity)

    @Query("SELECT * FROM internshipTable")
    suspend fun getAllInternships(): List<InternshipEntity>

    @Delete
    suspend fun deleteInternship(internship: InternshipEntity)


}


