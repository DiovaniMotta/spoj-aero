import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        Main processando = new Main();
        processando.processa();
       
        System.exit(0);
    }
   
    void processa() throws NumberFormatException, IOException {
        String line = "";
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] vetor = new int[100];
        int contador = 0;       
        while((line = br.readLine()) != null) {
            StringTokenizer tokenizer = new StringTokenizer(line);
            int aeroportos = Integer.valueOf(tokenizer.nextToken());
            int voos = Integer.valueOf(tokenizer.nextToken());
           
            if (aeroportos == 0 && voos == 0) {
                return;
            }
           
            contador++;
            System.out.println("Teste " + contador);
           
            for (int i = 0; i < aeroportos; i++) {
                vetor[i] = 0;
            }
            for (int i = 0; i < voos; i++) {
                line = br.readLine();
                tokenizer = new StringTokenizer(line);
                int a = Integer.valueOf(tokenizer.nextToken());
                int b = Integer.valueOf(tokenizer.nextToken());
                vetor[a-1]++;
                vetor[b-1]++;               
            }
            int maior = -1;
            for (int i = 0; i < aeroportos; i++) {
                if (vetor[i] > maior) {
                    maior = vetor[i];
                }           
            }
            for (int i = 0; i < aeroportos; i++) {
                if (vetor[i] == maior) {
                    System.out.print(i+1 + " ");
                }           
            }
            System.out.println("\n");
        }
                   
        return;
    }
}