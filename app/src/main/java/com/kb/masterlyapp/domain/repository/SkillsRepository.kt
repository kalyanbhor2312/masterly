package com.kb.masterlyapp.domain.repository

import com.kb.masterlyapp.data.local.Skill
import kotlinx.coroutines.flow.Flow

interface SkillsRepository {
    fun getSkills(): Flow<List<Skill>>
    suspend fun addSkill(skill: Skill)
}