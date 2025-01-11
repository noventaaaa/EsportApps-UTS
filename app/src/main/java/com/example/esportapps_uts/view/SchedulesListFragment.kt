package com.example.esportapps_uts.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.esportapps_uts.adapter.ScheduleAdapter
import com.example.esportapps_uts.databinding.FragmentSchedulesListBinding
import com.example.esportapps_uts.viewmodel.ScheduleViewModel

class SchedulesListFragment : Fragment() {

    private lateinit var binding: FragmentSchedulesListBinding
    private lateinit var viewModel: ScheduleViewModel
    private lateinit var scheduleAdapter: ScheduleAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSchedulesListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(ScheduleViewModel::class.java)
        scheduleAdapter = ScheduleAdapter(emptyList())

        // Set up RecyclerView
        binding.recViewSchedule.layoutManager = LinearLayoutManager(requireContext())
        binding.recViewSchedule.adapter = scheduleAdapter

        // Observe LiveData from ViewModel
        viewModel.scheduleLD.observe(viewLifecycleOwner) { schedules ->
            scheduleAdapter.updateSchedules(schedules) // Update adapter with new data
            binding.progressLoad.visibility = View.GONE // Hide progress bar
        }

        // SwipeRefreshLayout to reload data
        binding.swipeRefreshLayout.setOnRefreshListener {
            binding.progressLoad.visibility = View.VISIBLE
            viewModel.scheduleLD.observe(viewLifecycleOwner) { schedules ->
                scheduleAdapter.updateSchedules(schedules)
                binding.swipeRefreshLayout.isRefreshing = false // Stop refresh indicator
            }
        }
    }
}
