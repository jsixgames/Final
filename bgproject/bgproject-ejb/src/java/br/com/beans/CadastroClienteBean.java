package br.com.beans;

import br.com.interfaces.CadastroClienteRemote;
import br.com.modelos.CadastroCliente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(mappedName = "ejb/CadastroClienteBean")
public class CadastroClienteBean extends AbstractFacade<CadastroCliente> implements CadastroClienteRemote{
    
   @PersistenceContext(unitName = "bgproject-ejbPU")
    private EntityManager em;
   
   @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public CadastroClienteBean(){
        super(CadastroCliente.class);
    }

    @Override
    public CadastroCliente login(String email, String senha) {
        CadastroCliente c = null;
        Query query = em.createQuery("select c from CadastroCliente c where c.email='" + email + "'"
                + " and c.senha='" + senha + "'");
        Object result = (Object) query.getSingleResult();
        if (result != null) {
            c = (CadastroCliente) result;
        }
        return c;
    }   
   
}