package com.example.data.remote.local.settings

import io.realm.kotlin.types.ObjectId
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

data class SettingRealm(
    @PrimaryKey
    val id: ObjectId = ObjectId.create(),
    val onboarded : Boolean = false

) : RealmObject