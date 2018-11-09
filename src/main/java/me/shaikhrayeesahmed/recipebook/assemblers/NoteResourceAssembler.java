package me.shaikhrayeesahmed.recipebook.assemblers;

import me.shaikhrayeesahmed.recipebook.domains.Note;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;

public class NoteResourceAssembler implements ResourceAssembler<Note, Resource<Note>> {

    @Override
    public Resource<Note> toResource(Note note) {
        return null;
    }

}
