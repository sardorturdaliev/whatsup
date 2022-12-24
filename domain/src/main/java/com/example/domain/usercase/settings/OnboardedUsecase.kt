package com.example.domain.usercase.settings

import com.example.domain.repo.SettingsRepository

class OnboardedUsecase(private val  settingsRepository: SettingsRepository)  {

    operator fun invoke() = settingsRepository.onboarded()



}