package com.example.esportapps_uts.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.esportapps_uts.databinding.FragmentGamesListBinding
import com.example.esportapps_uts.viewmodel.GameViewModel

class GamesListFragment : Fragment(), ProgressBarListener {

    private lateinit var viewModel: GameViewModel
    private val gameListAdapter = GameListAdapter(arrayListOf())
    private lateinit var binding: FragmentGamesListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGamesListBinding.inflate(inflater, container, false)
        binding.progressBarListener = this // Menghubungkan ProgressBarListener ke binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inisialisasi ViewModel
        viewModel = ViewModelProvider(this).get(GameViewModel::class.java)
        viewModel.refresh()

        // Setup RecyclerView
        binding.recView.layoutManager = LinearLayoutManager(context)
        binding.recView.adapter = gameListAdapter

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.gamesLD.observe(viewLifecycleOwner, Observer { games ->
            games?.let {
                if (it.isNotEmpty()) {
                    gameListAdapter.updateGameList(it)
                    binding.recView.visibility = View.VISIBLE
                    Log.d("GamesListFragment", "Games loaded successfully: ${it.size}")
                } else {
                    binding.recView.visibility = View.GONE
                    Toast.makeText(
                        requireContext(),
                        "No games found.",
                        Toast.LENGTH_SHORT
                    ).show()
                    Log.d("GamesListFragment", "No games available.")
                }
            } ?: run {
                binding.recView.visibility = View.GONE
                Log.d("GamesListFragment", "Games data is null.")
            }
        })

        viewModel.loadingLD.observe(viewLifecycleOwner, Observer { isLoading ->
            binding.progressLoad.visibility = if (isLoading) View.VISIBLE else View.GONE
            if (isLoading) {
                binding.recView.visibility = View.GONE
                Log.d("GamesListFragment", "Loading games...")
            } else {
                Log.d("GamesListFragment", "Loading complete.")
            }
        })

        viewModel.errorLD.observe(viewLifecycleOwner, Observer { isError ->
            if (isError) {
                binding.recView.visibility = View.GONE
                binding.progressLoad.visibility = View.GONE
                Toast.makeText(
                    requireContext(),
                    "Failed to load games. Please try again.",
                    Toast.LENGTH_SHORT
                ).show()
                Log.e("GamesListFragment", "Error occurred while loading games.")
            }
        })
    }

    override fun onProgressBarClick(view: View, isVisible: Boolean, message: String?) {
        if (isVisible) {
            view.visibility = View.VISIBLE
            message?.let {
                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            }
        } else {
            view.visibility = View.GONE
        }
    }
}
