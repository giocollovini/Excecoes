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
			
			Date now = new Date();
			if (entrada.before(now) || saida.before(now)) {
				System.out.println("Erro na reserva: Data de reserva devem ser no futuro");
			}
			else if  (!saida.after(entrada)) {
				System.out.println("Erro na reserva: Data de sa�da deve ser ap�s data de entrada");
			}
			else {
				reservas.atualizaDatas(entrada, saida);
				System.out.println("Reserva: " + reservas);
			}
		}

		sc.close();
	}

}
