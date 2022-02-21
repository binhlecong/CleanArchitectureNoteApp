package com.binhlecong.cleanarchitecturenoteapp.feature_note.domain.use_case

import com.binhlecong.cleanarchitecturenoteapp.feature_note.domain.model.InvalidNoteException
import com.binhlecong.cleanarchitecturenoteapp.feature_note.domain.model.Note
import com.binhlecong.cleanarchitecturenoteapp.feature_note.domain.repository.NoteRepository

class AddNoteUseCase(
    private val repository: NoteRepository
) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank()) {
            throw InvalidNoteException("The title cannot be empty")
        }
        if (note.content.isBlank()) {
            throw InvalidNoteException("The content cannot be empty")
        }
        if (note.title.length > 200) {
            throw InvalidNoteException("The title cannot be more than 256 characters")
        }
        repository.insertNote(note)
    }
}