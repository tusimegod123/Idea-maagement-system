package com.flhub.ideams.models;




import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "notes")
public class Note {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long NoteId;

    private String comment;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
   // @JoinColumn(name = "ideaId", insertable = false, updatable = false)
   // private Idea idea;
    @JoinColumn(name="ideaId" , insertable = false, updatable = false)
    private Idea idea;

    private String ideaId;

    public Long getNoteId() {
        return NoteId;
    }

    public void setNoteId(Long noteId) {
        NoteId = noteId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Idea getIdea() {
        return idea;
    }

    public void setIdea(Idea idea) {
        this.idea = idea;
    }

    public String getIdeaId() {
        return ideaId;
    }

    public void setIdeaId(String ideaId) {
        this.ideaId = ideaId;
    }

    public Note(Long noteId, String comment, Idea idea, String ideaId) {
        NoteId = noteId;
        this.comment = comment;
        this.idea = idea;
        this.ideaId = ideaId;
    }

    @Override
    public String toString() {
        return "Note [NoteId=" + NoteId + ", comment=" + comment + ", idea=" + idea + ", ideaId=" + ideaId + "]";
    }

    public Note (){

    }
    
}
