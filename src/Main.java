import java.io.*;
import java.util.*;

/**
 * 
 * Diovani Bernardi da Motta Data: 31/08/2016 Implementacao algoritmica para a
 * solucao do problema SPOJ Aeroporto
 * 
 * 
 * AERO - Aeroporto A crescente utilizacao do transporte aereo preocupa os
 * especialistas, que preveem que o congestionamento em aeroportos podera se
 * tornar um grande problema no futuro. Os numeros atuais já sao alarmantes:
 * relatorios oficiais demonstram que na Europa, em junho de 2001, houve uma
 * media de 7.000 atrasos de voos por dia. Preocupada com a previsao dos seus
 * especialistas em trafego aereo, a Associacao de Transporte Aereo
 * Internacional (ATAI) esta comecando um estudo para descobrir quais sao os
 * aeroportos onde o trafego aereo pode vir a ser mais problematico no futuro.
 * 
 * Tarefa Como programador recem contratado pela ATAI voce foi encarregado de
 * escrever um programa para determinar, a partir de uma listagem de aeroportos
 * e voos, qual aeroporto possui maior probabilidade de congestionamento no
 * futuro. Como medida da probabilidade de congestionamento sera utilizado neste
 * estudo o numero total de voos que chegam ou que partem de cada aeroporto.
 * 
 * Entrada A entrada e composta de varios conjuntos de teste. A primeira linha
 * de um conjunto de teste contem dois numeros inteiros A e V, que indicam
 * respectivamente o numero de aeroportos e o numero de voos. Os aeroportos sao
 * identificados por inteiros de 1 a A. As V linhas seguintes contem cada uma a
 * informacao de um voo, representada por um par de numeros inteiros positivos X
 * e Y, indicando que ha um voo do aeroporto X para o aeroporto Y. O final da
 * entrada e indicado quando A = V = 0.
 * 
 * Saída Para cada conjunto de teste da entrada seu programa deve produzir tres
 * linhas. A primeira linha identifica o conjunto de teste, no formato “Teste
 * n”, onde n é numerado a partir de 1. A segunda linha deve conter o
 * identificador do aeroporto que possui maior tráfego aéreo. Caso mais de um
 * aeroporto possua este valor maximo, voce deve listar todos estes aeroportos,
 * em ordem crescente de identificacao, e separados por pelo menos um espaco em
 * branco. A terceira linha deve ser deixada em branco. A grafia mostrada no
 * Exemplo de Saida, abaixo, deve ser seguida rigorosamente.
 * 
 * Exemplo 
 * Entrada: 
 * 5 7 
 * 1 3 
 * 2 1 
 * 3 2 
 * 3 4 
 * 4 5 
 * 3 5 
 * 2 5 
 * 3 5 
 * 1 3 
 * 1 2 
 * 3 2 
 * 1 2
 * 2 1 
 * 0 0
 * 
 * Output: 
 * Teste 1 
 * 3
 * 
 * Teste 2 
 * 1 2
 */
public class Main {

	private static int indexador;


	/**
	 * 
	 * @author Diovani Classe que representa a especificacao, modelo empregado
	 *         para a solucao do problema
	 */
	public static class Grafo {

		public int a; // numero de aeroportos
		public int v; // numero de voos
		public int[] aresta; 

	}


	/**
	 * Inicializacao do software
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		input();
		System.exit(0);
	}


	/**
	 * Responsavel por invocar o método que irá verificar o aeroporto que tem maior probabilidade de possuir congestionamento
	 * impressao no console dos dados processados na busca
	 * 
	 * @param grafo
	 *            objeto contendo as definicoes do problema
	 */
	private static void process(Grafo grafo) {
		int maior = -1;
		for (int i = 0; i < grafo.a; i++)
			if (grafo.aresta[i] > maior)
				maior = grafo.aresta[i];
		for (int i = 0; i < grafo.a; i++)
			if (grafo.aresta[i] == maior)
				System.out.print(i + 1 + " ");
		System.out.println();
	}

	/**
	 * Responsavel por efetuar a captura das entradas de dados
	 */
	private static void input() {
		try {
			indexador = 0;
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			String linha = new String("");
			Grafo grafo = new Grafo();
			grafo.aresta = new int[100];
			while ((linha = br.readLine()) != null) {
				StringTokenizer tokenizer = new StringTokenizer(linha);
				grafo.a = Integer.valueOf(tokenizer.nextToken());
				grafo.v = Integer.valueOf(tokenizer.nextToken());
				if (grafo.a == 0 && grafo.v == 0)
					return;
				indexador++;
				System.out.println("Teste " + indexador);
				for (int i = 0; i < grafo.a; i++)
					grafo.aresta[i] = 0;
				for (int i = 0; i < grafo.v; i++) {
					linha = br.readLine();
					tokenizer = new StringTokenizer(linha);
					int x = Integer.valueOf(tokenizer.nextToken());
					int y = Integer.valueOf(tokenizer.nextToken());
					grafo.aresta[x - 1]++;
					grafo.aresta[y - 1]++;
				}
				process(grafo);
			}
		} catch (Exception exception) {

		}
	}
}