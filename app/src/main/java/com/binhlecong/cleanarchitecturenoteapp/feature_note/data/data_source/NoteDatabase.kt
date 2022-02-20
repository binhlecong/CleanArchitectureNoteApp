package com.binhlecong.cleanarchitecturenoteapp.feature_note.data.data_source

import androidx.room.Database
import androidx.room.Entity
import com.binhlecong.cleanarchitecturenoteapp.feature_note.domain.model.Note

@Database(
    entities = [Note::class],
    version = 1
)
abstract class NoteDatabase {
    abstract val noteDao: NoteDao
}