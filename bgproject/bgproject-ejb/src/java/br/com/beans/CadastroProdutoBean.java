/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beans;

import br.com.interfaces.ProdutoRemote;
import br.com.modelos.Departamento;
import br.com.modelos.EstoquePaulista;
import br.com.modelos.Produto;
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
@Stateless(mappedName = "ejb/CadastroProdutoBean")
public class CadastroProdutoBean extends AbstractFacade<Produto> implements ProdutoRemote {

    @PersistenceContext(unitName = "bgproject-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CadastroProdutoBean() {
        super(Produto.class);
    }
    

    @Override
        public Produto find(Object id) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Produto> c = cb.createQuery(Produto.class);
        Root<Produto> venda = c.from(Produto.class);
        c.where(cb.equal(venda.get("id"), cb.parameter(String.class, "id")));
        TypedQuery q = getEntityManager().createQuery(c);
        q.setParameter("id", id);
        return (Produto) q.getSingleResult();
    }
    
}
