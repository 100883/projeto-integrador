/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctrl;

import bo.ProdutoBO;
import persistencia.ProdutoDAO;

/**
 *
 * @author Gui Freitas
 */
public class ProdutoCTRL {

    public ProdutoBO produtooBo = new ProdutoBO();
    public ProdutoDAO produtoDao = new ProdutoDAO();

    public void IncluirProduto(ProdutoBO produtoBo) throws Exception {
        produtoDao.IncluirProduto(produtoBo);
    }

    public void AlterarProduto(ProdutoBO produtoBo) throws Exception {
        produtoDao.AlterarProduto(produtoBo);
    }

    public ProdutoBO BuscaProduto(ProdutoBO produtoBo) throws Exception {
        ProdutoBO retorno = new ProdutoBO();
        retorno = produtoDao.BuscaProduto(produtoBo);
        return retorno;
    }

}
