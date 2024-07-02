package br.dev.codex.services;

import br.dev.codex.model.Description;
import br.dev.codex.repositories.DescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class DescriptionService {

    @Autowired
    private DescriptionRepository descriptionRepository;

    public List<Description> findAll() {
        return descriptionRepository.findAll();
    }

    public ResponseEntity<Description> getIdDescriptionResponseEntity(long id) {
        Optional<Description> descriptionData = descriptionRepository.findById(id);
        return descriptionData.map(description
                -> new ResponseEntity<>(description, HttpStatus.OK)).orElseGet(()
                -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Transactional
    public Description save(Description description) {
        return descriptionRepository.save(description);
    }

    @Transactional
    public ResponseEntity<Description> putDescriptionResponseEntity(@PathVariable Long id, Description description) {
        Optional<Description> descriptionData = descriptionRepository.findById(id);
        if (descriptionData.isPresent()) {
            Description _description = descriptionData.get();
            _description.setPhrase(description.getPhrase());
            return new ResponseEntity<>(descriptionRepository.save(_description), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Transactional
    public ResponseEntity<HttpStatus> deleteHttpStatusResponseEntity(long id) {
        try {
            descriptionRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Transactional
    public ResponseEntity<HttpStatus> deleteAllHttpStatusResponseEntity() {
        try {
            descriptionRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}