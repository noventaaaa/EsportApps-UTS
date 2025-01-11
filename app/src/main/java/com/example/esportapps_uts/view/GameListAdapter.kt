package com.example.esportapps_uts.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.esportapps_uts.R
import com.example.esportapps_uts.databinding.GameListItemBinding
import com.example.esportapps_uts.model.Game

class GameListAdapter(private val gameList: ArrayList<Game>) :
    RecyclerView.Adapter<GameListAdapter.GameViewHolder>(), GameCardListener {

    class GameViewHolder(var view: GameListItemBinding) : RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<GameListItemBinding>(
            inflater,
            R.layout.game_list_item,
            parent,
            false
        )
        return GameViewHolder(view)
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        holder.view.game = gameList[position]
        holder.view.gamecardlistener = this
        holder.view.root.tag = gameList[position].idgame
    }

    override fun getItemCount(): Int = gameList.size

    fun updateGameList(newGameList: List<Game>) {
        gameList.clear()
        gameList.addAll(newGameList)
        notifyDataSetChanged()
    }

    fun onGameCard(view: View) {
        val gameId = view.tag?.toString()?.toIntOrNull()
        if (gameId != null) {
            val action = GamesListFragmentDirections.actionTeamList(gameId)
            Navigation.findNavController(view).navigate(action)
        } else {
            // Log atau handle error jika tag tidak valid
        }
    }
    override fun onGameTeam(view: View, game: Game) {
        // Implementasi tindakan untuk "Team"
        val action = GamesListFragmentDirections.actionTeamList(game.idgame)
        Navigation.findNavController(view).navigate(action)
    }

    override fun onGameAchievements(view: View, game: Game) {
        // Implementasi tindakan untuk "Achievements"
        val action = GamesListFragmentDirections.actionAchievementsList(game.idgame)
        Navigation.findNavController(view).navigate(action)
    }




}
