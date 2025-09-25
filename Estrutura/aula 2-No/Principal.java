import java.util.Scanner;

    public class Principal{
        public static void main(String[] args){

    Scanner input = new Scanner(System.in);

    No<String> obj1 = new No<String>("Rafael");
    System.out.println(obj1.toString());
    No<String> obj2 = new No<String>("Lara");
    System.out.println(obj2.toString());
    No<String> obj3 = new No<String>("Cecília");
    System.out.println(obj3.toString());

    System.out.println("Imprimindo dadados da lista.");
    System.out.println(obj1.toString());
        
    obj1.setNextNo(obj2);

    System.out.println(obj1.getNextNode().toString());
    
    obj2.setNextNo(obj3);

    System.out.println(obj2.getNextNode().toString());
        
    System.out.println("Imprimindo dadados da lista com o while.");
    No<String> aux = obj1;

    while(aux != null){
        System.out.println(aux.toString());
        aux = aux.getNextNode();
}

}

    
}