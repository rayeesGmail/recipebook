package me.shaikhrayeesahmed.recipebook.controllers;

import me.shaikhrayeesahmed.recipebook.domains.Note;
import me.shaikhrayeesahmed.recipebook.services.NoteService;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }


    @GetMapping("/recipes/{recipeid}/notes")
    public ResponseEntity<Resources<Resource<Note>>> all(@PathVariable Long recipeid){
        return new ResponseEntity<>(noteService.findAll(recipeid), HttpStatus.OK);
    }


    @GetMapping("/recipes/{recipeid}/notes/{noteid}")
    public ResponseEntity<Resource<Note>> one(@PathVariable Long recipeid, @PathVariable Long noteid){
        return new ResponseEntity<>(noteService.find(recipeid, noteid), HttpStatus.OK);
    }


    @PostMapping("/recipes/{recipeid}/notes")
    public ResponseEntity<Resource<Note>> create(@PathVariable Long recipeid, @RequestBody Note note){
        return new ResponseEntity<>(noteService.save(recipeid, note), HttpStatus.CREATED);
    }

    @PutMapping("/recipes/{recipeid}/notes/{noteid}")
    public ResponseEntity<Resource<Note>> update(@PathVariable Long recipeid, @PathVariable Long noteid,
                                                 @RequestBody Note note){
        return new ResponseEntity<>(noteService.update(recipeid, noteid, note), HttpStatus.CREATED);
    }

    @DeleteMapping("/recipes/{recipeid}/notes/{noteid}")
    public void delete(@PathVariable Long recipeid, @PathVariable Long noteid){
        noteService.delete(recipeid, noteid);
    }

}
