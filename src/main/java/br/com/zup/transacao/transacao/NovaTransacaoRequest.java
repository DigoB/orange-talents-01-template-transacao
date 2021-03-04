package br.com.zup.transacao.transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private LocalDateTime efetivadaEm;

	public Transacao paraTransacao(CartaoRepository cartaoRepository, EstabelecimentoRepository estabelecimentoRepository) {

        final Logger logger = LoggerFactory.getLogger(NovaTransacaoRequest.class);

        logger.info("Buscando possivel cartao no banco de dados");

        Optional<Cartao> possivelCartao = cartaoRepository.findByNumero(cartao.getId());

        Cartao cartao = null;
        if(possivelCartao.isPresent()) {
            cartao = possivelCartao.get();
        } else {
            cartao = new Cartao(this.cartao.getId(), this.cartao.getEmail());
        }

        logger.info("Cartao encontrado");

        logger.info("Buscando possivel estabelecimento no banco de dados");

        Optional<Estabelecimento> possivelEstabelecimento = estabelecimentoRepository
        .findByNome(estabelecimento.getNome());

        Estabelecimento estabelecimento = null;
        if(possivelEstabelecimento.isPresent()) {
            estabelecimento = possivelEstabelecimento.get();

        } else {
           estabelecimento = new Estabelecimento(this.estabelecimento.getNome(), this.estabelecimento.getCidade(), 
            this.estabelecimento.getEndereco());
        }
    
        logger.info("Efetuando Transacao");

        return new Transacao(id,valor,estabelecimento,cartao,this.efetivadaEm);
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

    public LocalDateTime getEfetivadaEm() {
        return this.efetivadaEm;
    }

	public static List<TransacaoDto> converter(List<Transacao> transacoes) {
		return transacoes.stream().map(TransacaoDto::new).collect(Collectors.toList());
	}
}