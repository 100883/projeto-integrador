/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctrl;

import bo.UsuarioBO;
import persistencia.UsuarioDAO;

/**
 *
 * @author Gui Freitas
 */
public class UsuarioCTRL {

    public UsuarioBO usuarioBo = new UsuarioBO();
    public UsuarioDAO usuarioDao = new UsuarioDAO();

    public void IncluirUsuario(UsuarioBO usuarioBo) throws Exception {
        usuarioDao.IncluirUsuario(usuarioBo);
    }

    public void AlterarUsuario(UsuarioBO usuarioBo) throws Exception {
        usuarioDao.AlterarUsuario(usuarioBo);
    }

    public UsuarioBO BuscaMatricula(UsuarioBO usuarioBo) throws Exception {
        UsuarioBO retorno = new UsuarioBO();
        retorno = usuarioDao.BuscaMatricula(usuarioBo);
        return retorno;
    }
}
