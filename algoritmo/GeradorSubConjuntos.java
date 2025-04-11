package algoritmo;

import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;

public class GeradorSubConjuntos {
    /**
     * Gera todos os subconjuntos possíveis de um conjunto dado.
     * Utiliza representação binária para determinar quais elementos incluir.
     * Retorna um conjunto contendo todos os subconjuntos, incluindo o vazio.
     */
    public static Set<Set<Integer>> getSubSets(Set<Integer> conjuntoEntrada) {
        Set<Set<Integer>> colecaoSubConjuntos = new HashSet<>();

        List<Integer> listaEntrada = new ArrayList<>(conjuntoEntrada);
        int tamanho = listaEntrada.size();

        int totalCombinacoes = (int) Math.pow(2, tamanho);

        for (int cont = 0; cont < totalCombinacoes; cont++) {
            Set<Integer> subConjunto = new HashSet<>();

            for (int posicao = 0; posicao < tamanho; posicao++) {
                if (((cont >> posicao) & 1) == 1) {
                    subConjunto.add(listaEntrada.get(posicao));
                }
            }

            colecaoSubConjuntos.add(subConjunto);
        }

        return colecaoSubConjuntos;
    }

    public static void main(String[] args) {
        Set<Integer> conjuntoTeste = new HashSet<>();
        conjuntoTeste.add(1);
        conjuntoTeste.add(2);
        conjuntoTeste.add(3);

        Set<Set<Integer>> resultado = getSubSets(conjuntoTeste);
        System.out.println("Subconjuntos gerados: " + resultado);
    }
}