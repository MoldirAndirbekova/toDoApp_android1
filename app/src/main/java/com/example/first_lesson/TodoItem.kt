package com.example.first_lesson

import android.content.Context
import androidx.core.content.ContextCompat
import java.time.LocalDate
import java.time.LocalTime
import java.util.UUID

class TodoItem(
    var name: String,
    var desc: String,
    var dueTime: LocalTime?,
    var completedDay: LocalDate?,
    var id: UUID = UUID.randomUUID()
) {
    fun isCompleted() = completedDay != null
    fun imageResource(): Int = if(isCompleted()) R.drawable.checked_24 else R.drawable.unchecked_24
    fun imageColor(context: Context): Int = if(isCompleted()) purple(context) else black(context)

    private fun purple(context: Context) = ContextCompat.getColor(context, R.color.purple)
    private fun black(context: Context) = ContextCompat.getColor(context, R.color.black)

}