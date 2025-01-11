package com.example.esportapps_uts.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ProposalDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProposal(proposal: Proposal)

    @Query("SELECT * FROM Proposal")
    fun getAllProposals(): List<Proposal>
}
