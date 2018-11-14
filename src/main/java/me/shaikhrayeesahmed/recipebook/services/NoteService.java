package me.shaikhrayeesahmed.recipebook.services;

import me.shaikhrayeesahmed.recipebook.domains.Note;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;

public interface NoteService {

    Resources<Resource<Note>> findAll(Long recipeid);

    Resource<Note> find(Long recipeid, Long noteid);

    Resource<Note> save(Long recipeid, Note note);

    Resource<Note> update(Long recipeid, Long noteid, Note note);

    void delete(Long recipeid, Long noteid);

}
