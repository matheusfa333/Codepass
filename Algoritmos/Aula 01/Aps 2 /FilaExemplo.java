import java.util.LinkedList;
import java.util.Queue;

public class FilaExemplo {
    public static void main(String[] args) {
        // Criando a fila
        Queue<String> fila = new LinkedList<>();

        // Adicionando 3 alunos
        fila.add("Ana");
        fila.add("Bruno");
        fila.add("Carla");

        // Imprimindo a fila
        System.out.println("Fila inicial: " + fila);

        // Removendo o primeiro da fila
        String removido = fila.poll();
        System.out.println("Removido da fila: " + removido);
        System.out.println("Fila após remoção: " + fila);

        // Adicionando mais 2 alunos
        fila.add("Daniel");
        fila.add("Eduarda");

        // Imprimindo novamente
        System.out.println("Fila final: " + fila);
    }
}
