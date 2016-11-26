/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package persistencia;

import bo.CepBO;
import java.sql.ResultSet;

/**
 *
 * @author Gui Freitas
 */
public class ValidadoresDAO {

    public static CepBO ValidarCEP(CepBO cepBo) throws Exception {
        CepBO retorno = new CepBO();
        ResultSet rs = null;
        ConexaoCep conexao = new ConexaoCep();
        String SQL = "SELECT log_logradouro.\"LOG_TIPO_LOGRADOURO\",log_logradouro.\"LOG_NO\","
                + "log_bairro.\"BAI_NO\",log_localidade.\"LOC_NO\",log_localidade.\"UFE_SG\","
                + "log_logradouro.\"CEP\" FROM public.log_bairro,public.log_logradouro,"
                + "public.log_localidade WHERE log_logradouro.\"LOC_NU_SEQUENCIAL\" = "
                + "log_localidade.\"LOC_NU_SEQUENCIAL\" AND log_logradouro.\"BAI_NU_SEQUENCIAL_INI\" ="
                + " log_bairro.\"BAI_NU_SEQUENCIAL\" AND log_logradouro.\"CEP\" ="
                + " '" + cepBo.getCep() + "'";
        conexao.conectaBD();
        rs = conexao.executaConsulta(SQL);
        if (rs.next()) {
            retorno.setTipo_log(rs.getString("LOG_TIPO_LOGRADOURO"));
            retorno.setLogradouro(rs.getString("LOG_NO"));
            retorno.setBairro(rs.getString("BAI_NO"));
            retorno.setUf(rs.getString("UFE_SG"));
            retorno.setMunicipio(rs.getString("LOC_NO"));
        }
        rs.close();
        conexao.desconectaBD();
        return retorno;
    }
    
}
