package com.kb.masterlyapp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "skills")
data class Skill(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val minutesPracticed: Int,
    val goalMinutes: Int
)