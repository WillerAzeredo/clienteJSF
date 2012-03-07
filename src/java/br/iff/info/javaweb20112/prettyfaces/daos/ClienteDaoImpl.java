/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.iff.info.javaweb20112.prettyfaces.daos;
import br.iff.info.javaweb20112.prettyfaces.models.Cliente;
import br.iff.info.javaweb20112.prettyfaces.utility.DaoGenericoImpl;
import br.iff.info.javaweb20112.prettyfaces.utility.HibernateUtility;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;

/**** @author Willer */

public class ClienteDaoImpl extends DaoGenericoImpl < Cliente , Long > implements ClienteDao {

    @Override
    public List consultar() {
        List lista = new ArrayList();
        Criteria crit = HibernateUtility.getSession().createCriteria(Cliente.class);

        lista = (List) crit.list();
        return lista;
    }
}