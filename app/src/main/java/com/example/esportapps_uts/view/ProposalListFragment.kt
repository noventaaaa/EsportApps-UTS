package com.example.esportapps_uts.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.esportapps_uts.R
import com.example.esportapps_uts.databinding.FragmentProposalListBinding
import com.example.esportapps_uts.viewModel.ProposalViewModel

class ProposalListFragment : Fragment() {

    private lateinit var binding: FragmentProposalListBinding
    private lateinit var viewModel: ProposalViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProposalListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(ProposalViewModel::class.java)

        binding.recyclerViewProposals.layoutManager = LinearLayoutManager(requireContext())

        viewModel.proposalsLiveData.observe(viewLifecycleOwner) { proposals ->
            val adapter = ProposalAdapter(proposals) { updatedProposal ->
                viewModel.updateProposal(updatedProposal)
                Toast.makeText(requireContext(), "Status updated", Toast.LENGTH_SHORT).show()
            }
            binding.recyclerViewProposals.adapter = adapter
        }


        viewModel.loadProposals()

        binding.fabAddProposal.setOnClickListener {
            findNavController().navigate(R.id.action_proposalListFragment_to_applyTeamFragment)
        }
    }
}
