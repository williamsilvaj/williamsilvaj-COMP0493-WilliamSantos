import java.util.Arrays;
import java.util.Comparator;

class Item {
    int peso;
    int valor;
    
    public Item(int peso, int valor) {
        this.peso = peso;
        this.valor = valor;
    }
}

public class AlgoritmosGulosos {
    
    // Mochila Fracionária
    public static double mochilaFracionaria(Item[] itens, int capacidade) {
        Arrays.sort(itens, Comparator.comparingDouble(i -> -((double) i.valor / i.peso)));
        double valorTotal = 0.0;
        
        for (Item item : itens) {
            if (capacidade >= item.peso) {
                capacidade -= item.peso;
                valorTotal += item.valor;
            } else {
                valorTotal += (double) item.valor * capacidade / item.peso;
                break;
            }
        }
        return valorTotal;
    }
    
    // Problema do Troco
    public static void problemaDoTroco(int[] moedas, int valor) {
        Arrays.sort(moedas);
        int[] resultado = new int[moedas.length];
        
        for (int i = moedas.length - 1; i >= 0; i--) {
            resultado[i] = valor / moedas[i];
            valor %= moedas[i];
        }
        
        System.out.println("Troco distribuído com:");
        for (int i = moedas.length - 1; i >= 0; i--) {
            if (resultado[i] > 0) {
                System.out.println(moedas[i] + " x " + resultado[i]);
            }
        }
    }
    
    // Escalonamento de Tarefas
    static class Tarefa {
        int inicio, fim;
        
        public Tarefa(int inicio, int fim) {
            this.inicio = inicio;
            this.fim = fim;
        }
    }
    
    public static void escalonamentoDeTarefas(Tarefa[] tarefas) {
        Arrays.sort(tarefas, Comparator.comparingInt(t -> t.fim));
        
        int ultimoFim = 0;
        System.out.println("Tarefas selecionadas:");
        
        for (Tarefa tarefa : tarefas) {
            if (tarefa.inicio >= ultimoFim) {
                System.out.println("Inicio: " + tarefa.inicio + ", Fim: " + tarefa.fim);
                ultimoFim = tarefa.fim;
            }
        }
    }
}
