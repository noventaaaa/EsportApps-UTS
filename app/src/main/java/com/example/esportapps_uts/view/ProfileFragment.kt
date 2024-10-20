package com.example.esportapps_uts.view

import android.animation.ValueAnimator
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.esportapps_uts.R
import com.example.esportapps_uts.databinding.FragmentProfileBinding
import com.example.esportapps_uts.model.Game
import com.example.esportapps_uts.view.GameListAdapter.GameViewHolder


class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    val like = 18
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLike.setOnClickListener{

            val action = ProfileFragmentDirections.actionAddLike()
            Navigation.findNavController(it).navigate(action)
        }


    }





}