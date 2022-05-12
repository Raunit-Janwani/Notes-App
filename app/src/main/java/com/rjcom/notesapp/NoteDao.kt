package com.rjcom.notesapp

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note : Note)
    @Delete
    suspend fun delete(note: Note)
    @Query("SELECT * from notes_table order by id asc")
    fun getAllNotes(): LiveData<List<Note>>
}