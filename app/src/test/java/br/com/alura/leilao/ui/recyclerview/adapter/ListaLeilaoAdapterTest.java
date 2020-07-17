package br.com.alura.leilao.ui.recyclerview.adapter;

import android.content.Context;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;

import br.com.alura.leilao.model.Leilao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ListaLeilaoAdapterTest{

    @Mock
    private Context mock;
    @Spy
    private ListaLeilaoAdapter adapter = new ListaLeilaoAdapter(mock);

    @Test
    public void deve_AtualizarListaLeiloes(){

//      MockitoAnnotations.initMocks(this);
        doNothing().when(adapter).atualizarLista();

        adapter.atualiza(new ArrayList<>(Arrays.asList(new Leilao("Console"), new Leilao("Computador"))));

        int quantidadeLeiloes = adapter.getItemCount();
        verify(adapter).atualizarLista();
        assertThat(quantidadeLeiloes, is(2));
    }

}