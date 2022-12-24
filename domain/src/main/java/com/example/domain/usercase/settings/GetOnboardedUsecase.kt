package com.example.domain.usercase.settings

import com.example.domain.repo.SettingsRepository

class GetOnboardedUsecase(private val settingsRepository: SettingsRepository) {

    operator  fun invoke() = settingsRepository.getOnboarded()



}