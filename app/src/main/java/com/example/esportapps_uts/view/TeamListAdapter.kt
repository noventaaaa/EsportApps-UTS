package com.example.esportapps_uts.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.esportapps_uts.databinding.GameListItemBinding
import com.example.esportapps_uts.model.Game
import com.example.esportapps_uts.model.Team
import com.example.esportapps_uts.view.GameListAdapter.GameViewHolder

//class TeamListAdapter(val teamList:ArrayList<Team>)
//    : RecyclerView.Adapter<TeamListAdapter.TeamViewHolder>() {
//    class TeamViewHolder(var binding: GameListItemBinding)
//        :RecyclerView.ViewHolder(binding.root)
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
//        val binding = GameListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return TeamViewHolder(binding)
//    }
//
//    override fun getItemCount(): Int {
//        return teamList.size
//    }
//
//    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
//        holder.binding.txtName.text = teamList[position].name
//        holder.binding.txtDescription.text = teamList[position].description
//
//        holder.binding.btnAchievements.setOnClickListener{
//            val action = GamesListFragmentDirections.actionAchievementsList()
//            Navigation.findNavController(it).navigate(action)
//        }
//
//        holder.binding.btnTeam.setOnClickListener {
//            val action = GamesListFragmentDirections.actionTeamList()
//            Navigation.findNavController(it).navigate(action)
//        }
//    }
//
//    fun updateGameList(newTeamList: ArrayList<Team>) {
//        teamList.clear()
//        teamList.addAll(newTeamList)
//        notifyDataSetChanged()
//    }
//}