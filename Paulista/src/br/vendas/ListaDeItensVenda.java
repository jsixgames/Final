/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vendas;

import br.com.modelos.ItensVenda;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jeckson Sacramento Bernardino
 */
public class ListaDeItensVenda {
    
    private static List<ItensVenda> listaItensVenda = new ArrayList<ItensVenda>();
    
    private ListaDeItensVenda(){
        
    
    
    }
    
    public static void insereLista(ItensVenda item){
        listaItensVenda.add(item);
    }
    
    public static List<ItensVenda> getListaItensVenda(){
        List<ItensVenda> lista = listaItensVenda;
        return lista;
    }
    
}
