/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

/**
 *
 * @author Gui Freitas
 */
public class DependenteBO {

    //Atributos
    private String nome;
    private int telefone;
    private int CPF;
    private int cod_socio;

    //Metodos
    public String getNome() {
        return nome;
    }

    public int getTelefone() {
        return telefone;
    }

    public int getCPF() {
        return CPF;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public void setCPF(int CPF) {
        this.CPF = CPF;
    }

    public int getCod_socio() {
        return cod_socio;
    }

    public void setCod_socio(int cod_socio) {
        this.cod_socio = cod_socio;
    }

}
