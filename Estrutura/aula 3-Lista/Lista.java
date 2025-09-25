public class Lista<T> {
    private No<T> primeiroNo;
    private No<T> ultimoNo;
    private String nomeLista;

    public Lista() {
        this("Lista");
    }

    public Lista(String nomeLista) {
        this.nomeLista = nomeLista;
        this.primeiroNo = null;
        this.ultimoNo = null;
    }

    public void addInicio(T dado) {
        No<T> novoNo = new No<T>(dado);
        if (primeiroNo == null) {
            primeiroNo = novoNo;
            ultimoNo = novoNo;
        } else {
            novoNo.setNextNo(primeiroNo);
            primeiroNo = novoNo;
        }
    }

    public void removeInicio() {
        if (primeiroNo == null) {
            System.out.println("Lista vazia!");
        } else {
            System.out.println("Dado: " + primeiroNo.getDado() + " removido!");

            if (primeiroNo == ultimoNo) {
                primeiroNo = primeiroNo.getNextNo();
                ultimoNo = ultimoNo.getNextNo();
            } else {
                primeiroNo = primeiroNo.getNextNo();
            }
        }
    }

    public void addFinal(T dado) {
        No<T> novoNo = new No<T>(dado);
        if (ultimoNo == null) {
            primeiroNo = novoNo;
            ultimoNo = novoNo;
        } else {
            ultimoNo.setNextNo(novoNo);
            ultimoNo = novoNo;
        }
    }

    public void removeFinal() {
        if (ultimoNo == null) {
            System.out.println("Lista vazia!");
        } else {
            System.out.println("Dado: " + ultimoNo.getDado() + " removido!");

            if (primeiroNo == ultimoNo) {
                primeiroNo = primeiroNo.getNextNo();
                ultimoNo = ultimoNo.getNextNo();
            } else {
                No<T> aux = primeiroNo;

                while (aux.getNextNo() != ultimoNo) {
                    aux = aux.getNextNo();
                }

                ultimoNo = aux;
                aux.setNextNo(null);
            }
        }
    }

    public No<T> getUltimoNo() {
        return this.ultimoNo;
    }

    public void imprimeLista() {
        if (primeiroNo == null) {
            System.out.println("Lista vazia!");
        } else {
            System.out.println("Dados da Lista " + nomeLista);
            No<T> aux = primeiroNo;
            while (aux != null) {
                System.out.println(aux.toString());
                aux = aux.getNextNo();
            }
        }
    }
}