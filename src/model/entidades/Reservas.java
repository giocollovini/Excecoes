package model.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.excecoes.excecoesDominio;

public class Reservas {
	
	private Integer numeroQuarto;
	private Date entrada;
	private Date saida;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservas(Integer numeroQuarto, Date entrada, Date saida) { 
		if  (!saida.after(entrada)) {
			throw new excecoesDominio("Data de saída deve ser após data de entrada");
		}
		
		this.numeroQuarto = numeroQuarto;
		this.entrada = entrada;
		this.saida = saida;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getEntrada() {
		return entrada;
	}
	
	public Date getSaida() {
		return saida;
	}

	
	public long duracao() {
		
		long diferenca = saida.getTime() - entrada.getTime();
		return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
		
	}
	
	public void atualizaDatas(Date entrada, Date saida) {
		
		Date now = new Date();
		if (entrada.before(now) || saida.before(now)) {
			throw new excecoesDominio("Data de reserva devem ser no futuro");
		}
		
		if  (!saida.after(entrada)) {
			throw new excecoesDominio("Data de saída deve ser após data de entrada");
		}
		
		this.entrada = entrada;
		this.saida	= saida;	
	}
	

	@Override
	public String toString() {
		return "Quarto "
			+ numeroQuarto
			+ ", Entrada: "
			+ sdf.format(entrada)
			+ ", Saída: "
			+ sdf.format(saida)
			+ ", "
			+ duracao()
			+ " noites";
	}
	
}
