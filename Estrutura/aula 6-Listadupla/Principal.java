public class Principal {

    public static void main(String[] args) {

        ListaDupla<String> lista = new ListaDupla<String>("Alunos");

        lista.addInicio("Pedro");
        lista.addInicio("Gil");
        lista.addFinal("Filho");

        lista.imprimeLista();

        lista.addMeio("macaco",12);

        lista.imprimeLista();

        lista.removeMeio(2);

        lista.imprimeLista();

/*
        lista.removeInicio();
        lista.imprimeLista();
        
        lista.removeFinal();

        lista.imprimeLista();
 */        
    }
}