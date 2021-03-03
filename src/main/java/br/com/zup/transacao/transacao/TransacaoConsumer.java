package br.com.zup.transacao.transacao;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import br.com.zup.transacao.cartao.CartaoRepository;
import br.com.zup.transacao.estabelecimento.EstabelecimentoRepository;

@Component
public class TransacaoConsumer {

    @Autowired
    private CartaoRepository cartaoRepository;
    @Autowired
    private EstabelecimentoRepository estabelecimentoRepository;
    @Autowired
    private TransacaoRepository transacaoRepository;

    @KafkaListener(topics = "${transaction.topic}", groupId = "${spring.kafka.consumer.group.id}")
    public void consume(NovaTransacaoRequest novaTransacao) {
        System.out.println(novaTransacao);

        Transacao transacao = novaTransacao.toModel(cartaoRepository, estabelecimentoRepository);

        transacaoRepository.save(transacao);
        }
    
}
