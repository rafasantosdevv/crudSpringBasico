package com.bkcompleto.produtos.services;

import com.bkcompleto.produtos.model.Produto;
import com.bkcompleto.produtos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> obterTodos(){
        return produtoRepository.obterTodos();
    }

    public Optional<Produto> obterPorId(Integer id) {
        return produtoRepository.obterPorId(id);
    }
    public Produto addProduto(Produto produto){
       return produtoRepository.addProduto(produto);
    }
    public void delProduto(Integer id){
        produtoRepository.delProduto(id);
    }
    public Optional<Produto>attProduto(Produto produto, Integer id){
        produto.setId(id);

        return produtoRepository.attProduto(produto);
    }
}
