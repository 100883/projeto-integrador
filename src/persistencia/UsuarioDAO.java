/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import bo.UsuarioBO;
import java.sql.ResultSet;

/**
 *
 * @author Gui Freitas
 */
public class UsuarioDAO {

    public void IncluirUsuario(UsuarioBO usuarioBo) throws Exception {
        Conexao conexao = new Conexao();
        String SQL = "INSERT INTO usuarios (matricula_usu,status_usu,cpf_usu,nome_usu,acesso_usu,senha_usu) "
                + "VALUES (" + usuarioBo.getMatricula() + ",'" + usuarioBo.getStatus() + "',"
                + "'" + usuarioBo.getCpf() + "','" + usuarioBo.getNome() + "','" + usuarioBo.getAcesso() + "',"
                + "'" + usuarioBo.getSenha() + "')";
        conexao.conectaBD();
        conexao.executaSQL(SQL);
        conexao.desconectaBD();
    }

    public void AlterarUsuario(UsuarioBO usuarioBo) throws Exception {
        Conexao conexao = new Conexao();
        String SQL = "UPDATE usuarios SET status_usu = '" + usuarioBo.getStatus() + "', cpf_usu = '" + usuarioBo.getCpf() + "'"
                + ", nome_usu = '" + usuarioBo.getNome() + "', acesso_usu = '" + usuarioBo.getAcesso() + "'"
                + ", senha_usu = '" + usuarioBo.getSenha() + "' WHERE matricula_usu = " + usuarioBo.getMatricula() + "";
        conexao.conectaBD();
        conexao.executaSQL(SQL);
        conexao.desconectaBD();
    }

    public UsuarioBO BuscaMatricula(UsuarioBO usuarioBo) throws Exception {
        UsuarioBO retorno = new UsuarioBO();
        ResultSet rs = null;
        Conexao conexao = new Conexao();
        String SQL = "SELECT * FROM usuarios WHERE matricula_usu = " + usuarioBo.getMatricula() + "";
        conexao.conectaBD();
        rs = conexao.executaConsulta(SQL);
        if (rs.next()) {
            retorno.setMatricula(rs.getInt("matricula"));
            retorno.setStatus(rs.getBoolean("status"));
            retorno.setCpf(rs.getString("cpf"));
            retorno.setNome(rs.getString("nome"));
            retorno.setSenha(rs.getString("senha"));
            retorno.setAcesso(rs.getInt("acesso"));
        }
        rs.close();
        conexao.desconectaBD();
        return retorno;
    }
}
