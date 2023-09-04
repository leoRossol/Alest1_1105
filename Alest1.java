import java.util.Scanner;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int B, N;
        int [] reservas;
        
        System.out.println("bancos");
        B=in.nextInt(); //Bancos

        System.out.println("debenture");
        N=in.nextInt(); //Debentures

        reservas = new int[B]; //ReservasBancos

        // Le reservas monetarias de cada banco
        for (int i = 0; i<B; i++) {
            System.out.println("reservas");
            reservas[i] = in.nextInt();
        }

        //ArrrayList com dados de devedores e etc.
        ArrayList<int[]> debitos = new ArrayList<int[]>();

        //Le os devedores e credores
        for (int i = 0; i<N; i++) {
            System.out.println("devedor");
            int D = in.nextInt(); //Banco devedor
            
            System.out.println("credor");
            int C = in.nextInt(); //Banco credor

            System.out.println("valor");
            int V = in.nextInt(); //Valor do debenture

            int[] debito = {D,C,V,};
            debitos.add(debito);
        }

        
        //faz as transacoes
        for (int debito[] : debitos) {
            int D = debito[0];
            int C = debito[1];
            int V = debito[2];

            reservas[D-1] -= V;
            reservas[C-1] += V;
        }

        
        //Verifica se o banco tem como pagar 
        boolean intervencao = false;
        for (int i=0; i<B; i++){
            if (reservas[i] < 0){
                intervencao = true;
                break;
            }
        }

        //imprime se e necessario intervencao do governo
        if (intervencao){
            System.out.println("Intervencao");
        } else {
            System.out.println("Sem intervencao");
        }
}
}