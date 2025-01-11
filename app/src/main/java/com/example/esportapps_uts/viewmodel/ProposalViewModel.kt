package com.example.esportapps_uts.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.esportapps_uts.model.GameDatabase
import com.example.esportapps_uts.model.Proposal
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProposalViewModel(application: Application) : AndroidViewModel(application) {

    private val proposalDao = GameDatabase.getInstance(application).proposalDao()
    private val _proposalsLiveData = MutableLiveData<List<Proposal>>()
    val proposalsLiveData: LiveData<List<Proposal>> get() = _proposalsLiveData

    fun loadProposals() {
        viewModelScope.launch(Dispatchers.IO) {
            val proposals = proposalDao.getAllProposals()
            _proposalsLiveData.postValue(proposals)
        }
    }

    fun updateProposal(proposal: Proposal) {
        viewModelScope.launch(Dispatchers.IO) {
            proposalDao.insertProposal(proposal)
        }
    }


    fun insertProposal(proposal: Proposal) {
        viewModelScope.launch(Dispatchers.IO) {
            proposalDao.insertProposal(proposal)
            loadProposals()
        }
    }
}
