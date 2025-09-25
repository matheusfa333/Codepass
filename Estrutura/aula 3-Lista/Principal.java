public class Principal {
     public static void main(String[] args){
        Lista<String> lista = new Lista<String>("Alunos");

        //lista.imprimeLista();

        lista.addInicio("Rafael");
        lista.addInicio("Gabriel");
        lista.addFinal("Daniel");

        /*
        lista.imprimeLista();
        lista.removeInicio();

        lista.imprimeLista();
        lista.removeInicio();

        lista.imprimeLista();
        lista.removeInicio();
        lista.imprimeLista();

         */
        lista.imprimeLista();
        lista.removeFinal();

        lista.imprimeLista();
        lista.removeFinal();

        lista.imprimeLista();

        lista.removeFinal();

        lista.imprimeLista();
     }
}