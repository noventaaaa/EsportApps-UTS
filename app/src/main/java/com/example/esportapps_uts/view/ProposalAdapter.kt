package com.example.esportapps_uts.view

package com.example.esportapps_uts.adapter

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.example.esportapps_uts.databinding.ProposalListItemBinding
import com.example.esportapps_uts.model.Proposal

class ProposalAdapter(
    private val proposals: List<Proposal>,
    private val onStatusUpdated: (Proposal) -> Unit
) : RecyclerView.Adapter<ProposalAdapter.ProposalViewHolder>() {

    inner class ProposalViewHolder(private val binding: ProposalListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(proposal: Proposal) {
            binding.proposal = proposal
            binding.spinnerStatus.setSelection(getStatusIndex(proposal.status))
            binding.spinnerStatus.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    val newStatus = parent?.getItemAtPosition(position).toString()
                    if (newStatus != proposal.status) {
                        showConfirmationDialog(newStatus) {
                            proposal.status = newStatus
                            onStatusUpdated(proposal)
                        }
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {}
            }
            binding.executePendingBindings()
        }

        private fun getStatusIndex(status: String): Int {
            return when (status) {
                "WAITING" -> 0
                "GRANTED" -> 1
                "DECLINED" -> 2
                else -> 0
            }
        }

        private fun showConfirmationDialog(newStatus: String, onConfirmed: () -> Unit) {
            AlertDialog.Builder(binding.root.context)
                .setTitle("Update Status")
                .setMessage("Are you sure you want to update the status to $newStatus?")
                .setPositiveButton("Yes") { _, _ -> onConfirmed() }
                .setNegativeButton("No", null)
                .show()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProposalViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ProposalListItemBinding.inflate(inflater, parent, false)
        return ProposalViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProposalViewHolder, position: Int) {
        holder.bind(proposals[position])
    }

    override fun getItemCount(): Int = proposals.size
}
