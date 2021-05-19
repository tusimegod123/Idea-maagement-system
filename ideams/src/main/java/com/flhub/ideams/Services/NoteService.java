package com.flhub.ideams.Services;

import java.util.Optional;

import com.flhub.ideams.Repository.NoteRepository;
import com.flhub.ideams.models.Note;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class NoteService  {

    @Autowired
    NoteRepository noteRepository;

    public <S extends Note> S save(S entity) {
        return noteRepository.save(entity);
    }

    public <S extends Note> Iterable<S> saveAll(Iterable<S> entities) {
        return noteRepository.saveAll(entities);
    }

    public Optional<Note> findById(Long id) {
        return noteRepository.findById(id);
    }

    public boolean existsById(Long id) {
        return noteRepository.existsById(id);
    }

    public Iterable<Note> findAll() {
        return noteRepository.findAll();
    }

    public Iterable<Note> findAllById(Iterable<Long> ids) {
        return noteRepository.findAllById(ids);
    }

    public long count() {
        return noteRepository.count();
    }

    public void deleteById(Long id) {
        noteRepository.deleteById(id);
    }

    public void delete(Note entity) {
        noteRepository.delete(entity);
    }

    public void deleteAll(Iterable<? extends Note> entities) {
        noteRepository.deleteAll(entities);
    }

    public void deleteAll() {
        noteRepository.deleteAll();
    }

    
    
    
}
