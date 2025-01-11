package com.example.esportapps_uts.view

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.esportapps_uts.R
import com.example.esportapps_uts.databinding.FragmentLoginBinding
import com.example.esportapps_uts.model.User
import com.example.esportapps_uts.viewmodel.UserViewModel

class LoginFragment : Fragment(), ButtonLoginListener, TextCreateAccListener {

    companion object {
        const val EXTRA_USERNAME = "USERNAME"
    }

    private lateinit var viewModel: UserViewModel
    private lateinit var dataBinding: FragmentLoginBinding
    private lateinit var shared: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedFile = requireActivity().packageName
        shared = requireActivity().getSharedPreferences(sharedFile, Context.MODE_PRIVATE)

        val savedUsername = shared.getString(EXTRA_USERNAME, "")
        if (!savedUsername.isNullOrEmpty()) {
            navigateToGameList(view)
            return
        }

        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        dataBinding.user = User("", "", "", "")
        dataBinding.loginlistener = this
        dataBinding.signuplistener = this
    }

    override fun onTextCreateAcc(v: View) {
        val action = LoginFragmentDirections.actionsignUpFragment()
        Navigation.findNavController(v).navigate(action)
    }

    override fun onButtonLogin(v: View) {
        val objUser: User = dataBinding.user!!
        viewModel.login(objUser.username, objUser.password)

        viewModel.userLD.observe(viewLifecycleOwner, Observer { loggedInUser ->
            if (loggedInUser == null) {
                // Show alert if login fails
                val alert = AlertDialog.Builder(v.context)
                    .setTitle("Login Failed")
                    .setMessage("Username or password does not match our database")
                    .setPositiveButton("OK", null)
                    .create()
                alert.show()
            } else {
                saveUserSession(loggedInUser.username)
                Toast.makeText(v.context, "Welcome ${loggedInUser.username}!", Toast.LENGTH_SHORT).show()
                navigateToGameList(v)
            }
        })
    }

    private fun saveUserSession(username: String) {
        val editor: SharedPreferences.Editor = shared.edit()
        editor.putString(EXTRA_USERNAME, username)
        editor.apply()
    }

    private fun navigateToGameList(v: View) {
        val action = LoginFragmentDirections.actionToItemGameList()
        Navigation.findNavController(v).navigate(action)
    }
}
