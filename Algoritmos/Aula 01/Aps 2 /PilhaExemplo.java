import java.util.Stack;

public class PilhaExemplo {
    public static void main(String[] args) {
        // Criando a pilha
        Stack<String> pilha = new Stack<>();

        // Adicionando 3 linguagens
        pilha.push("Java");
        pilha.push("Python");
        pilha.push("C++");

        // Imprimindo a pilha
        System.out.println("Pilha inicial: " + pilha);

        // Removendo o topo
        String removido = pilha.pop();
        System.out.println("Removido do topo: " + removido);
        System.out.println("Pilha após remoção: " + pilha);

        // Adicionando mais 2 linguagens
        pilha.push("JavaScript");
        pilha.push("Next");

        // Imprimindo novamente
        System.out.println("Pilha final: " + pilha);
    }
}
