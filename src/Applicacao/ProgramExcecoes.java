package Applicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entidades.Reservas;

public class ProgramExcecoes {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		System.out.println("Programa para ler os dados de uma reserva de hotel(n�mero do quarto,data de entrada e data de sa�da)");
		System.out.println("mostrar os dados da reserva, inclusive sua dura��o em dias. Ap�s ler novas datas de entrada e sa�da,"); 
		System.out.println("atualizar a reserva, e mostrar dados atualizados da reserva."); 
		System.out.println("Regras:"); 
		System.out.println("	  - Altera��es de reserva s� para datas futuras");
		System.out.println("	  - Data de saida sempre maoir que data de entrada");
		System.out.println();
		
		System.out.print("Quarto N�mero: ");
		int numero = sc.nextInt();
		System.out.print("Data Entrada (dd/MM/yyyy): ");
		Date entrada = sdf.parse(sc.next());
		System.out.print("Data Sa�da (dd/MM/yyyy): ");
		Date saida = sdf.parse(sc.next()); 
		
		if  (!saida.after(entrada)) {
			System.out.println("Erro na reserva: Data de sa�da deve ser ap�s data de entrada");
		}
		else {
			Reservas reservas = new Reservas(numero, entrada, saida);
			System.out.println("Reserva: " + reservas);
			
			System.out.println();
			System.out.println("Entra com as datas para atualizar a reserva");
			System.out.print("Data Entrada (dd/MM/yyyy): ");
			entrada = sdf.parse(sc.next());
			System.out.print("Data Sa�da (dd/MM/yyyy): ");
			saida = sdf.parse(sc.next()); 
			
			
			String erro = reservas.atualizaDatas(entrada, saida);
			if (erro != null ) {
				System.out.println("Erro na reserva: " + erro);
			}
			else {
				System.out.println("Reserva: " + reservas);
			}
		}

		sc.close();
	}

}
