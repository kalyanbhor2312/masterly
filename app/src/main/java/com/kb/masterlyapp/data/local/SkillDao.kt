package com.kb.masterlyapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface SkillDao {

    @Insert
    suspend fun insert(skill: Skill)

    @Query("SELECT * FROM skills")
    fun getAllSkills(): Flow<List<Skill>>
}