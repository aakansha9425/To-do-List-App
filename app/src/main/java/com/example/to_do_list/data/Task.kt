package com.example.to_do_list.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.text.DateFormat

@Entity(tableName = "task_table")
@Parcelize
data class Task(
    val taskName: String,
    val isCompleted: Boolean = false,
    val isImportant: Boolean = false,
    val createdAt: Long = System.currentTimeMillis(),
    @PrimaryKey(autoGenerate = true) val id: Int = 0
) : Parcelable {
    val createdAtDateFormat: String
        get() = DateFormat.getDateTimeInstance().format(createdAt)
}