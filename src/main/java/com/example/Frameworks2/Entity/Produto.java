
package com.example.Frameworks2.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
// Dar o nome da tabela
@Table(name = "Produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Long = tipo um int, só que armazena
    // números muito grandes

    @Column(nullable = false)
    // Esse campo não pode ser nulo
    private String nome;

    @Column(nullable = false)
    private int unidade;


    

 @Column(nullable = false)
    private Float preco;


    public Produto() {
}

    public void setUnidade(int unidade) {
        this.unidade = unidade;
    }

   public int getUnidade() {
        return unidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

}

