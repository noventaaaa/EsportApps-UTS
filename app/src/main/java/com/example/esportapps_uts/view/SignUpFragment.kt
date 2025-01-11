package com.example.esportapps_uts.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.esportapps_uts.R
import com.example.esportapps_uts.databinding.FragmentSignUpBinding
import com.example.esportapps_uts.model.User
import com.example.esportapps_uts.viewmodel.UserViewModel

class SignUpFragment : Fragment(), ButtonSignUpListener, ButtonBackListener {

    private lateinit var viewModel: UserViewModel
    private lateinit var dataBinding: FragmentSignUpBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Menghubungkan layout XML dengan fragment
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_sign_up, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        dataBinding.user = User("", "", "", "")
        dataBinding.signuplistener = this
        dataBinding.loginlistener = this

        dataBinding.btnSignUp.isEnabled = false

        dataBinding.checkBoxIagree.setOnCheckedChangeListener { _, _ ->
            updateSignUpButtonState()
        }

        dataBinding.txtUsername.addTextChangedListener { updateSignUpButtonState() }
        dataBinding.txtPassword.addTextChangedListener { updateSignUpButtonState() }
        dataBinding.txtUlangPassword.addTextChangedListener { updateSignUpButtonState() }
    }

    private fun updateSignUpButtonState() {
        val username = dataBinding.txtUsername.text.toString().trim()
        val password = dataBinding.txtPassword.text.toString()
        val repeatPassword = dataBinding.txtUlangPassword.text.toString()
        val isAgreeChecked = dataBinding.checkBoxIagree.isChecked

        dataBinding.btnSignUp.isEnabled =
            username.isNotEmpty() && password.isNotEmpty() && password == repeatPassword && isAgreeChecked
    }

    override fun onButtonSignUp(v: View) {
        val firstname = dataBinding.txtNamaDepan.text.toString().trim()
        val lastname = dataBinding.txtNamaBelakang.text.toString().trim()
        val username = dataBinding.txtUsername.text.toString().trim()
        val password = dataBinding.txtPassword.text.toString()

        viewModel.checkUsernameUnique(username).observe(viewLifecycleOwner) { isUnique ->
            if (isUnique) {
                val newUser = User(firstname, lastname, username, password)
                viewModel.signUp(listOf(newUser))
                Toast.makeText(v.context, "Sign Up berhasil!", Toast.LENGTH_SHORT).show()
                val action = SignUpFragmentDirections.actionloginFragment()
                Navigation.findNavController(v).navigate(action)
            } else {
                Toast.makeText(v.context, "Username sudah terdaftar!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onButtonBack(v: View) {
        val action = SignUpFragmentDirections.actionloginFragment()
        Navigation.findNavController(v).navigate(action)
    }
}
