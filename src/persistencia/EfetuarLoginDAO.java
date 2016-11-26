/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import bo.LoginBO;
import static java.lang.Boolean.*;
import java.sql.ResultSet;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author Gui Freitas
 */
public class EfetuarLoginDAO {

    private String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public int EfetuarLogin(LoginBO loginBo) throws Exception {
        LoginBO consulta = new LoginBO();
        int retorno = 0;
        ResultSet rs = null;
        Conexao conexao = new Conexao();
        String SQL = "SELECT matricula_usu, senha_usu, nome_usu, status_usu, acesso_usu FROM usuarios WHERE matricula_usu = " + loginBo.getMatricula() + "";
        conexao.conectaBD();
        rs = conexao.executaConsulta(SQL);
        if (rs.next()) {
            consulta.setSenha(rs.getString("senha_usu"));
            consulta.setStatus(rs.getBoolean("status_usu"));
            consulta.setNome(rs.getString("nome_usu"));
            consulta.setAcesso(rs.getInt("acesso_usu"));
        } 
        rs.close();
        conexao.desconectaBD();
        
        if (consulta.getStatus() == TRUE) {
            if (consulta.getSenha().equals(loginBo.getSenha())) {
                String SQL2 = "INSERT INTO logs (matricula_usu,data_log) "
                        + "VALUES (" + loginBo.getMatricula() + ",'" + getDateTime() + "')";
                conexao.conectaBD();
                conexao.executaSQL(SQL2);
                conexao.desconectaBD();
                retorno = consulta.getAcesso();
            }
        } else {
            retorno = 0;
        }
        return retorno;
    }
}
