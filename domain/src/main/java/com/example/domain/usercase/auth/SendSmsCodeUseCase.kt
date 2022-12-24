package com.example.domain.usercase.auth

import com.example.domain.repo.Authrepository

class SendSmsCodeUseCase constructor(
    private val authrepository: Authrepository
){


    operator fun invoke(phone:String){
        authrepository.sendSmsCode(phone)
    }


}