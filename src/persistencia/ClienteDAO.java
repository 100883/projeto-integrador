/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import bo.ClienteBO;
import java.sql.ResultSet;

/**
 *
 * @author Gui Freitas
 */
public class ClienteDAO {

    public void AlterarCliente(ClienteBO clienteBo) throws Exception {
        Conexao conexao = new Conexao();
        String SQL = "UPDATE clientes SET nome_cli = '" + clienteBo.getNome() + "'"
                + ", tipo_cli = '" + clienteBo.getTipo() + "'"
                + ", documento_cli = '" + clienteBo.getDocumento() + "'"
                + ", cep_cli = '" + clienteBo.getCep() + "'"
                + ", numero_cli = '" + clienteBo.getNumero() + "'"
                + ", complemento_cli = '" + clienteBo.getComplemento() + "'"
                + ", fone_cli = '" + clienteBo.getFone() + "'"
                + ", fax_cli = '" + clienteBo.getFax() + "'"
                + ", email_cli = '" + clienteBo.getEmail() + "'"
                + " WHERE codigo_cli = " + clienteBo.getCodigo() + "";
        conexao.conectaBD();
        conexao.executaSQL(SQL);
        conexao.desconectaBD();
    }

    public void IncluirCliente(ClienteBO clienteBo) throws Exception {
        Conexao conexao = new Conexao();
        String SQL = "INSERT INTO clientes (nome_cli,tipo_cli,documento_cli,codigo_conv,cep_cli,numero_cli,complemento_cli,fone_cli,fax_cli,email_cli) "
                + "VALUES (" + clienteBo.getNome() + ","
                + "'" + clienteBo.getTipo() + "',"
                + "'" + clienteBo.getDocumento() + "',"
                + "'" + clienteBo.getCep() + "',"
                + "'" + clienteBo.getNumero() + "',"
                + "'" + clienteBo.getComplemento() + "',"
                + "'" + clienteBo.getFone() + "',"
                + "'" + clienteBo.getFax() + "',"
                + "'" + clienteBo.getEmail() + "')";
        conexao.conectaBD();
        conexao.executaSQL(SQL);
        conexao.desconectaBD();
    }

    public ClienteBO BuscaCliente(ClienteBO clienteBo) throws Exception {
        ClienteBO retorno = new ClienteBO();
        ResultSet rs = null;
        Conexao conexao = new Conexao();
        String SQL = "SELECT * FROM clientes WHERE codigo_cli = " + clienteBo.getCodigo() + "";
        conexao.conectaBD();
        rs = conexao.executaConsulta(SQL);
        if (rs.next()) {
            retorno.setNome(rs.getString("nome_cli"));
            retorno.setTipo(rs.getString("tipo_cli"));
            retorno.setDocumento(rs.getString("documento_cli"));
            retorno.setCep(rs.getString("cep_cli"));
            retorno.setNumero(rs.getString("numero_cli"));
            retorno.setComplemento(rs.getString("complemento_cli"));
            retorno.setFone(rs.getString("fone_cli"));
            retorno.setFax(rs.getString("fax_cli"));
            retorno.setEmail(rs.getString("email_cli"));
        }
        rs.close();
        conexao.desconectaBD();
        return retorno;
    }

    public static void inserirProxCodigo(ClienteBO clienteBo) throws Exception {
        Conexao conexao = new Conexao();
        String nometabela = null;
        //String SQL = "SHOW TABLE STATUS LIKE " + nometabela;
        clienteBo.setCodigo(1);
        /*conexao.conectaBD();
        conexao.executaSQL(SQL);
        conexao.desconectaBD();*/
    }

}
