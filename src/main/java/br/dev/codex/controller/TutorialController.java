package br.dev.codex.controller;

import java.util.List;

import br.dev.codex.services.ServiceResponseEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.dev.codex.model.Tutorial;

@RestController
@RequestMapping("/api/tutorials")
public class TutorialController extends ServiceResponseEntity{

    @Autowired
    private ServiceResponseEntity serviceResponseEntity;

//    @GetMapping
//    public ResponseEntity<List<Tutorial>> getAllTutorials(@RequestParam(required = false) String nome) {
//        return getAllListResponseEntity(nome);
//    }

    @GetMapping
    public List<Tutorial> getAll() {
        return serviceResponseEntity.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tutorial> getTutorialById(@PathVariable("id") long id) {
        return getIdTutorialResponseEntity(id);
    }

    @PostMapping
    public Tutorial create(@Valid @RequestBody Tutorial tutorial) {
        return serviceResponseEntity.save(tutorial);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tutorial> updateTutorial(@PathVariable("id") long id, @RequestBody Tutorial tutorial) {
        return putTutorialResponseEntity(id, tutorial);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
        return deleteHttpStatusResponseEntity(id);
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteAllTutorials() {
        return deleteAllHttpStatusResponseEntity();
    }
}