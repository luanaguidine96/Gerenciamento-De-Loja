package com.example.Frameworks2.Repository;

import com.example.Frameworks2.Entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
