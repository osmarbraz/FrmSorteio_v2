package modelo;

import java.util.ArrayList;
import java.util.Random;

public class Roleta {

    // Lista de números a serem sorteados simulando o globo de sorteio
    ArrayList<Integer> listaNumeros;
    // Gerador de numeros aleatórios
    Random geradorNumero;
    // Para Saber quantos números ainda faltam para ser sorteado
    int quantidadeFaltante;
    //ordenação do sorteio, meramente para exibir qual a posição foi sorteado, primeiro, segundo, etc...
    int ordem;

    public Roleta() {
        listaNumeros = new ArrayList();
        geradorNumero = new Random();
        quantidadeFaltante = 0;
        ordem = 0;
    }

    public Roleta(ArrayList<Integer> listaNumeros, Random geradorNumero, int quantidadeFaltante, int ordem) {
        this.listaNumeros = listaNumeros;
        this.geradorNumero = geradorNumero;
        this.quantidadeFaltante = quantidadeFaltante;
        this.ordem = ordem;
    }

    public ArrayList<Integer> getListaNumeros() {
        return listaNumeros;
    }

    public void setListaNumeros(ArrayList<Integer> listaNumeros) {
        this.listaNumeros = listaNumeros;
    }

    public Random getGeradorNumero() {
        return geradorNumero;
    }

    public void setGeradorNumero(Random geradorNumero) {
        this.geradorNumero = geradorNumero;
    }

    public int getQuantidadeFaltante() {
        return quantidadeFaltante;
    }

    public void setQuantidadeFaltante(int quantidadeFaltante) {
        this.quantidadeFaltante = quantidadeFaltante;
    }

    public int getOrdem() {
        return ordem;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }

    public void inicializar(int quantidadeNumeroSorteados) {
        //Esvazia a lista
        listaNumeros.clear();
        //Para saber quantos números ainda faltam para ser sorteado
        quantidadeFaltante = 0;
        ordem = 0;
        //Adiciona os números de 1 até quantidade sorteados na lista
        for (int i = 1; i <= quantidadeNumeroSorteados; i++) {
            listaNumeros.add(i);
        }
        quantidadeFaltante = quantidadeNumeroSorteados;
    }

    public int getNumero() {
        //Se existe números a serem sorteados então
        if (!listaNumeros.isEmpty()) {
            // Pega um número aleatório entre 0 e o valor de quantidadeFaltante
            int indice = geradorNumero.nextInt(quantidadeFaltante);
            // Depois do sorteio retira a quantidade restante em -1
            quantidadeFaltante--;
            // Indica qual a posição que foi sorteado, primeiro, segundo, etc.
            ordem++;
            // Recupera o número da lista
            int numeroSorteado = listaNumeros.get(indice);
            // Remove o número da lista
            listaNumeros.remove(indice);
            //Retorna o número sorteado
            return numeroSorteado;
        } else {
            return -1;
        }
    }

}
