/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.iff.info.javaweb20112.prettyfaces.utility;

/**** @author Willer */
import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface DaoGenerico<T, ID extends Serializable> {

    public Class<T> getObjectClass();

    public T save(T objeto);

    public void delete(T objeto);

    public void deleteItem(T objeto);

    public List<T> list();

    public List<T> listCriterio(String subClazz, Map<String, Object> filtrosConsulta, int tipoConsulta);

    public T getById(Serializable id);

    public T getById(Serializable id, boolean lock);

    public List<T> consultaHQL(String consulta);

    public void cancel();
}