package model.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservas {
	
	private Integer numeroQuarto;
	private Date entrada;
	private Date saida;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservas(Integer numeroQuarto, Date entrada, Date saida) {
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
	
	public String atualizaDatas(Date entrada, Date saida) {
		
		Date now = new Date();
		if (entrada.before(now) || saida.before(now)) {
			return "Data de reserva devem ser no futuro";
		}
		
		if  (!saida.after(entrada)) {
			return "Data de saída deve ser após data de entrada";
		}
		
		this.entrada = entrada;
		this.saida	= saida;	
		return null;  //Não deu nenhum erro
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
