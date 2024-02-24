package com.example.first_lesson

interface TaskitemClickListener {
    fun editTaskItem(taskItem: TodoItem)
    fun completeTaskItem(taskItem: TodoItem)
}