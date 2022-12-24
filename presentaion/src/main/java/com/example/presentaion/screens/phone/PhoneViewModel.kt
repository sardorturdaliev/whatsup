package com.example.presentaion.screens.phone


import androidx.lifecycle.ViewModel
import com.example.domain.model.User
import com.example.domain.usercase.auth.SendSmsCodeUseCase
import com.example.presentaion.base.BaseViewModel
import com.example.presentaion.screens.phone.PhoneViewModel.*

class PhoneViewModel constructor(
    private val sendSmsCodeUseCase: SendSmsCodeUseCase
)  : BaseViewModel<State,Input,Effect>(){



    data class State(
        val user : User? = null
    )

    class Effect

    class Input

    override fun getDefaultState() = State()

    override fun processInput(input: Input) {
        TODO("Not yet implemented")
    }


}