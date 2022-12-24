package com.example.whatsup.di


import com.example.data.remote.auth.AuthFirebase
import com.example.data.remote.auth.AuthFirebaseImp
import com.example.data.remote.local.settings.SettingRealm
import com.example.data.remote.local.settings.SettingsStorage
import com.example.data.remote.local.settings.SettingsStorageImp
import com.example.data.remote.local.user.UserStorage
import com.example.data.remote.local.user.UserStorageImp
import com.example.data.remote.repo.AuthRepositoryImp
import com.example.data.remote.repo.SettingsRepositoryImp
import com.example.domain.repo.Authrepository
import com.example.domain.repo.SettingsRepository
import com.example.domain.usercase.auth.SendSmsCodeUseCase
import com.example.domain.usercase.settings.GetOnboardedUsecase
import com.example.domain.usercase.settings.OnboardedUsecase
import com.example.presentaion.screens.main.MainViewModel
import com.example.presentaion.screens.phone.PhoneViewModel
import com.github.terrakok.cicerone.Cicerone
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val config = RealmConfiguration.Builder(schema = setOf(SettingRealm::class)).build()
private val cicerone = Cicerone.create()

val appModule = module {
    single { cicerone.router }
    single { cicerone.getNavigatorHolder() }
    single { Realm.open(config) }

}


val repositoryModule = module {
    single<Authrepository> {
        AuthRepositoryImp(get())
    }

    single<SettingsRepository> { SettingsRepositoryImp(get()) }



}


val useCaseModule = module {
    single {
        SendSmsCodeUseCase(get())
    }

    single {
        OnboardedUsecase(get())
        GetOnboardedUsecase(get())
    }
}


val localModule = module {
    single<UserStorage> { UserStorageImp() }
    single<SettingsStorage> { SettingsStorageImp(get()) }

}


val remoteModule = module {
    single<AuthFirebase> { AuthFirebaseImp() }
}

val viewModelModule = module {
    viewModel { PhoneViewModel(get()) }
    viewModel { MainViewModel(get()) }
}


