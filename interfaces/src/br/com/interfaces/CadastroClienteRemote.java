package br.com.interfaces;

import br.com.modelos.CadastroCliente;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface CadastroClienteRemote {

    public void create(CadastroCliente cliente);

    public void edit(CadastroCliente cliente);

    public void remove(CadastroCliente cliente);

    public CadastroCliente find(Object cliente);       
    
    public CadastroCliente login(String email, String senha);

    public List<CadastroCliente> findAll();

    public List<CadastroCliente> findRange(int[] range);

    public int count();
}