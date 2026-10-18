package com.bkcompleto.produtos.controller;

import com.bkcompleto.produtos.model.Produto;
import com.bkcompleto.produtos.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> ObterTodos(){
        return produtoService.obterTodos();
    }

    @PostMapping
    public Produto adicionar(@RequestBody Produto produto){
        return produtoService.addProduto(produto);
    }

    @GetMapping("/{id}")
    public Optional<Produto> obterPorId(@PathVariable Integer id){
        return produtoService.obterPorId(id);
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Integer id){
        produtoService.delProduto(id);
        return "Produto com id: " + id + " foi deletado com êxito";
    }

    @PutMapping("/{id}")
    public Optional<Produto> atualizar(@RequestBody Produto produto, @PathVariable Integer id){
        return produtoService.attProduto(produto, id);
    }
}
