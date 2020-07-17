package br.com.alura.leilao.ui;

import java.util.List;

import br.com.alura.leilao.api.retrofit.client.LeilaoWebClient;
import br.com.alura.leilao.api.retrofit.client.RespostaListener;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.ui.recyclerview.adapter.ListaLeilaoAdapter;

public class AtualizarLeiloes{

    public static void buscarLeiloes(final ListaLeilaoAdapter adapter, LeilaoWebClient client, final ErroCarregaLeiloes erroListener){

        client.todos(new RespostaListener<List<Leilao>>(){
            @Override
            public void sucesso(List<Leilao> leiloes){
                adapter.atualiza(leiloes);
            }

            @Override
            public void falha(String mensagem){
                erroListener.erroCarregar(mensagem);
            }
        });
    }

    public interface ErroCarregaLeiloes{
        void erroCarregar(String mensagem);
    }

}