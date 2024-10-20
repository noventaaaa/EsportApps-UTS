package com.example.esportapps_uts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.esportapps_uts.databinding.FragmentSchedulesListBinding
import com.example.esportapps_uts.viewmodel.ListScheduleViewModel


class SchedulesListFragment : Fragment() {

    private lateinit var scheduleviewModel: ListScheduleViewModel
    private val SchedulesListAdapter = SchedulesListAdapter(arrayListOf())
    private lateinit var binding: FragmentSchedulesListBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSchedulesListBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        scheduleviewModel = ViewModelProvider(this).get(ListScheduleViewModel::class.java)
        scheduleviewModel.refresh()
        binding.recView.layoutManager = LinearLayoutManager(context)
        binding.recView.adapter = SchedulesListAdapter
        observeViewModel()


    }

    fun observeViewModel() {
        scheduleviewModel.scheduleLD.observe(viewLifecycleOwner, Observer {
            SchedulesListAdapter.updateScheduleList(it) })

        scheduleviewModel.loadingLD.observe(viewLifecycleOwner, Observer {
            if(it == true) {
                binding.recView.visibility = View.GONE
                binding.progressLoad.visibility = View.VISIBLE
            } else {
                binding.recView.visibility = View.VISIBLE
                binding.progressLoad.visibility = View.GONE
            }
        })

    }

}