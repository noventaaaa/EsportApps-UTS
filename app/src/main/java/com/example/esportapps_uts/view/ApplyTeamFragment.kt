package com.example.esportapps_uts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.esportapps_uts.R


class ApplyTeamFragment : Fragment() {

    //private lateinit var viewModel: DetailTodoViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_apply_team, container, false)
    }
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        viewModel = ViewModelProvider(this)
//            .get(DetailTodoViewModel::class.java)
//
//        val btnAdd = view.findViewById<Button>(R.id.)
//
//        btnAdd.setOnClickListener {
//            val txtTitle = view.findViewById<EditText>(R.id.)
//            val txtNotes = view.findViewById<EditText>(R.id.txtNotes)
//            val group = view.findViewById<RadioGroup>(R.id.radioGroupPriority)
//            val radio = view.findViewById<RadioButton>(group.checkedRadioButtonId)
//
//            val todo = Todo(txtTitle.text.toString(), txtNotes.text.toString(), radio.tag.toString().toInt())
//            viewModel.addTodo(todo)
//
//            Toast.makeText(view.context, "Todo created", Toast.LENGTH_LONG).show()
//            Navigation.findNavController(it).popBackStack()
//
//        }
//
//    }


}