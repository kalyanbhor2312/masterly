package com.kb.masterlyapp.data.repository

import com.kb.masterlyapp.data.local.Skill
import com.kb.masterlyapp.data.local.SkillDao
import com.kb.masterlyapp.domain.repository.SkillsRepository
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow

class SkillsRepositoryImpl @Inject constructor(
    private val skillDao: SkillDao
) : SkillsRepository {git

    override fun getSkills(): Flow<List<Skill>> {
        return skillDao.getAllSkills()
    }

    override suspend fun addSkill(skill: Skill) {
        skillDao.insert(skill)
    }
}