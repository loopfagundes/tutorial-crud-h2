package br.dev.codex.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Table(name = "Description")
public class Description {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tutorial_id")
    private Tutorial tutorial;

    @Getter
    @Setter
    @NotBlank
    @Column(name = "phrase")
    private String phrase;

    public Description() {

    }

    public Description(String phrase) {
        this.phrase = phrase;
    }
}