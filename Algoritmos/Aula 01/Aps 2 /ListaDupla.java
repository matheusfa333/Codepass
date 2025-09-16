public class ListaDupla<T> {
   private NoDuplo<T> primeiroNo;
    private NoDuplo<T> ultimoNo;
    private String nomeLista;
    private int tamanho;

    public ListaDupla(String nomeLista) {
        this.nomeLista = nomeLista;
        this.primeiroNo = null;
        this.ultimoNo = null;
        this.tamanho = 0;
    }

    public void atualizaIndice() {
        NoDuplo<T> atual = primeiroNo; 
        int indice = 0;
        while (atual != null) {
            atual.setIndice(indice);
            atual = atual.getProximoNo();
            indice++;
        }
    }


    public void addInicio(T dado) {
        NoDuplo<T> novoNo = new NoDuplo<T>(dado);

        if (primeiroNo == null) {
            primeiroNo = novoNo;
            ultimoNo = novoNo;
        } else {
            novoNo.setProximoNo(primeiroNo);
            primeiroNo.setAnteriorNo(novoNo);
            primeiroNo = novoNo;
        }

        atualizaIndice(); 
        tamanho++;
    }
    

    public void imprimeLista() {
    if (primeiroNo == null) {
        System.out.println("Lista vazia\n"); 
    } else {
        System.out.println("Dados da lista: " + nomeLista);
        NoDuplo<T> aux = primeiroNo;
        while (aux != null) {
            System.out.println(aux);
            aux = aux.getProximoNo();
        }
        System.out.println("\n"); 
    }
}

    public void addFinal(T dado) {
        NoDuplo<T> novoNo = new NoDuplo<T>(dado);

        if (ultimoNo == null) {
            primeiroNo = novoNo;
            ultimoNo = novoNo;
        } else {
            novoNo.setAnteriorNo(ultimoNo);
            ultimoNo.setProximoNo(novoNo);
            ultimoNo = novoNo;
        }

        atualizaIndice();
        tamanho++;
    }


     public void addIndice(int indice, T dado) {
        if (indice < 0 || indice > tamanho) {
            System.out.println("Índice inválido: " + indice);
            return;
        }

        if (indice == 0) {
            addInicio(dado);
            return;
        }
        if (indice == tamanho) {
            addFinal(dado);
            return;
        }

        NoDuplo<T> atual = primeiroNo;
        for (int i = 0; i < indice; i++) {
            atual = atual.getProximoNo();
        }

        NoDuplo<T> novoNo = new NoDuplo<>(dado);
        NoDuplo<T> anterior = atual.getAnteriorNo();

        novoNo.setProximoNo(atual);
        novoNo.setAnteriorNo(anterior);
        anterior.setProximoNo(novoNo);
        atual.setAnteriorNo(novoNo);

        tamanho++;
    }


    public T removeIndice(int indice) {
    if (indice < 0 || indice >= tamanho) {
        System.out.println("Índice inválido: " + indice);
        return null;
    }

    NoDuplo<T> removido;

    if (indice == 0) {
        removido = primeiroNo;
        primeiroNo = primeiroNo.getProximoNo();
        if (primeiroNo != null) {
            primeiroNo.setAnteriorNo(null);
        } else {
            ultimoNo = null; // lista ficou vazia
        }
    } else if (indice == tamanho - 1) {
        removido = ultimoNo;
        ultimoNo = ultimoNo.getAnteriorNo();
        if (ultimoNo != null) {
            ultimoNo.setProximoNo(null);
        } else {
            primeiroNo = null;
        }
    } else {
        removido = primeiroNo;
        for (int i = 0; i < indice; i++) {
            removido = removido.getProximoNo();
        }
        removido.getAnteriorNo().setProximoNo(removido.getProximoNo());
        removido.getProximoNo().setAnteriorNo(removido.getAnteriorNo());
    }

    tamanho--;
    atualizaIndice();
    return removido.getDado();
}

}