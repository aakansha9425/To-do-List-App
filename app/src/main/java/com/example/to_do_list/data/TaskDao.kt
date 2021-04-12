package com.example.to_do_list.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow


@Dao
interface TaskDao {

    //Dao contains all the table operation such as insert delete display modify etc

    @Query("SELECT * FROM TASK_TABLE")
    fun getTasks():Flow<List<Task>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(task: Task)

    @Update
    suspend fun update(task: Task)

    @Delete
    suspend fun delete(task: Task)
}