package com.example.esportapps_uts.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.esportapps_uts.databinding.FragmentSignUpBinding
import com.example.esportapps_uts.model.User
import com.example.esportapps_uts.viewmodel.UserViewModel


class SignUpFragment : Fragment() {
    private lateinit var viewModel:UserViewModel
    private lateinit var dataBinding:FragmentSignUpBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_sign_up,container,false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        dataBinding.user = User("","","","")
        dataBinding.signuplistener = this
        dataBinding.loginlistener = this
    }

    override fun onButtonSignUp(v: View) {
        val list = listOf(dataBinding.user!!)
        viewModel.signUp(list)

        Toast.makeText(v.context, "Sign Up succeed", Toast.LENGTH_SHORT).show()
        val action = SignUpFragmentDirections.actionloginFragment()
        Navigation.findNavController(v).navigate(action)
    }

    override fun onButtonBack(v: View) {
        val action = SignUpFragmentDirections.actionloginFragment()
        Navigation.findNavController(v).navigate(action)
    }

}