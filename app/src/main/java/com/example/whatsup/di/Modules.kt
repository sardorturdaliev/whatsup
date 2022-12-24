package com.example.whatsup.di


import com.example.data.remote.auth.AuthFirebase
import com.example.data.remote.auth.AuthFirebaseImp
import com.example.data.remote.local.user.UserStorage
import com.example.data.remote.local.user.UserStorageImp
import com.example.data.remote.repo.AuthRepositoryImp
import com.example.domain.repo.Authrepository
import com.example.domain.usercase.auth.SendSmsCodeUseCase
import com.example.presentaion.screens.phone.PhoneViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module



val repositoryModule = module {
    single<Authrepository> {
        AuthRepositoryImp(get())
    }
}


val useCaseModule = module {
    single {
        SendSmsCodeUseCase(get())
    }
}


val localModule = module {
    single<UserStorage> { UserStorageImp() }
}


val remoteModule = module {
    single<AuthFirebase> {AuthFirebaseImp() }
}

val viewModelModule = module {
    viewModel{ PhoneViewModel(get())}
}


