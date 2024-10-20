package com.example.esportapps_uts.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
//import com.example.esportapps_uts.databinding.AchievementsListItemBinding
import com.example.esportapps_uts.model.Achievement
import com.example.esportapps_uts.model.Game
import com.example.esportapps_uts.util.loadImage

//class AchievementsAdapter(val achList:ArrayList<Achievement>)
 //   : RecyclerView.Adapter<AchievementsAdapter.AchievementsViewHolder>() {
//    class AchievementsViewHolder(var binding: AchievementsListItemBinding)
//        : RecyclerView.ViewHolder(binding.root)
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AchievementsViewHolder {
//        val binding = Achievement.inflate(LayoutInflater.from(parent.context), parent, false)
//        return AchievementsViewHolder(binding)
//    }
//
//    override fun getItemCount(): Int {
//        return achList.size
//    }
//
//    override fun onBindViewHolder(holder: AchievementsViewHolder, position: Int) {
//        holder.binding.txtName.text = achList[position].name
//        holder.binding.txtAchievement.text = achList[position].
//        holder.binding.imgGame.loadImage(achList[position].photoUrl , holder.binding.progressBarGame)
//
//        holder.binding.spinYear.setOnClickListener {
//            val action = GamesListFragmentDirections.actionTeamList()
//            Navigation.findNavController(it).navigate(action)
//        }
//    }
//
//    fun updateAchievementList(newAchievementList: ArrayList<Achievement>) {
//        achList.clear()
//        achList.addAll(newAchievementList)
//        notifyDataSetChanged()
//    }
//}