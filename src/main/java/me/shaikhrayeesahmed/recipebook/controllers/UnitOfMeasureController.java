package me.shaikhrayeesahmed.recipebook.controllers;

import me.shaikhrayeesahmed.recipebook.domains.UnitOfMeasure;
import me.shaikhrayeesahmed.recipebook.services.UnitOfMeasureService;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UnitOfMeasureController {

    private final UnitOfMeasureService unitOfMeasureService;

    public UnitOfMeasureController(UnitOfMeasureService unitOfMeasureService) {
        this.unitOfMeasureService = unitOfMeasureService;
    }

    @GetMapping("/units")
    @ResponseStatus(HttpStatus.OK)
    public Resources<Resource<UnitOfMeasure>> all(){
        return unitOfMeasureService.findAll();
    }

    @GetMapping("/units/{id}")
    public ResponseEntity<Resource<UnitOfMeasure>> one(@PathVariable Long id){
        return new ResponseEntity<>(unitOfMeasureService.find(id), HttpStatus.OK);
    }

    @PostMapping("/units")
    public ResponseEntity<Resource<UnitOfMeasure>> create(@RequestBody UnitOfMeasure unitOfMeasure) {
        Resource<UnitOfMeasure> resource = unitOfMeasureService.save(unitOfMeasure);
        return new ResponseEntity<>(resource, HttpStatus.CREATED);
    }


    @PutMapping("/units/{id}")
    public ResponseEntity<Resource<UnitOfMeasure>> update(@PathVariable Long id, @RequestBody UnitOfMeasure unitOfMeasure) {
        return new ResponseEntity<>(unitOfMeasureService.update(id, unitOfMeasure), HttpStatus.CREATED);
    }


//    @DeleteMapping("/units/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void delete(@PathVariable Long id){
//        unitOfMeasureService.delete(id);
//    }




}
