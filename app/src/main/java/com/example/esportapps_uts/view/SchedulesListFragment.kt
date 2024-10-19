package com.example.esportapps_uts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.esportapps_uts.databinding.FragmentSchedulesListBinding
import com.example.esportapps_uts.viewmodel.ListScheduleViewModel


class SchedulesListFragment : Fragment() {

//    private lateinit var viewModel: ListScheduleViewModel
//    private val ScheduleListAdapter = SchedulesListAdapter(arrayListOf())
//    private lateinit var binding: FragmentSchedulesListBinding
//
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        binding = FragmentSchedulesListBinding.inflate(inflater,container, false)
//        return binding.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//       // viewModel = ListScheduleViewModel(this).get(ListScheduleViewModel::class.java)
//        viewModel.refresh()
//        binding.recView.layoutManager = LinearLayoutManager(context)
//        binding.recView.adapter = ScheduleListAdapter
//        //observeViewModel()
//
//
//    }

//    fun observeViewModel() {
//        viewModel.LD.observe(viewLifecycleOwner, Observer { ScheduleListAdapter.updateScheduleList(it) })
//        viewModel.loadingLD.observe(viewLifecycleOwner, Observer {
//            if(it == true) {
//                binding.recView.visibility = View.GONE
//                binding.progressLoad.visibility = View.VISIBLE
//            } else {
//                binding.recView.visibility = View.VISIBLE
//                binding.progressLoad.visibility = View.GONE
//            }
//        })
//
//    }

}