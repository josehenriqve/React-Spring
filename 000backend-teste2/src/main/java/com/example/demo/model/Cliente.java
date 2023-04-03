package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity(name = "cliente")
public class Cliente implements Serializable {

    private static  final Long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "nome",nullable = false,length = 190)
    private String nome;
    @Column(name = "idade",nullable = false,length = 2)
    private Integer idade;
    @Column(name = "cpf",nullable = false,length = 11)
    private String Cpf;

    public Cliente() {}

    public Cliente(Long id, String nome, Integer idade, String cpf) {
        Id = id;
        this.nome = nome;
        this.idade = idade;
        Cpf = cpf;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String cpf) {
        Cpf = cpf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente cliente)) return false;
        return getId().equals(cliente.getId()) && getNome().equals(cliente.getNome()) && getIdade().equals(cliente.getIdade()) && getCpf().equals(cliente.getCpf());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getIdade(), getCpf());
    }
}
