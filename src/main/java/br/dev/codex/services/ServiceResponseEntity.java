package br.dev.codex.services;

import br.dev.codex.repository.TutorialRepository;
import br.dev.codex.model.Tutorial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceResponseEntity {

    @Autowired
    private TutorialRepository tutorialRepository;

    public org.springframework.http.ResponseEntity<List<Tutorial>> getAllListResponseEntity(String nome) {
        try {
            List<Tutorial> tutorials = new ArrayList<Tutorial>();
            if (nome == null) {
                tutorials.addAll(tutorialRepository.findAll());
            } else {
                tutorials.addAll(tutorialRepository.findByNomeContainingIgnoreCase(nome));
            }
            if (tutorials.isEmpty()) {
                return new org.springframework.http.ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new org.springframework.http.ResponseEntity<>(tutorials, HttpStatus.OK);
        } catch (Exception e) {
            return new org.springframework.http.ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Tutorial> getIdTutorialResponseEntity(long id) {
        Optional<Tutorial> tutorialData = tutorialRepository.findById(id);

        return tutorialData.map(tutorial
                -> new ResponseEntity<>(tutorial, HttpStatus.OK)).orElseGet(()
                -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<Tutorial> postTutorialResponseEntity(Tutorial tutorial) {
        try {
            Tutorial _tutorial = tutorialRepository.save(new Tutorial(tutorial.getNome(), tutorial.getDataNascimento(), tutorial.getCpf()));
            return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Tutorial> putTutorialResponseEntity(long id, Tutorial tutorial) {
        Optional<Tutorial> tutorialData = tutorialRepository.findById(id);
        if (tutorialData.isPresent()) {
            Tutorial _tutorial = tutorialData.get();
            _tutorial.setNome(tutorial.getNome());
            _tutorial.setDataNascimento(tutorial.getDataNascimento());
            _tutorial.setCpf(tutorial.getCpf());
            return new ResponseEntity<>(tutorialRepository.save(_tutorial), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<HttpStatus> deleteHttpStatusResponseEntity(long id) {
        try {
            tutorialRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<HttpStatus> deleteAllHttpStatusResponseEntity() {
        try {
            tutorialRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
