import java.util.*;
public class Exercicio8_3 {

	static String vetCidades[] = {"BELO HORIZONTE","SAO PAULO","RIO DE JANEIRO","SALVADOR","CURITIBA"};
	
	public static void main(String[] args) {
		// 1 - variaveis
		String nomeHospede[] = new String[100];
		byte diaEntrada;
		byte diaSaida;
		String tipoQuarto;
		String cidadeHotel;
		float vlrConta[] = new float[100];
		float somaVlrConta = 0;
		boolean encontrou;
		byte cont;
		float mediaContas;
		Scanner leia = new Scanner(System.in);
		
		for (cont = 0; cont <= 99; cont++) {
			System.out.print("Digite o nome do hospede (FIM p encerrar): ");
			nomeHospede[cont] = leia.nextLine();
			
			if (nomeHospede[cont].equalsIgnoreCase("fim")) {
				break;
			}
					
			do {
				System.out.print("Digite o dia da entrada no hotel: ");
				diaEntrada = leia.nextByte();
				System.out.print("Digite o dia da saida no hotel: ");
				diaSaida = leia.nextByte();
				if (diaSaida <= diaEntrada) {
					System.out.println("valor invalido, digite dia saida maior que dia entrada");
				}
			}while(diaSaida <= diaEntrada);
			
			do {
				System.out.print("Digite o tipo de quarto: ");
				tipoQuarto = leia.next();
				if ( ! tipoQuarto.equals("STANDARD") && ! tipoQuarto.equals("LUXO") && 
						! tipoQuarto.equals("SUPER-LUXO")) {
					System.out.println("Tipo de quarto invalido, digite STANDARD, LUXO ou SUPER-LUXO");
				}
			}while(! tipoQuarto.equals("STANDARD") && ! tipoQuarto.equals("LUXO") && 
					! tipoQuarto.equals("SUPER-LUXO"));
			
			leia.nextLine();
			do {
				System.out.println("Cidade onde esta localizado o hotel: ");
				cidadeHotel = leia.nextLine();
				encontrou = cidadeEhValida(cidadeHotel);
				if ( ! encontrou ) { // encontrou == false
					System.out.println("Nao ha hotel nesta cidade !");
				}
			}while( ! encontrou );
			
			// 3 - calculos
			vlrConta[cont] = calcularConta(diaEntrada, diaSaida, tipoQuarto);
			somaVlrConta = somaVlrConta + vlrConta[cont];
			System.out.println("Valor da conta: " + vlrConta[cont]);
			
		} // fim do for
		
		mediaContas = somaVlrConta / cont;
		System.out.println("Relatorio de contas acima da media");
		System.out.println("Nome hospede     Valor conta");
		System.out.println("---------------- -----------");
		for (int x = 0; x < cont; x++) {
			if (vlrConta[x] > mediaContas) {
				System.out.println(nomeHospede[x] + "               " + vlrConta[x]);				
			}
		}
		
	} // fim do main

	public static boolean cidadeEhValida (String cidade) {
		boolean encontrou = false;
		for (int x = 0; x <= 4; x++) {
			if (cidade.equalsIgnoreCase(vetCidades[x])) {
				encontrou = true;
				break;
			}
		}
		return encontrou;
	}
	
	public static float calcularConta (byte entrada, byte saida, String tpQuarto) {
		float vlrDiaria;
		// float vlrConta;
		if (tpQuarto.equals("STANDARD")) {
			vlrDiaria = 120;
		} else if (tpQuarto.equals("LUXO")) {
			vlrDiaria = 150;
		} else {
			vlrDiaria = 180;
		}
//		vlrConta = (saida - entrada) * vlrDiaria;
//		return vlrConta;
		
		return (saida - entrada) * vlrDiaria;
	}
	
}
