package br.com.zup.transacao.transacao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.transacao.cartao.Cartao;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long>{

	List<Transacao> findTop10ByCartaoOrderByEfetuadaEmDesc(Cartao cartao);

}
