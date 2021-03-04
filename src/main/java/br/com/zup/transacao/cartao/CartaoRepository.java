package br.com.zup.transacao.cartao;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.transacao.transacao.Transacao;

public interface CartaoRepository extends JpaRepository<Cartao, Long> {
    Optional<Cartao> findByNumero(String numero);

	List<Transacao> findByNumero(Long id);
}