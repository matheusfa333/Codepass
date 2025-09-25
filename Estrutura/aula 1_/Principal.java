import java.util.ArrayList;

public class Principal{

    public static void main(String[] args){
        /*
        Pessoa obj1 = new Pessoa("Rafael", 34);
        Pessoa obj2 = new Pessoa("Gabriel", 28);
        Pessoa obj3 = new Pessoa("Danielly", 38);
       
        System.out.println(obj1.toString());
        System.out.println(obj2.toString());
        System.out.println(obj3.toString());
        */
        ArrayList<Pessoa> listaP = new ArrayList<Pessoa>();
        listaP.add(new Pessoa("Rafael",34));
        listaP.add(new Pessoa("Gabriel",28));
        listaP.add(new Pessoa("Danielly",38));

        /*
        System.out.println(listaP.get(0));
        System.out.println(listaP.get(1));
        System.out.println(listaP.get(2));
        */
        for(Pessoa auxP : listaP){
            System.out.println(auxP.toString());
        }
    }
}