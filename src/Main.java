import java.io.*;
import java.util.*;

/**
 * 
 * @author Diovani Bernardi da Motta Data: 30/08/2016 Data: 30/08/2016
 *         Implementacao do problema SPOJ - 818 AeroPorto
 */
public class Main {

	private static class Grafo {

		public int a;
		public int v;
		public int[] arestas;

	}
	
	public static void input(){
		try {
		
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
	
	public static void process(Grafo grafo){
		try {
		} catch (Exception exception) {
			exception.printStackTrace();
		}	
	}
	
	public static void print(Grafo grafo){
		try {
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try {
			int teste = 0, i, maximo, a, v;
			String linha = "";
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			Grafo grafo = new Grafo();
			while ((linha = br.readLine()) != null) {
				StringTokenizer tokenizer = new StringTokenizer(linha);
				grafo.a = Integer.parseInt(tokenizer.nextToken().trim());
				grafo.v = Integer.parseInt(tokenizer.nextToken().trim());
				grafo.arestas = new int[grafo.a];
				maximo = 0;
				teste++;
				for (i = 0; i < grafo.a; i++)
					grafo.arestas[i] = 0;
				for (i = 0; i < grafo.v; i++) {
					linha = br.readLine();
					tokenizer = new StringTokenizer(linha);
					a = Integer.parseInt(tokenizer.nextToken().trim());
					v = Integer.parseInt(tokenizer.nextToken().trim());
					if (++(grafo.arestas[a - 1]) > maximo)
						maximo++;
					if (++(grafo.arestas[v - 1]) > maximo)
						maximo++;
				}
				System.out.println(String.format("Teste %d\n", teste));
				for (i = 0; i < grafo.a; i++)
					if (grafo.arestas[i] == maximo)
						System.out.print(String.format("%d ", i + 1));
				System.out.println("\n");
			}
			System.exit(0);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
}