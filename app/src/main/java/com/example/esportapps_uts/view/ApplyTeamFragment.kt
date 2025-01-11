

package com.example.esportapps_uts.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.esportapps_uts.databinding.FragmentApplyTeamBinding
import com.example.esportapps_uts.model.Proposal
import com.example.esportapps_uts.model.Team
import com.example.esportapps_uts.viewModel.ApplyTeamViewModel
import com.example.esportapps_uts.util.listTeams

class ApplyTeamFragment : Fragment() {

    private lateinit var binding: FragmentApplyTeamBinding
    private lateinit var viewModel: ApplyTeamViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentApplyTeamBinding.inflate(inflater, container, false) // Inisialisasi binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(ApplyTeamViewModel::class.java)

        viewModel.insertTeamsToDatabase(listTeams)

        viewModel.getGames()
        viewModel.getAllTeamGroups()


        viewModel.gamesLiveData.observe(viewLifecycleOwner) { games ->
            val gameNames = games.map { it.name ?: "" }
            val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, gameNames)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spinChooseGame.adapter = adapter
        }

        viewModel.teamsLiveData.observe(viewLifecycleOwner) { teamGroups ->
            if (teamGroups.isNotEmpty()) {
                val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, teamGroups)
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                binding.spinChooseTeam.adapter = adapter
            } else {
                Toast.makeText(requireContext(), "No team groups available", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnApplyTeam.setOnClickListener {
            val selectedGame = binding.spinChooseGame.selectedItem?.toString() ?: ""
            val selectedTeam = binding.spinChooseTeam.selectedItem?.toString() ?: ""
            val description = binding.textView9.text.toString()

            if (selectedGame.isNotEmpty() && selectedTeam.isNotEmpty() && description.isNotEmpty()) {
                val newProposal = Proposal(
                    gameName = selectedGame,
                    teamName = selectedTeam,
                    reason = description,
                    status = "WAITING"
                )
                viewModel.insertProposal(newProposal) // Memasukkan proposal ke database

                Toast.makeText(requireContext(), "Proposal submitted to $selectedTeam in $selectedGame", Toast.LENGTH_SHORT).show()

                // Reset form jika diperlukan
                binding.spinChooseGame.setSelection(0)
                binding.spinChooseTeam.setSelection(0)
                binding.textView9.text.clear()
            } else {
                Toast.makeText(requireContext(), "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }


    }
}
