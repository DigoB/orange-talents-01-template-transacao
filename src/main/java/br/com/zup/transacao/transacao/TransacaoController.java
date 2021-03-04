package br.com.zup.transacao.transacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class TransacaoController {


    @Autowired
    private TransacaoRepository transacaoRepository;

    @GetMapping("/cartoes/{id}/transacoes")
    public List<TransacaoDto> busca(@PathVariable Long id) {

        List<Transacao> transacoes = transacaoRepository.findAll();
        return NovaTransacaoRequest.converter(transacoes);
    }

}