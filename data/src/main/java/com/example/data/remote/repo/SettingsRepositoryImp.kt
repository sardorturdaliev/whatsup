package com.example.data.remote.repo

import com.example.data.remote.local.settings.SettingsStorage
import com.example.domain.repo.SettingsRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class SettingsRepositoryImp(private val settingsStorage: SettingsStorage) : SettingsRepository {

    override fun onboarded() = settingsStorage
        .onboarded()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())


    override fun getOnboarded() = settingsStorage.getBoarded()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())




}