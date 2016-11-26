/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctrl;

import bo.ClienteBO;
import persistencia.ClienteDAO;

/**
 *
 * @author Gui Freitas
 */
public class ClienteCTRL {

    public ClienteBO clienteBo = new ClienteBO();
    public ClienteDAO clienteDao = new ClienteDAO();
    public void IncluirCliente(ClienteBO clienteBo) throws Exception {
        clienteDao.IncluirCliente(clienteBo);
    }
    public void AlterarCliente(ClienteBO clienteBo) throws Exception {
        clienteDao.AlterarCliente(clienteBo);
    }
    public ClienteBO BuscaCliente(ClienteBO clienteBo) throws Exception {
        ClienteBO retorno = new ClienteBO();
        retorno = clienteDao.BuscaCliente(clienteBo);
        return retorno;
    }

}
