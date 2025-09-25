public class Principal{
    public static void main(String[] args){
        //Testando Pilha
        System.out.println("=== Testando a Pilha ===");
        Pilha<String> pilha = new Pilha<String>("Letras");

        pilha.push("A");
        pilha.push("B");
        pilha.push("C");
        pilha.imprimePilha();

        System.out.println("Topo da pilha: " + pilha.peek());
        System.out.println("Elemento removido: " + pilha.pop());
        pilha.imprimePilha();
    }
}