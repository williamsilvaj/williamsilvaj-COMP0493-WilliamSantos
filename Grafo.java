package meu_grafo;

import java.util.*;

public class Grafo {
    private int vertices;
    private int[][] matrizAdj;
    private List<List<Integer>> listaAdj;

    public Grafo(int v) {
        this.vertices = v;
        matrizAdj = new int[v][v];
        listaAdj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            listaAdj.add(new ArrayList<>());
        }
    }

    /** Adiciona uma aresta ao grafo (não direcionado) */
    public void adicionarAresta(int origem, int destino) {
        matrizAdj[origem][destino] = 1;
        matrizAdj[destino][origem] = 1;
        listaAdj.get(origem).add(destino);
        listaAdj.get(destino).add(origem);
    }

    /** BFS usando Matriz de Adjacência */
    public List<Integer> bfsMatriz(int inicio) {
        List<Integer> resultado = new ArrayList<>();
        boolean[] visitado = new boolean[vertices];
        Queue<Integer> fila = new LinkedList<>();

        fila.add(inicio);
        visitado[inicio] = true;

        while (!fila.isEmpty()) {
            int atual = fila.poll();
            resultado.add(atual);

            for (int i = 0; i < vertices; i++) {
                if (matrizAdj[atual][i] == 1 && !visitado[i]) {
                    fila.add(i);
                    visitado[i] = true;
                }
            }
        }
        return resultado;
    }

    /** BFS usando Lista de Adjacência */
    public List<Integer> bfsLista(int inicio) {
        List<Integer> resultado = new ArrayList<>();
        boolean[] visitado = new boolean[vertices];
        Queue<Integer> fila = new LinkedList<>();

        fila.add(inicio);
        visitado[inicio] = true;

        while (!fila.isEmpty()) {
            int atual = fila.poll();
            resultado.add(atual);

            for (int vizinho : listaAdj.get(atual)) {
                if (!visitado[vizinho]) {
                    fila.add(vizinho);
                    visitado[vizinho] = true;
                }
            }
        }
        return resultado;
    }

    /** DFS Recursivo usando Matriz de Adjacência */
    private void dfsMatrizRec(int atual, boolean[] visitado, List<Integer> resultado) {
        visitado[atual] = true;
        resultado.add(atual);

        for (int i = 0; i < vertices; i++) {
            if (matrizAdj[atual][i] == 1 && !visitado[i]) {
                dfsMatrizRec(i, visitado, resultado);
            }
        }
    }

    public List<Integer> dfsMatriz(int inicio) {
        List<Integer> resultado = new ArrayList<>();
        boolean[] visitado = new boolean[vertices];
        dfsMatrizRec(inicio, visitado, resultado);
        return resultado;
    }

    /** DFS Recursivo usando Lista de Adjacência */
    private void dfsListaRec(int atual, boolean[] visitado, List<Integer> resultado) {
        visitado[atual] = true;
        resultado.add(atual);

        for (int vizinho : listaAdj.get(atual)) {
            if (!visitado[vizinho]) {
                dfsListaRec(vizinho, visitado, resultado);
            }
        }
    }

    public List<Integer> dfsLista(int inicio) {
        List<Integer> resultado = new ArrayList<>();
        boolean[] visitado = new boolean[vertices];
        dfsListaRec(inicio, visitado, resultado);
        return resultado;
    }
}
