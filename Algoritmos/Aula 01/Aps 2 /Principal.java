public class Principal {
    public static void main(String[] args) {
        ListaDupla<Produto> lista = new ListaDupla<>("Produtos");

        lista.addInicio(new Produto("Arroz", 35));
        lista.imprimeLista();

        lista.addFinal(new Produto("feijao ", 15));
        lista.imprimeLista();

        lista.addIndice(1, new Produto("acucar", 5.0));
        lista.imprimeLista();
        
        Produto removido = lista.removeIndice(1);
        System.out.println("Produto removido: " + removido + "\n");

        lista.imprimeLista();
        
         lista.addInicio(new Produto("Leite", 8.0));
        lista.imprimeLista();

        lista.addFinal(new Produto("Café", 12.0));
        lista.imprimeLista();
    }

       
}