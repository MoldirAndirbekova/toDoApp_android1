package com.example.first_lesson

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.example.first_lesson.databinding.FragmentNewTaskSheetBinding

class NewTaskSheet(var taskItem: TaskItem?) : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentNewTaskSheetBinding
    private lateinit var taskViewModel: TaskViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activity = requireActivity()

        if (taskItem != null) {
            binding.taskTitle.text = "Edit the task"
            val editable = Editable.Factory.getInstance()
            binding.name.text = editable.newEditable(taskItem!!.name)
            binding.taskDesc.text = editable.newEditable(taskItem!!.desc)
        }
        else {
            binding.taskTitle.text = "Add a new task"
        }
        taskViewModel = ViewModelProvider(activity).get(TaskViewModel::class.java)
        binding.saveButton.setOnClickListener{
            saveAction()
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewTaskSheetBinding.inflate(inflater,container,false)
        return binding.root
    }

    private fun saveAction() {
        val name = binding.name.text.toString()
        val desc = binding.taskDesc.text.toString()
        if (taskItem == null) {
            val newTask = TaskItem(name, desc, null, null)
            taskViewModel.addTaskItem(newTask)
        }
        else {
            taskViewModel.updateTaskItem(taskItem!!.id, name, desc, null)
        }
        binding.name.setText("")
        binding.taskDesc.setText("")
        dismiss()
    }


}