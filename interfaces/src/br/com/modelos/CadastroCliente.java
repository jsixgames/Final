package br.com.modelos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

@Entity
public class CadastroCliente implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_cliente;
    private String email;
    private String nome;   
    private String cpf;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dnasc;
    private String sexo;    
    private String telefone;
    private String celular;
    private String senha;             
    @OneToMany(cascade= CascadeType.ALL,fetch= FetchType.EAGER)
    @JoinTable(name = "Clientes_Enderecos",joinColumns = @JoinColumn(name = "id_cliente"),
            inverseJoinColumns = @JoinColumn(name = "id_end"))  
    private List<CadastroEndereco> endereco;

    public CadastroCliente() {
    }

    public CadastroCliente(String cpf) {
        this.cpf = cpf;
    }

    public Long getId() {
        return id_cliente;
    }

    public void setId(Long id) {
        this.id_cliente = id;
    }

    public List<CadastroEndereco> getEndereco() {
        return endereco;
    }

    public void setEndereco(List<CadastroEndereco> endereco) {
        this.endereco = endereco;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDnasc() {
        return dnasc;
    }

    public void setDnasc(Date dnasc) {
        this.dnasc = dnasc;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }


    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (email != null ? email.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CadastroCliente)) {
            return false;
        }
        CadastroCliente other = (CadastroCliente) object;
        if ((this.email == null && other.email != null) || (this.email != null && !this.email.equals(other.email))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "<tr>"+
                "<td id='listaclientelinhas'>"+id_cliente+"</td>"+
                "<td id='listaclientelinhas'>"+nome+"</td>"+
                "<td id='listaclientelinhas'>"+cpf+"</td>"+
                "<td id='listaclientelinhas'>"+sexo+"</td>"+
                "<td id='listaclientelinhas'>"+telefone+"</td>"+
                "<td id='listaclientelinhas'>"+celular+"</td>"+
                "<td id='listaclientelinhas'>"+email+"</td>"+
                "<td id='listaclientelinhas'>"+senha+"</td>"+
                "</tr>";
    }
    
}
