package com.example.internhunt.data.model.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [InternshipEntity::class], version = 1, exportSchema = false)
abstract class InternshipDatabase: RoomDatabase() {
    abstract fun internshipDao(): InternshipDao

    companion object {
        @Volatile private var INSTANCE: InternshipDatabase? = null

        fun getDatabase(context: Context): InternshipDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    InternshipDatabase::class.java,
                    "internship_db"
                ).build().also { INSTANCE = it }
            }
        }
    }
}


