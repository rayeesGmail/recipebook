package me.shaikhrayeesahmed.recipebook.services;

import me.shaikhrayeesahmed.recipebook.assemblers.NoteResourceAssembler;
import me.shaikhrayeesahmed.recipebook.controllers.NoteController;
import me.shaikhrayeesahmed.recipebook.domains.Note;
import me.shaikhrayeesahmed.recipebook.domains.Recipe;
import me.shaikhrayeesahmed.recipebook.repositories.NoteRepository;
import me.shaikhrayeesahmed.recipebook.repositories.RecipeRepository;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Service
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;
    private final NoteResourceAssembler noteResourceAssembler;
    private final RecipeRepository recipeRepository;

    public NoteServiceImpl(NoteRepository noteRepository, NoteResourceAssembler noteResourceAssembler,
                           RecipeRepository recipeRepository) {
        this.noteRepository = noteRepository;
        this.noteResourceAssembler = noteResourceAssembler;
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Resources<Resource<Note>> findAll(Long recipeid) {
        Optional<Recipe> optionalRecipe = recipeRepository.findById(recipeid);
        if(!optionalRecipe.isPresent()){
            throw new RuntimeException("no entity found");
        }

        Set<Resource<Note>> resources = noteRepository.findAllByRecipe(optionalRecipe.get()).stream()
                .map(noteResourceAssembler::toResource)
                .collect(Collectors.toSet());

        return new Resources<>(resources, linkTo(methodOn(NoteController.class).all(recipeid)).withSelfRel());

    }

    @Override
    public Resource<Note> find(Long recipeid, Long noteid) {

        Optional<Note> optionalNote = noteRepository.findById(noteid);

        if(!optionalNote.isPresent()){
            throw new RuntimeException("no entity found");
        }

        return noteResourceAssembler.toResource(optionalNote.get());
    }


    @Override
    public Resource<Note> save(Long recipeid, Note note) {

        Optional<Recipe> optionalRecipe = recipeRepository.findById(recipeid);
        if(!optionalRecipe.isPresent()){
            throw new RuntimeException("no entity found");
        }

        note.setRecipe(optionalRecipe.get());

        return noteResourceAssembler.toResource(noteRepository.save(note));
    }

    @Override
    public Resource<Note> update(Long recipeid, Long noteid, Note note) {

        Optional<Recipe> optionalRecipe = recipeRepository.findById(recipeid);
        if(!optionalRecipe.isPresent()){
            throw new RuntimeException("no entity found");
        }

        note.setRecipe(optionalRecipe.get());

        return noteResourceAssembler.toResource(noteRepository.save(note));
    }

    @Override
    public void delete(Long recipeid, Long noteid) {

        recipeRepository.deleteById(noteid);

    }

}
