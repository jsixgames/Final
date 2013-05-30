package br.com.interfaces;

import br.com.modelos.CadastroEndereco;
import java.util.List;
import javax.ejb.Remote; 

@Remote
public interface CadastroEnderecoRemote {

    void create(CadastroEndereco endereco);

    void edit(CadastroEndereco endereco);

    void remove(CadastroEndereco endereco);

    CadastroEndereco find(Object id);

    public List<CadastroEndereco> findAll();

    List<CadastroEndereco> findRange(int[] range);

    int count();    
}