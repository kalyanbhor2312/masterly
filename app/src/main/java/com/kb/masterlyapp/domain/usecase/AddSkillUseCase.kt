package com.kb.masterlyapp.domain.usecase

import com.kb.masterlyapp.data.local.Skill
import com.kb.masterlyapp.domain.repository.SkillsRepository
import javax.inject.Inject

class AddSkillUseCase @Inject constructor(
    private val skillsRepository: SkillsRepository
) {
    suspend operator fun invoke(skill: Skill) = skillsRepository.addSkill(skill)
}