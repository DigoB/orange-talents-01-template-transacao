package br.com.zup.transacao.transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import br.com.zup.transacao.cartao.Cartao;
import br.com.zup.transacao.estabelecimento.Estabelecimento;

public class TransacaoDto {

    private String id;

    private BigDecimal valor;

    private Cartao cartao;

    private Estabelecimento estabelecimento;

    private LocalDateTime efetivadaEm;



    public TransacaoDto(Transacao transacao) {
        this.id = transacao.getId();
        this.valor = transacao.getValor();
        this.cartao = transacao.getCartao();
        this.estabelecimento = transacao.getEstabelecimento();
        this.efetivadaEm = transacao.getEfetivadaEm();
    }

    public String getId() {
        return this.id;
    }

    public BigDecimal getValor() {
        return this.valor;
    }

    public Cartao getCartao() {
        return this.cartao;
    }

    public Estabelecimento getEstabelecimento() {
        return this.estabelecimento;
    }

    public LocalDateTime getEfetivadaEm() {
        return this.efetivadaEm;
    }

}