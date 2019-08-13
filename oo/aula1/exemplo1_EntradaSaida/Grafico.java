package aula1.exemplo1_EntradaSaida;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Grafico {
	public static void main(String[] args) {
		//Declaracao de variaveis numericas e textuais
		String nome, sobrenome;
		double altura, peso;
		float imc;
		
		//Leitura via interface grafica sempre traz valores STRING
		//Portanto, é SEMPRE necessário fazer o casting com metodos apropriados
		
		
		//Comando abaixo apresenta mensagem para o usuario em uma CAIXA DE ENTRADA
		//A String lida é armazenada na variavel nome
		nome = JOptionPane.showInputDialog("Informe o nome da pessoa: ");
		//A String lida é armazenada na variavel sobrenome
		sobrenome = JOptionPane.showInputDialog("Informe o sobrenome da pessoa:");
		
		//Leitura de valores numericos --> tem que fazer conversao de tipos
		String strAltura = JOptionPane.showInputDialog("Informe a altura da pessoa:");
		//... em seguida faz o casting para o tipo usando o método apropriado
		altura = Double.parseDouble(strAltura); //Double.parseDouble(string)
		String srtPeso = JOptionPane.showInputDialog("Informe o peso da pessoa: ");
		peso = Double.parseDouble(srtPeso);
		
		//Calculo do IMC com downcasting
		imc = (float)(peso/Math.pow(altura, 2));
		
		//Impressao do resultado, com upcasting.
		String resposta = nome + " " + sobrenome + " possui " + 
				" altura igual a " + altura + " e peso igual a " +
				peso + ". ";
		resposta += "O IMC calculado é " + imc + ". ";
		
		//Saida em modo gráfico
		JOptionPane.showMessageDialog(null, resposta);
	}
	
}
