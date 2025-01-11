package com.example.esportapps_uts.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.esportapps_uts.R
import com.example.esportapps_uts.databinding.FragmentAchievementsBinding
import com.example.esportapps_uts.model.Achievement
import com.example.esportapps_uts.util.listAchievements
import com.example.esportapps_uts.viewmodel.AchievementViewModel

class AchievementsFragment : Fragment() {
    private lateinit var binding: FragmentAchievementsBinding
    private lateinit var viewModel: AchievementViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_achievements, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(AchievementViewModel::class.java)

        val gameId = arguments?.getInt("gameId") ?: 0

        observeViewModel(gameId)

        viewModel.refresh(gameId)
    }

    private fun observeViewModel(gameId: Int) {
        viewModel.achievementsLD.observe(viewLifecycleOwner) { achievements ->
            if (!achievements.isNullOrEmpty()) {
                setupSpinner(achievements)
                bindAchievement(achievements.first())
            } else {
                val fallbackAchievements = listAchievements.filter { it.idgame == gameId }
                if (fallbackAchievements.isNotEmpty()) {
                    setupSpinner(fallbackAchievements)
                    bindAchievement(fallbackAchievements.first())
                } else {
                    clearAchievementDisplay()
                }
            }
        }

        viewModel.loadingLD.observe(viewLifecycleOwner) { isLoading ->
            binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
        }

        viewModel.errorLD.observe(viewLifecycleOwner) { isError ->
            if (isError) {
                clearAchievementDisplay()
            }
        }
    }

    private fun setupSpinner(achievements: List<Achievement>) {
        val years = listOf("All") + achievements.mapNotNull { it.year?.toString() }.distinct()
        val spinnerAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, years)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinYears.adapter = spinnerAdapter

        binding.spinYears.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedYear = years[position]
                val filteredAchievements = if (selectedYear == "All") {
                    achievements
                } else {
                    achievements.filter { it.year?.toString() == selectedYear }
                }

                if (filteredAchievements.isNotEmpty()) {
                    bindAchievement(filteredAchievements.first())
                } else {
                    clearAchievementDisplay()
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Do nothing
            }
        }
    }

    private fun bindAchievement(achievement: Achievement) {
        binding.txtName.text = achievement.name
        binding.txtAchievement.text = "${achievement.description} (${achievement.year}) - ${achievement.team}"
    }

    private fun clearAchievementDisplay() {
        binding.txtName.text = "No Achievement Found"
        binding.txtAchievement.text = ""
    }
}
