/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.iff.info.javaweb20112.prettyfaces.models;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**** @author Willer */

@Entity
public class Cliente implements Serializable { //Serialição do nosso objeto, é utilizado quando recuperamos um dados, será útil mas a frente que tivermos outras classes envolvidas.

    @Id //Define que a variavel abaixo será nosso ID no banco
    @GeneratedValue(strategy= GenerationType.IDENTITY) // Gera um id único para cada registro de cliente
    private Long idCliente;
    @Column(name="NOME", length=80) // define que o nome da coluna, e o tamanho que terá no banco
    private String nome;
    @Column(name="CPF", length=12)// define que o nome da coluna, e o tamanho que terá no banco
    private String cpf;
    @Column(name="CNPJ", length=14)// define que o nome da coluna, e o tamanho que terá no banco
    private String cnpj;
    @Column(name="ENDERECO", length=80)// define que o nome da coluna, e o tamanho que terá no banco
    private String endereco;
    @Column(name="NUMERO", length=20)// define que o nome da coluna, e o tamanho que terá no banco
    private String numero;
    @Column(name="TELEFONE", length=20)// define que o nome da coluna, e o tamanho que terá no banco
    private String telefone;
    @Column(name="ESTADO", length=80)// define que o nome da coluna, e o tamanho que terá no banco
    private String estado;
    @Column(name="MUNICIPIO", length=80)// define que o nome da coluna, e o tamanho que terá no banco
    private String municipio;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}