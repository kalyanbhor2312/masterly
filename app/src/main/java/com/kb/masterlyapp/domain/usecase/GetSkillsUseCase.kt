package com.kb.masterlyapp.domain.usecase

import com.kb.masterlyapp.data.local.Skill
import com.kb.masterlyapp.domain.repository.SkillsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSkillsUseCase @Inject constructor(
    private val skillsRepository: SkillsRepository
) {
    operator fun invoke(): Flow<List<Skill>> = skillsRepository.getSkills()
}