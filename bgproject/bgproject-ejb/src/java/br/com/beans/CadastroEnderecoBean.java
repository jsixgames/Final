package br.com.beans;

import br.com.interfaces.CadastroEnderecoRemote;
import br.com.modelos.CadastroEndereco;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

@Stateless(mappedName = "ejb/CadastroEnderecoBean")
public class CadastroEnderecoBean extends AbstractFacade<CadastroEndereco> implements CadastroEnderecoRemote{
    
    @PersistenceContext(unitName = "bgproject-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CadastroEnderecoBean() {
        super(CadastroEndereco.class);
    }         
    
  }