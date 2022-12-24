package com.example.data.remote.local.settings

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface SettingsStorage {
    fun onboarded() : Completable
    fun getBoarded() : Single<Boolean>





}