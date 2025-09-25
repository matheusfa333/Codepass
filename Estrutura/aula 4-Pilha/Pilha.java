public class Pilha<T>{
    private No<T> topo;
    private String nomePilha;

    public Pilha(){
        this("");
    }

    public Pilha(String nomePilha){
        this.nomePilha = nomePilha;
        this.topo = null;
    }

    public void push(T dado){ //insere um elemento no topo da lista
        No<T> novoNo = new No<T>(dado);
        novoNo.setNextNo(topo);
        topo = novoNo;
    }

    public T peek(){ //acessa o elemento no topo da lista sem removê-lo
        if(topo == null){
            System.out.println("Pilha Vazia");
            return null;
        }
        return topo.getDado();
    }

    public T pop(){ //remove um elemento no topo da lista
        if(topo == null){
            System.out.println("Pilha Vazia");
            return null;
        }
        T dadoTemp = topo.getDado();
        topo = topo.getNextNo();
        return dadoTemp;
    }

    public boolean isEmpty() { //Verificar se a pilha está vazia é essencial para evitar erros.
        return topo == null;
    }

    public void imprimePilha(){
        if(topo == null){
            System.out.println("Pilha Vazia");
        }else{
            System.out.printf("Dados da pilha %s:\n",nomePilha);
            No<T> aux = topo;
            while (aux != null) {
                System.out.printf("%s\n", aux.toString());
                aux = aux.getNextNo();
            }
        }
    }
}