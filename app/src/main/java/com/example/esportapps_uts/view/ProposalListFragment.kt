package com.example.esportapps_uts.view

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.esportapps_uts.R
import com.example.esportapps_uts.databinding.FragmentProposalListBinding
import com.example.esportapps_uts.viewmodel.ListViewModel
import com.example.esportapps_uts.viewmodel.UserViewModel


class ProposalListFragment : Fragment() {
    private lateinit var viewModel: ListViewModel
    private lateinit var dataBinding: FragmentProposalListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //dataBinding = DataBindingUtil.inflate<FragmentProposalListBinding>(inflater, R.layout.fragment_proposal_list,container, false)
        return dataBinding.root

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)


        var sharedFile = requireActivity().packageName
        var shared: SharedPreferences = requireActivity().getSharedPreferences(sharedFile, Context.MODE_PRIVATE)

    }


}