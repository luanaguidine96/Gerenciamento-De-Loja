   //document = documento  HTML que esta carregado no navegador
        //quando o evento submit acontecer:
const formulario = document.getElementById("formProduto");

formulario.addEventListener("submit", function(event) {


    const nome = document.getElementById("nome").value;
    const preco = Number(document.getElementById("preco").value);
    const estoque = Number(document.getElementById("estoque").value);

    const produto = {
        nome: nome,
        preco: preco,
        unidade: estoque
    };//todos os parametros preeenchidos pelo usuario vao virar json

fetch("/Loja", { //Para onde enviar, aquele RequestMapping la do Controller
    method: "POST", //metodo
    //Content type : conteudo do tipo:
    headers: {"Content-Type": "application/json"}, //Estou enviando JSON
    //transformar algo em uma string
    body: JSON.stringify(produto) //corpo da requisição
    //ele transforma o objeto em uma representação JSON em texto
});
alert("Enviei a requisição!");
});

fetch("/Loja")
    .then(response => response.json()) //pega as coisas do json
    .then(produtos => {
const divProdutos = document.getElementById("produtos");
divProdutos.innerHTML = "<h2>Produtos</h2>";


produtos.forEach(produto => { //para cada produto aplique

    divProdutos.innerHTML += ` 
        <div class="produto">
            <h3>${produto.nome}</h3>
            <p>Preço: R$ ${produto.preco}</p>
            <p>Estoque: ${produto.unidade}</p>
        </div>
    `;

});
    });
