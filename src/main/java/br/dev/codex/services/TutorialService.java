package br.dev.codex.services;

import br.dev.codex.repositories.DescriptionRepository;
import br.dev.codex.repositories.TutorialRepository;
import br.dev.codex.model.Tutorial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class TutorialService {

    @Autowired
    private TutorialRepository tutorialRepository;

    public List<Tutorial> findAll() {
        return tutorialRepository.findAll();
    }

    public ResponseEntity<Tutorial> getIdTutorialResponseEntity(long id) {
        Optional<Tutorial> tutorialData = tutorialRepository.findById(id);

        return tutorialData.map(tutorial
                -> new ResponseEntity<>(tutorial, HttpStatus.OK)).orElseGet(()
                -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Transactional
    public Tutorial save(Tutorial tutorial) {
        return tutorialRepository.save(tutorial);
    }

    @Transactional
    public ResponseEntity<Tutorial> putTutorialResponseEntity(@PathVariable Long id, Tutorial tutorial) {
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

    @Transactional
    public ResponseEntity<HttpStatus> deleteHttpStatusResponseEntity(long id) {
        try {
            tutorialRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Transactional
    public ResponseEntity<HttpStatus> deleteAllHttpStatusResponseEntity() {
        try {
            tutorialRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}