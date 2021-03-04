package br.com.zup.transacao.transacao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.transacao.cartao.Cartao;

public interface TransacaoRepository extends JpaRepository<Transacao, Long>{

	List<Transacao> findTop10ByCartaoOrderByEfetivadaEmDesc(Cartao cartao);

}
