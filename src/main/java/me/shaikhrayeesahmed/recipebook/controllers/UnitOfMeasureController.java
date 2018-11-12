package me.shaikhrayeesahmed.recipebook.controllers;

import me.shaikhrayeesahmed.recipebook.domains.UnitOfMeasure;
import me.shaikhrayeesahmed.recipebook.services.UnitOfMeasureService;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;

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

    @PostMapping("/units")
    public ResponseEntity<Resource<UnitOfMeasure>> create(@RequestBody UnitOfMeasure unitOfMeasure) throws URISyntaxException {
        Resource<UnitOfMeasure> resource = unitOfMeasureService.save(unitOfMeasure);
        return new ResponseEntity<>(resource, HttpStatus.CREATED);
    }





}
