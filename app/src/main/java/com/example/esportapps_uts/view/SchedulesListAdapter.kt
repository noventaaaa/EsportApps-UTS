package com.example.esportapps_uts.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.esportapps_uts.databinding.SchedulesListItemBinding
import com.example.esportapps_uts.model.Schedule

class ScheduleAdapter(private var schedules: List<Schedule>) : RecyclerView.Adapter<ScheduleAdapter.ScheduleViewHolder>() {

    inner class ScheduleViewHolder(private val binding: SchedulesListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(schedule: Schedule) {
            binding.schedule = schedule

//            // Navigasi ke ScheduleDetailFragment
//            binding.root.setOnClickListener {
//                val action = SchedulesListFragmentDirections.actionToScheduleDetailFragment(schedule)
//                Navigation.findNavController(binding.root).navigate(action)
//            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = SchedulesListItemBinding.inflate(inflater, parent, false)
        return ScheduleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int) {
        holder.bind(schedules[position])
    }

    override fun getItemCount(): Int = schedules.size

    fun updateSchedules(newSchedules: List<Schedule>) {
        schedules = newSchedules
        notifyDataSetChanged()
    }
}
