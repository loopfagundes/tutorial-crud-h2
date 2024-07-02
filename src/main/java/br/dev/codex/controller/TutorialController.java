package br.dev.codex.controller;

import java.util.List;

import br.dev.codex.services.TutorialService;
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
import org.springframework.web.bind.annotation.RestController;

import br.dev.codex.model.Tutorial;

@RestController
@RequestMapping("/api/tutorials")
public class TutorialController {

    @Autowired
    private TutorialService tutorialService;

    @GetMapping
    public List<Tutorial> getAll() {
        return tutorialService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tutorial> getTutorialById(@PathVariable("id") long id) {
        return tutorialService.getIdTutorialResponseEntity(id);
    }

    @PostMapping
    public Tutorial create(@Valid @RequestBody Tutorial tutorial) {
        return tutorialService.save(tutorial);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tutorial> updateTutorial(@PathVariable("id") long id, @RequestBody Tutorial tutorial) {
        return tutorialService.putTutorialResponseEntity(id, tutorial);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
        return tutorialService.deleteHttpStatusResponseEntity(id);
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteAllTutorials() {
        return tutorialService.deleteAllHttpStatusResponseEntity();
    }
}