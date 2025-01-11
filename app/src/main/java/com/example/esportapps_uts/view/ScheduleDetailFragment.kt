package com.example.esportapps_uts.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.esportapps_uts.databinding.FragmentScheduleDetailBinding
import com.example.esportapps_uts.model.Schedule

class ScheduleDetailFragment : Fragment() {

    private lateinit var binding: FragmentScheduleDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentScheduleDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val schedule = arguments?.getSerializable("schedule") as Schedule

        // Update UI sesuai dengan data schedule
        binding.txtEventName.text = schedule.eventName
        binding.txtTeamName.text = schedule.teamName

    }
}
