package com.example.esportapps_uts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.esportapps_uts.R
import com.example.esportapps_uts.databinding.FragmentGamesListBinding
import com.example.esportapps_uts.databinding.FragmentTeamListBinding
import com.example.esportapps_uts.viewmodel.ListViewModel
import com.example.esportapps_uts.viewmodel.TeamViewModel


class TeamListFragment : Fragment() {
    private lateinit var viewModel: TeamViewModel
    //private val teamListAdapter = TeamListAdapter(arrayListOf())
    private lateinit var binding: FragmentTeamListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTeamListBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
//        viewModel.refresh()
//        binding.recView.layoutManager = LinearLayoutManager(context)
//        binding.recView.adapter = gameListAdapter
//        observeViewModel()
    }

    fun observeViewModel() {
//        viewModel.gameLD.observe(viewLifecycleOwner, Observer { gameListAdapter.updateGameList(it) })
//        viewModel.loadingLD.observe(viewLifecycleOwner, Observer {
//            if(it == true) {
//                binding.recView.visibility = View.GONE
//                binding.progressLoad.visibility = View.VISIBLE
//            } else {
//                binding.recView.visibility = View.VISIBLE
//                binding.progressLoad.visibility = View.GONE
//            }
//        })

    }


}