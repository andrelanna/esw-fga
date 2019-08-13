package aula1.exemplo1_EntradaSaida;

import java.util.Scanner;

public class Textual {
	public static void main(String[] args) {
		//Declaracao de variaveis numericas e textuais
		String nome, sobrenome;
		double altura, peso;
		float imc;
		
		//Leitura dos valores das variaveis via console
		//A instrucao abaixo cria um leitor (scanner) associado a entrada
		//padrao do sistema (System.in)
		Scanner sc = new Scanner(System.in);
		
		//A partir do Scanner sc, podemos pedir valores de diferentes tipos
		//vindos do teclado. 
		System.out.println("Informe o nome da pessoa: ");
		nome = sc.nextLine();
		sobrenome = sc.nextLine();
		System.out.println("Informe a altura da pessoa: ");
		altura = sc.nextDouble();
		System.out.println("Informe o peso da pessoa: ");
		peso = sc.nextDouble();
		
		//Calculo do IMC com downcasting
		imc = (float)(peso/Math.pow(altura, 2));
		
		//Impressao do resultado, com upcasting.
		String resposta = nome + " " + sobrenome + " possui " + 
				" altura igual a " + altura + " e peso igual a " +
				peso + ". ";
		resposta += "O IMC calculado é " + imc + ". ";
		System.out.println(resposta);
	}
	
}
