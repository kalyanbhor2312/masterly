package com.kb.masterlyapp.di

import com.kb.masterlyapp.data.repository.SkillsRepositoryImpl
import com.kb.masterlyapp.domain.repository.SkillsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun bindSkillsRepository(skillsRepositoryImpl: SkillsRepositoryImpl): SkillsRepository
}