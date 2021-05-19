package com.flhub.ideams.Repository;

import java.util.Optional;

import com.flhub.ideams.models.Note;

import org.springframework.data.repository.CrudRepository;

public interface NoteRepository extends CrudRepository<Note, Long> {

    // Optional<Note> findByIdAndIdeaId(Long noteId, String ideaId);
    
}
