import java.util.Scanner;


public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        while(true){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int m = sc.nextInt();

            if(n == 0 && k == 0 && m == 0 ){
                break;
            }
            
        int[] v = new int[n];
        for(int i = 0; i < n; i++){
            v[i] = i + 1;
        }
     
        int posicao1 = 0;
        int posicao2 = n - 1;


         int cont = 0;

         while(cont < n){
            int seleciona1 = 0;
            int seleciona2 = 0;

            int i = k;
            while(i > 0){
                if(v[posicao1] > 0){
                    i--;
                }
                if(i == 0){
                    seleciona1 =  posicao1;
                }
                posicao1 = (posicao1 + 1) % n;
            }

            i = m;
            while (i > 0) {
                if(v[posicao2] > 0){
                    i--;
                }
                if( i == 0){
                    seleciona2 = posicao2;
                }
                posicao2 = (posicao2 + n - 1)%n;
            }

            if (cont > 0) {
                System.out.print(",");
            }

            if(seleciona1 != seleciona2){
                System.out.printf("%3d%3d", v[seleciona1], v[seleciona2]);
                cont += 2;
            }else{
                System.out.printf("%3d", v[seleciona1]);
                cont++;
            }
            v[seleciona1] = 0;
            v[seleciona2] = 0;
         }
         System.out.println();
    }
    sc.close();
    }
}