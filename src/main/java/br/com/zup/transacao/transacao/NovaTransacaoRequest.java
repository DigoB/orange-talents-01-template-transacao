package br.com.zup.transacao.transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;
import org.slf4j.Logger;
import br.com.zup.transacao.cartao.Cartao;
import br.com.zup.transacao.cartao.CartaoRepository;
import br.com.zup.transacao.cartao.CartaoRequest;
import br.com.zup.transacao.estabelecimento.Estabelecimento;
import br.com.zup.transacao.estabelecimento.EstabelecimentoRepository;
import br.com.zup.transacao.estabelecimento.EstabelecimentoRequest;

public class NovaTransacaoRequest {

    private String id;

    private BigDecimal valor;

    private CartaoRequest cartao;

    private EstabelecimentoRequest estabelecimento;

    private LocalDateTime efetuadaEm;

	public Transacao toModel(CartaoRepository cartaoRepository, EstabelecimentoRepository estabelecimentoRepository) {

        final Logger logger = org.slf4j.LoggerFactory.getLogger(NovaTransacaoRequest.class);

        logger.info("Buscando possivel cartao no banco de dados");

        Optional<Cartao> possivelCartao = cartaoRepository.findByNumero(cartao.getId());

        Cartao cartao = possivelCartao.isPresent() ? possivelCartao.get() :
        new Cartao(this.cartao.getId(), this.cartao.getEmail());

        logger.info("Cartao encontrado");

        logger.info("Buscando possivel estabelecimento no banco de dados");

        Optional<Estabelecimento> possivelEstabelecimento = estabelecimentoRepository
        .findByNome(estabelecimento.getNome());

        Estabelecimento estabelecimento = possivelEstabelecimento.isPresent()
                ? possivelEstabelecimento.get() : new Estabelecimento(this.estabelecimento.getNome(),
                 this.estabelecimento.getCidade(), this.estabelecimento.getEndereco());
    
        logger.info("Efetuando Transacao");

        return new Transacao(id,valor,estabelecimento,cartao,this.efetuadaEm);
    }

    public String getId() {
        return this.id;
    }

    public BigDecimal getValor() {
        return this.valor;
    }

    public EstabelecimentoRequest getEstabelecimento() {
        return this.estabelecimento;
    }

    public CartaoRequest getCartao() {
        return this.cartao;
    }

    public LocalDateTime getEfetuadaEm() {
        return this.efetuadaEm;
    }
}