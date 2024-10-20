package com.example.esportapps_uts.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.esportapps_uts.databinding.GameListItemBinding
import com.example.esportapps_uts.model.Game
import com.example.esportapps_uts.util.loadImage

class GameListAdapter(val gameList:ArrayList<Game>)
    : RecyclerView.Adapter<GameListAdapter.GameViewHolder>() {
    class GameViewHolder(var binding: GameListItemBinding)
        :RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val binding = GameListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GameViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return gameList.size
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        holder.binding.txtName.text = gameList[position].name
        holder.binding.txtDescription.text = gameList[position].description
//        holder.binding.imgGame.loadImage(gameList[position].photoUrl, holder.binding.progressBar)

        holder.binding.btnAchievements.setOnClickListener{
            val action = GamesListFragmentDirections.actionAchievementsList()
            Navigation.findNavController(it).navigate(action)
        }

        holder.binding.btnTeam.setOnClickListener {
            val action = GamesListFragmentDirections.actionTeamList()
            Navigation.findNavController(it).navigate(action)
        }
    }

    fun updateGameList(newGameList: ArrayList<Game>) {
        gameList.clear()
        gameList.addAll(newGameList)
        notifyDataSetChanged()
    }
}