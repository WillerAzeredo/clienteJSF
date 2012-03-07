/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.iff.info.javaweb20112.prettyfaces.daos;
import br.iff.info.javaweb20112.prettyfaces.models.Cliente;
import br.iff.info.javaweb20112.prettyfaces.utility.DaoGenerico;
import java.util.List;

/**** @author Willer */

public interface ClienteDao extends DaoGenerico <Cliente, Long> {

    public List consultar();
}