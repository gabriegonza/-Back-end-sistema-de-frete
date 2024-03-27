package br.com.frete.doamin.cliente;

import br.com.frete.doamin.endereco.Endereco;
import jakarta.persistence.*;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cnpj;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;

    public Cliente(long l, String s) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente cliente)) return false;

        if (getId() != null ? !getId().equals(cliente.getId()) : cliente.getId() != null) return false;
        if (getNome() != null ? !getNome().equals(cliente.getNome()) : cliente.getNome() != null) return false;
        if (getCnpj() != null ? !getCnpj().equals(cliente.getCnpj()) : cliente.getCnpj() != null) return false;
        return getEndereco() != null ? getEndereco().equals(cliente.getEndereco()) : cliente.getEndereco() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getNome() != null ? getNome().hashCode() : 0);
        result = 31 * result + (getCnpj() != null ? getCnpj().hashCode() : 0);
        result = 31 * result + (getEndereco() != null ? getEndereco().hashCode() : 0);
        return result;
    }
}
