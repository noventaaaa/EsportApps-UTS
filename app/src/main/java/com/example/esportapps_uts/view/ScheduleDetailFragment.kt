package com.example.esportapps_uts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.esportapps_uts.R
import com.example.esportapps_uts.databinding.FragmentScheduleDetailBinding


class ScheduleDetailFragment : Fragment() {
    private lateinit var binding: FragmentScheduleDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentScheduleDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val name = arguments?.getString("name")
        val id = arguments?.getString("id")
        val phone = arguments?.getString("phone")
        val dob = arguments?.getString("dob")

//        val student = Student(id, name, dob, phone, photoUrl" ")
//        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
//        viewModel.refresh()
//        binding.recView.layoutManager = LinearLayoutManager(context)
//        binding.recView.adapter = studentListAdapter
//
//        viewModel.fetch()
//        observeViewModel()
    }

    private fun observeViewModel() {
//        viewModel.studentsLD.observe(viewLifecycleOwner, Observer(viewLifecycleOwner, observer{
//            binding.txtName.setText(it.name)
//
//
//        })
//        viewModel.studentsLD.observe(viewLifecycleOwner, Observer {studentListAdapter.updateStudentList(it)})
//        viewModel.studentLD.observe(viewLifecycleOwner, Observer {
//            binding.txtName.setText(it.name)
//            binding.txtBod.setText(it.dob)
//            binding.txtPhone.setText(it.phone)
//            binding.txtID.setText(it.id)
//
//        })

    }


}