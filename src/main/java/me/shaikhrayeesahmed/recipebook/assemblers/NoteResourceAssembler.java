package me.shaikhrayeesahmed.recipebook.assemblers;

import me.shaikhrayeesahmed.recipebook.controllers.NoteController;
import me.shaikhrayeesahmed.recipebook.domains.Note;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class NoteResourceAssembler implements ResourceAssembler<Note, Resource<Note>> {

    @Override
    public Resource<Note> toResource(Note note) {
        return new Resource<>(note,
                linkTo(methodOn(NoteController.class).one(note.getRecipe().getId(), note.getId())).withSelfRel(),
                linkTo(methodOn(NoteController.class).all(note.getRecipe().getId())).withRel("notes"));
    }

}
