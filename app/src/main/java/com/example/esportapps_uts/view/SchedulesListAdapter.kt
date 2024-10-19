package com.example.esportapps_uts.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.esportapps_uts.databinding.SchedulesListItemBinding
import com.example.esportapps_uts.model.Schedule


class SchedulesListAdapter(val scheduleList: ArrayList<Schedule>)
    : RecyclerView.Adapter<SchedulesListAdapter.ScheduleViewHolder>() {
    class ScheduleViewHolder(var binding: SchedulesListItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder {
        val binding = SchedulesListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ScheduleViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return scheduleList.size
    }

    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int) {
        holder.binding.txtMonth.text = scheduleList[position].month
        holder.binding.txtDate.text = scheduleList[position].date
        holder.binding.txtEvent.text = scheduleList[position].event
        holder.binding.txtTeam.text = scheduleList[position].team

    }

    fun updateScheduleList(newScheduleList: ArrayList<Schedule>) {
        scheduleList.clear()
        scheduleList.addAll(newScheduleList)
        notifyDataSetChanged()
    }

}
