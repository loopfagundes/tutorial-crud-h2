package br.dev.codex.controller;

import br.dev.codex.model.Description;
import br.dev.codex.services.DescriptionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tutorials/desc")
public class DescriptionController {

    @Autowired
    private DescriptionService descriptionService;

    @GetMapping
    public List<Description> getAllDesc() {
        return descriptionService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Description> getDescById(@PathVariable("id") long id) {
        return descriptionService.getIdDescriptionResponseEntity(id);
    }

    @PostMapping
    public Description createDesc(@Valid @RequestBody Description description) {
        return descriptionService.save(description);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Description> updateDesc(@PathVariable("id") long id, @RequestBody Description description) {
        return descriptionService.putDescriptionResponseEntity(id, description);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
        return descriptionService.deleteHttpStatusResponseEntity(id);
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteAllTutorials() {
        return descriptionService.deleteAllHttpStatusResponseEntity();
    }
}