package com.example.presentaion.screens.phone

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.domain.model.User
import com.example.presentaion.base.BaseFragment
import com.example.presentaion.databinding.FragmentPhoneBinding
import com.example.presentaion.screens.phone.PhoneViewModel.Effect
import org.koin.androidx.viewmodel.ext.android.viewModel

class PhoneFragment : BaseFragment<FragmentPhoneBinding>(FragmentPhoneBinding::inflate) {

    private  val viewModel: PhoneViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.state.observe(::renderUser){
            it.user!!
        }

        viewModel.effect.doOnNext(::handlerEffects)


    }

    private fun handlerEffects(effect: Effect) {

    }

    private fun renderUser(user:User) {

    }


}