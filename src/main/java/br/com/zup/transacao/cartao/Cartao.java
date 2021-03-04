package br.com.zup.transacao.cartao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import br.com.zup.transacao.transacao.Transacao;

@Entity
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero;

    private String email;

    @ManyToOne
    private Transacao transacao;

    @Deprecated
    public Cartao() {
    }

    public Cartao(String numero, String email) {
        this.numero = numero;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Cartao{" +
                "id=" + id +
                ", numero='" + numero + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}