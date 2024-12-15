package com.example.esportapps_uts.view

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.esportapps_uts.R
import com.example.esportapps_uts.databinding.FragmentGamesListBinding
import com.example.esportapps_uts.viewmodel.ListViewModel


class GamesListFragment : Fragment() {

    private lateinit var viewModel: ListViewModel
    private val gameListAdapter = GameListAdapter(arrayListOf())
    private lateinit var binding: FragmentGamesListBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGamesListBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        viewModel.refresh()
        binding.recView.layoutManager = LinearLayoutManager(context)
        binding.recView.adapter = gameListAdapter
        observeViewModel()


//        var sharedFile = requireActivity().packageName
//        var shared: SharedPreferences = requireActivity().getSharedPreferences(sharedFile, Context.MODE_PRIVATE)
//        var isFoodStored = shared.getString(EXTRA_GAME, "")
//        isFoodStored?.let {
//            if (it.isEmpty()){
//                val list= gameArray
//                viewModel.addGame(list.toList())
//                var editor: SharedPreferences.Editor = shared.edit()
//                editor.putString(EXTRA_GAME,"yes")
//                editor.apply()
//            }
//        }
//        var savedUsername = shared.getString(LoginFragment.EXTRA_USERNAME, "")
//        savedUsername?.let {
//            if (savedUsername!!.isNotEmpty()){
//                viewModel.refresh()
//
//                recView.layoutManager = LinearLayoutManager(context)
//                recView.adapter = gameListAdapter
//                observeViewModel()
//            }else{
//                val action = GamesListFragmentDirections.actionFoodToSignInFragment()
//                val navController = Navigation.findNavController(view)
////                navController.popBackStack()
//                navController.navigate(action)
//            }
//        }
    }

    fun observeViewModel() {
        viewModel.gameLD.observe(viewLifecycleOwner, Observer {
            gameListAdapter.updateGameList(it) })

        viewModel.loadingLD.observe(viewLifecycleOwner, Observer {
            if(it) {
                binding.recView.visibility = View.GONE
                binding.progressLoad.visibility = View.VISIBLE
            } else {
                binding.recView.visibility = View.VISIBLE
                binding.progressLoad.visibility = View.GONE
            }
        })

    }




}