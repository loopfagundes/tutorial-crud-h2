package br.dev.codex.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.dev.codex.model.Tutorial;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
}