/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.iff.info.javaweb20112.prettyfaces.controllers;
import br.iff.info.javaweb20112.prettyfaces.daos.ClienteDao;
import br.iff.info.javaweb20112.prettyfaces.daos.ClienteDaoImpl;
import br.iff.info.javaweb20112.prettyfaces.models.Cliente;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

/**** @author Willer */

@ManagedBean
@SessionScoped 
public class ClienteBean implements Serializable {

    private Cliente cliente = new Cliente();
    private List<Cliente> clientes = new ArrayList<Cliente>();
    private ClienteDao dao = new ClienteDaoImpl();

    /** Creates a new instance of ClienteBean */
    public ClienteBean() {
        clientes = dao.consultar(); // busca todos registros do banco e popula a lista de clientes
    }

    public void salvar(ActionEvent event) {
        dao.save(cliente); // salvando no banco de dados
        cliente = new Cliente(); // criando um novo objeto para caso for inserir novamente
        clientes = dao.consultar();// busca os dados no banco após salvar para apresentar na tabela
    }

    public void editar() {
        cliente = dao.getById(cliente.getIdCliente()); // busca no banco de dados qual registro que vai ser alterado.
    }

    public void excluir() {
        dao.delete(cliente); // deleta do banco o cliente que está no objeto cliente, que foi setado na view.
        clientes = dao.consultar();// busca os dados no banco após excluir para apresentar na tabela
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
}