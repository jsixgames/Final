/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beans;

import br.com.interfaces.ItensVendaRemote;
import br.com.modelos.ItensVenda;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import javax.persistence.criteria.Root;

/**
 *
 * @author Calebe de Paula Bianchini
 */
@Stateless(mappedName = "ejb/CadastroItensVendaBean")
public class CadastroItensVendaBean extends AbstractFacade<ItensVenda> implements ItensVendaRemote {

    @PersistenceContext(unitName = "bgproject-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    @Override
    public void create(ItensVenda entity) {
        getEntityManager().persist(entity);
    }

    public CadastroItensVendaBean() {
        super(ItensVenda.class);
    }

    @Override
        public ItensVenda find(Object id) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<ItensVenda> c = cb.createQuery(ItensVenda.class);
        Root<ItensVenda> venda = c.from(ItensVenda.class);
        c.where(cb.equal(venda.get("id"), cb.parameter(String.class, "id")));
        TypedQuery q = getEntityManager().createQuery(c);
        q.setParameter("id", id);
        return (ItensVenda) q.getSingleResult();
    }


}
