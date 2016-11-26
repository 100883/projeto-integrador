/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctrl;

import bo.LoginBO;
import persistencia.EfetuarLoginDAO;

/**
 *
 * @author Gui Freitas
 */
public class EfetuarLoginCTRL {

    LoginBO loginBo = new LoginBO();
    EfetuarLoginDAO efetuarLoginDao = new EfetuarLoginDAO();

    public int EfetuarLogin(LoginBO loginBo) throws Exception {
        int retorno = 0;
        retorno = efetuarLoginDao.EfetuarLogin(loginBo);
        return retorno;
    }

}
