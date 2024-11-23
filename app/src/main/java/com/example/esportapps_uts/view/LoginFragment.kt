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
    companion object{
        val EXTRA_USERNAME = "USERNAME"
    }
    private lateinit var viewModel: UserViewModel
    private lateinit var dataBinding:FragmentLoginBinding
    lateinit var shared: SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_login,container,false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var sharedFile = requireActivity().packageName
        shared = requireActivity().getSharedPreferences(sharedFile, Context.MODE_PRIVATE)
        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
//        //retrive saved username
//
        var savedUsername = shared.getString(LoginFragment.EXTRA_USERNAME, "")
        savedUsername?.let {
            if (it.isNotEmpty()){
                val action = LoginFragmentDirections.actionToItemGameList()
                Navigation.findNavController(view).navigate(action)
            }
        }


        dataBinding.user = User("","","","")
        dataBinding.loginlistener = this
        dataBinding.signuplistener = this

        //save username
//        var editor: SharedPreferences.Editor = shared.edit()
//        editor.putString(EXTRA_USERNAME,username)
//        editor.apply()
    }


    override fun onTextCreateAcc(v: View) {
        val action = LoginFragmentDirections.actionsignUpFragment()
        Navigation.findNavController(v).navigate(action)
    }

    override fun onButtonLogin(v: View) {
        var objUser:User = dataBinding.user!!
        viewModel.login(objUser.username, objUser.password)

        viewModel.userLD.observe(viewLifecycleOwner, Observer {
            if (it == null){
                val alert = AlertDialog.Builder(v.context)
                alert.setTitle("ALERT!")
                alert.setMessage("Username or password does not match out database")
                alert.setPositiveButton("OK") { _,_ ->}
                alert.show()
            }else{
                dataBinding.user = it
                Toast.makeText(v.context, "Sign In Succeed", Toast.LENGTH_SHORT).show()
                var editor: SharedPreferences.Editor = shared.edit()
                editor.putString(EXTRA_USERNAME,it.username)
                editor.apply()
                val action = LoginFragmentDirections.actionToItemGameList()
                Navigation.findNavController(v).navigate(action)
            }
        })
    }

}