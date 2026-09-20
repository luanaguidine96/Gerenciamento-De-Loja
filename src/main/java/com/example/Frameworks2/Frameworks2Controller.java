package com.example.Frameworks2;

import java.util.List; // essa é miha entidade

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;//esse meu repositorio
import org.springframework.web.bind.annotation.PostMapping;//controla o http
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Frameworks2.Entity.Produto;
import com.example.Frameworks2.Repository.ProdutoRepository;
@RestController //Spring, essa classe vai receber requisições HTTP e devolver respostas.
//restorna dados da api que controla
@RequestMapping("/Loja")
//define o caminho 
public class Frameworks2Controller {
//O Repository faz a operação no banco.
    private final ProdutoRepository repository;

    public Frameworks2Controller(ProdutoRepository repository) {
        this.repository = repository;

        //você não precisa fazer: new ProdutoRepository();
    }

    @PostMapping
    //Se alguém enviar dados para /Loja usando POST, execute esse método
    //e isso acontece por causa do JSON 
    public ResponseEntity<Produto> criarP(@RequestBody Produto produto) {

//Quando chegar uma requisição HTTP de criar  em /Loja, execute esse método
//Quando o navegador conversa com o seu servidor, ele manda uma mensagem.
//Essa mensagem é uma requisição HTTP.


//RequestBody
//meu request body vai enciaxar meus objetos produtos do json em algum lugar dentro do vetor de List



       Produto produtoSalvo = repository.save(produto);
//Pegue o Produto que veio no corpo do POST e mande esse Produto
// para o Repository, usando o método save()


//  Guarde o Produto retornado em produtoSalvo
//200 sea o status http
        return ResponseEntity.ok(produtoSalvo);
        //Devolva uma resposta HTTP dizendo que deu tudo certo e coloque o produto salvo dentro da resposta
    }

    @GetMapping
    //o navegador normalmente faz uma requisição GET quando você 
    // abre uma URL, o GetMpaping acaba sendo perfeito para isso
public ResponseEntity<List<Produto>> listar() {
    return ResponseEntity.ok(repository.findAll());
    //lista todos os objetos
}


}
// curl.exe -X POST http://localhost:8080/Loja -H "Content-Type: application/json" --data-binary "@produto.json"