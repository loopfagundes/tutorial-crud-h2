package br.dev.codex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.dev.codex.model.Tutorial;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
  List<Tutorial> findByNomeContainingIgnoreCase(String nome);
}