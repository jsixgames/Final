/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.interfaces;

import br.com.modelos.EstoquePaulista;
import br.com.modelos.ItensVenda;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Jeckson Sacramento Bernardino
 */
@Remote
public interface ItensVendaRemote {

    void create(ItensVenda produto);

    void edit(ItensVenda produto);

    void remove(ItensVenda produto);

    ItensVenda find(Object id);

    List<ItensVenda> findAll();

    List<ItensVenda> findRange(int[] range);

    int count();

    
    
}
