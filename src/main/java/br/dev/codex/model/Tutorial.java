package br.dev.codex.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.Set;

@Getter
@Entity
@Data
@Table(name = "tutorials")
public class Tutorial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Setter
    @NotBlank
    @Column(name = "nome")
    private String nome;

    @Setter
    @Column(name = "dataNascimento")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    @Setter
    @NotBlank
    @Column(name = "cpf", unique = true)
    private String cpf;

    @Setter
    private int idade;

    @Setter
    @ElementCollection
    @OneToMany(mappedBy = "tutorial", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Description> description = new HashSet<>();

    public Tutorial() {

    }

    public Tutorial(String nome, LocalDate dataNascimento, String cpf, int idade) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.idade = idade;
    }

    public int getIdade() {
        return Period.between(this.dataNascimento, LocalDate.now()).getYears();
    }
}