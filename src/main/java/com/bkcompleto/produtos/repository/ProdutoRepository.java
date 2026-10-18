package com.bkcompleto.produtos.repository;

import com.bkcompleto.produtos.model.Produto;
import com.bkcompleto.produtos.model.exception.ResourcesNotFoundException;
import com.fasterxml.jackson.annotation.OptBoolean;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

@Repository
public class ProdutoRepository {

    private ArrayList <Produto> produtos = new ArrayList<Produto>();
    private Integer ultimoId = 0;

    /**
     * Metodo de retorno a lista de produtos
     * @return lista de produtos*/
    public List <Produto> obterTodos(){
        return produtos;
    }

    /**
     * @return id do produto
     * @return retorna um produto CASO exista */
    public Optional<Produto> obterPorId(Integer id){
        return produtos.
                stream().
                filter(produto -> produto.getId() == id).
                findFirst();
    }

    /**
     *Adicionando produto
     * @return produto criado */
    public Produto addProduto(Produto produto){
        ultimoId ++;
        produto.setId(ultimoId);
        produtos.add(produto);
        return produto;
    }

    /**
     * Deletenado produtos via ID*/
    public void delProduto(Integer id){
        produtos.removeIf(produto -> produto.getId() == id);
    }

    public Optional<Produto>attProduto(Produto produto){

        Optional<Produto> produtoAchado = obterPorId(produto.getId());

        //Encontrando Produto
        if (produtoAchado.isEmpty()) {
            throw new ResourcesNotFoundException("Não foi possível deletar o produto.");
        }
        //Deletando produto
        delProduto(produto.getId());

        //Add novo produto
        produtos.add(produto);
        return Optional.of(produto);

    }
}