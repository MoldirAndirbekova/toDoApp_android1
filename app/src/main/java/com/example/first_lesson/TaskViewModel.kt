package com.example.first_lesson

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.time.LocalDate
import java.time.LocalTime
import java.util.UUID

class TaskViewModel: ViewModel() {

    var taskItems = MutableLiveData<MutableList<TodoItem>>()

    init {
        taskItems.value = mutableListOf()
    }

    fun addTaskItem(newTaskItem: TodoItem) {
        var list = taskItems.value
        list!!.add(newTaskItem)
        taskItems.postValue(list)
    }
    fun updateTaskItem(id: UUID, name: String, desc: String, dueTime: LocalTime?)
    {
        val list = taskItems.value
        val task = list!!.find { it.id == id }!!
        task.name = name
        task.desc = desc
        task.dueTime = dueTime
        taskItems.postValue(list)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun setCompleted(taskItem: TodoItem)
    {
        val list = taskItems.value
        val task = list!!.find { it.id == taskItem.id }!!
        if (task.completedDay == null)
            task.completedDay = LocalDate.now()
        taskItems.postValue(list)
    }

    fun deleteTaskItem(taskId: UUID) {
        val list = taskItems.value ?: return
        val newList = list.filter { it.id != taskId }
        taskItems.postValue(newList.toMutableList())
    }
}