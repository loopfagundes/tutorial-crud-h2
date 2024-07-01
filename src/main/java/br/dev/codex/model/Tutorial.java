package br.dev.codex.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Data
@Table(name = "tutorials")
public class Tutorial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Getter
    @Setter
    @NotBlank
    @Column(name = "nome")
    private String nome;

    @Getter
    @Setter
    @Column(name = "dataNascimento")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    @Getter
    @Setter
    @NotBlank
    @Column(name = "cpf", unique = true)
    private String cpf;

    public Tutorial() {

    }

    public Tutorial(String nome, LocalDate dataNascimento, String cpf) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
    }

    public long getId() {
        return id;
    }

    public int getIdade() {
        return Period.between(this.dataNascimento, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return "Tutorial [id=" + id + ", nome=" + nome + ", dataNascimento=" + dataNascimento + ", cpf=" + cpf + "]";
    }
}