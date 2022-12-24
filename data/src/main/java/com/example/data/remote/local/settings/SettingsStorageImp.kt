package com.example.data.remote.local.settings

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import io.realm.kotlin.Realm
import io.realm.kotlin.UpdatePolicy
import io.realm.kotlin.ext.query

class SettingsStorageImp(private val realm: Realm) : SettingsStorage {

    private fun getSettings(): Single<SettingRealm> = Single.fromCallable {
        realm.query<SettingRealm>().find().firstOrNull() ?: kotlin.run {
            realm.writeBlocking {
                copyToRealm(SettingRealm())
            }
        }
    }




    override fun onboarded(): Completable {
       return getSettings().flatMapCompletable {
            Completable.fromCallable{
                realm.writeBlocking {
                    copyToRealm(it.copy(onboarded = true), UpdatePolicy.ALL)
                }
            }
        }
    }

    override fun getBoarded(): Single<Boolean>  =  getSettings().map { it.onboarded }






}