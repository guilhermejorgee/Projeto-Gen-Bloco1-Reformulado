package br.com.eu.matriz;

import java.util.Scanner;

public class TriagemVirtual extends Atributos {
	
			
	
	void processoTriagem() throws InterruptedException {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("\nO resultado do teste n�o � um diagn�stico. O teste serve"
				+ "\nsomente para fins informativos e n�o dever�, em"
				+ "\ncircunst�ncia alguma, ser considerado como opini�o"
				+ "\nm�dica qualificada");
		
		System.out.println("\nN�o usar em caso de emerg�ncia. Em caso de perigo para a sa�de,"
				+ "\nligue imediatamente para o n�mero de emerg�ncia local.");
		
		System.out.println("\nIniciando teste...");
		
		Thread.sleep(700);
			
		System.out.println("\nInforme quantas pessoas ser�o analisadas");	
		System.out.print("\nDigite: ");
		String[][] matriz = new String[entrada.nextInt()][6];
		
		int qtd = 1;
							
		for(int i = 0; i<matriz.length; i++){	
			
			System.out.println("\n"+qtd++ +"�" + " Analisado(a)");
			
			for(int c = 0; c<6; c++) {
				
				if(c == 0) {
					entrada.nextLine();
					System.out.println("\nInforme o nome para identifica��o");
					System.out.print("\nDigite: ");
					super.setNome(entrada.nextLine());
					
					matriz[i][c] = super.getNome();
					
				}
				
				else if(c == 1) {
					System.out.println("\nApresentou Febre maior ou igual a 37,8�C ?"
							+ "\n[1]Sim\n[0]N�o" );
					System.out.print("\nDigite: ");
					super.setFebre(entrada.nextInt());
					
					matriz[i][c] = Integer.toString(super.getFebre());
				
				}
				
				else if(c == 2) {
				
				System.out.println("\nApresentou problemas respirat�rios elevados?"
						+ "\n[1]Sim\n[0]N�o" );
				System.out.print("\nDigite: ");
				super.setRespiratorio(entrada.nextInt());
				
				matriz[i][c] = Integer.toString(super.getRespiratorio());
				
				}
				
				else if(c == 3) {
				
				System.out.println("\nApresentou quadro de tosse?"
						+ "\n[1]Sim\n[0]N�o" );
				System.out.print("\nDigite: ");
				super.setOutros(entrada.nextInt() + super.getOutros());
				
				System.out.println("\nApresentou quadro de dispneia?"
						+ "\n[1]Sim\n[0]N�o" );
				System.out.print("\nDigite: ");
				super.setOutros(entrada.nextInt() + super.getOutros());
				
				System.out.println("\nApresentou quadro de mialgia e fadiga?"
						+ "\n[1]Sim\n[0]N�o" );
				System.out.print("\nDigite: ");
				super.setOutros(entrada.nextInt() + super.getOutros());
				
				matriz[i][c] = Integer.toString(super.getOutros());
				
				}
				
				else if(c == 4) {
				
				System.out.println("\nPossui algumas dessas comorbidades?"
						+ "\n\nDoen�a Cardiovascular\nDiabetes\nDoen�a Respirat�ria Cr�nica\nHipertens�o\nC�ncer"
						+ "\n\n[1]Sim\n[0]N�o" );
				System.out.print("\nDigite: ");
				super.setComorbidade(entrada.nextInt());
				
				matriz[i][c] = Integer.toString(super.getComorbidade());
				
				}
				
				else if(c == 5) {
				
				matriz[i][5] = resultadoTriagem(matriz[i][4], matriz[i][1], matriz[i][2], matriz[i][3]);
				
				//System.out.println("A situa��o de: " + matriz[i][0] + "\n" + matriz[i][5]);
				
				}
		
			}
			

		}
		
		
		
		for(int i = 0; i<matriz.length; i++) {
			
			if((Integer.parseInt(matriz[i][4]) == 0 || Integer.parseInt(matriz[i][4]) == 1) && (Integer.parseInt(matriz[i][1]) == 0 || Integer.parseInt(matriz[i][1]) == 1) && (Integer.parseInt(matriz[i][2]) == 0 || Integer.parseInt(matriz[i][2]) == 1) && (Integer.parseInt(matriz[i][3]) == 0 || Integer.parseInt(matriz[i][3]) == 1)) {
			
				System.out.println("\nA situa��o de: " + matriz[i][0] + "\n" + matriz[i][5]);
			
			}
			else {
				System.out.println("O Sistema detectou que foram digitados valores fora do escopo do programa\nRefa�a a an�lise e atente-se ao n�mero da op��o");
			}
			
		}
		
		
	}
	
	String resultadoTriagem(String comorbidade, String febre, String respiratorio, String outros) {
		
		int toRespiratorio = Integer.parseInt(respiratorio);
		int toFebre = Integer.parseInt(febre);
		int toComorbidade = Integer.parseInt(comorbidade);
		int toOutros = Integer.parseInt(outros);
		String resultado;		
		
		double calculo = ((5 * toRespiratorio) + (4 * toFebre) + (3 * toComorbidade) + (0.50 * toOutros)) / 12.50;
		if(calculo >= 0.69 ) {
			resultado = "Preocupante - Recomendamos que procure uma unidade de sa�de";
		}
		else if(calculo >= 0.53 && calculo < 0.69) {
			resultado = "Fique alerta - Recomendamos que se os sintomas piorarem procure uma unidade de sa�de";
		}
		else {
			resultado = "Observa��o - Recomendamos que mantenha o isolamento e monitore os sintomas";
		}
		
		return resultado;
	}	
	

}
