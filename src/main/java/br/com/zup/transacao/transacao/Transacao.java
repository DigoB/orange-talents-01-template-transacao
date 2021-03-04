package br.com.zup.transacao.transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import br.com.zup.transacao.cartao.Cartao;
import br.com.zup.transacao.estabelecimento.Estabelecimento;

@Entity
public class Transacao {

    @Id
    private String id;

    private BigDecimal valor;

     @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
     private Estabelecimento estabelecimento;

     @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
     private Cartao cartao;

    private LocalDateTime efetivadaEm;

    @Deprecated
    public Transacao() {
    }

    public Transacao(String id, BigDecimal valor, Estabelecimento estabelecimento, Cartao cartao,
			LocalDateTime efetivadaEm) {
                this.id = id;
                this.valor = valor;
                this.estabelecimento = estabelecimento;
                this.cartao = cartao;
                this.efetivadaEm = efetivadaEm;
	}

	public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public BigDecimal getValor() {
        return valor;
    }

	public Cartao getCartao() {
		return cartao;
	}

    public String getId() {
        return this.id;
    }

}