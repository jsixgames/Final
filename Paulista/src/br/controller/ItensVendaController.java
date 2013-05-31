/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controller;

import br.com.interfaces.ItensVendaRemote;
import br.com.modelos.ItensVenda;
import java.util.List;
import java.util.Properties;
import javax.ejb.EJB;
import javax.naming.InitialContext;

/**
 *
 * @author Jeckson Sacramento Bernardino
 */
public class ItensVendaController {

    @EJB
    private ItensVendaRemote produtoFacade;

    public ItensVendaController() throws Exception {
        Properties props = new Properties();
        props.load(new java.io.FileInputStream("jndi.properties"));
        InitialContext ctx = new InitialContext(props);
        produtoFacade = (ItensVendaRemote) ctx.lookup("ejb/CadastroItensVendaBean");
    }

    public void create(ItensVenda entity) {
        produtoFacade.create(entity);
    }

    public void edit(ItensVenda entity) {
        produtoFacade.edit(entity);
    }
    
    public void remove(ItensVenda entity) {
        produtoFacade.remove(entity);
    }
    
    public List<ItensVenda> findAll() {
        return (produtoFacade.findAll());
    }
    
        public ItensVenda find(Object id) {
        return (produtoFacade.find(id));
    }
}
