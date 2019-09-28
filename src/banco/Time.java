package banco;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Time {
		
	private Date dataAbertura;
	public Date agora;
	public String dataTexto, horaTexto;
	SimpleDateFormat dataForm = new SimpleDateFormat("dd/MM/yyyy");
	SimpleDateFormat horaForm = new SimpleDateFormat("HH:mm:ss");
	private LocalDate now;
	
	public Time() {
		setNowTime();
	}

	
	//metodos set	
	public void setNowTime() {//Define horaTexto com a Hora atual
		
		now = LocalDate.now();
	//	dataAbertura = Date.from(now.atStartOfDay(ZoneId.systemDefault()).toInstant());
		dataAbertura = new Date();
		dataTexto = dataForm.format(dataAbertura);
		horaTexto = horaForm.format(dataAbertura);
	}
	
	public String dataNow() {
		agora = new Date();
		return dataForm.format(agora);
	}
	
	public String horaNow() {
		agora = new Date();
		return horaForm.format(agora);
	}
	
	public int subtrairDataMeses () {
		int i = 0;
		now = LocalDate.now();
		String [] data2 = dataTexto.split("/");
		String dia = data2 [0];
		String mes = data2 [1];
		String ano = data2 [2];
		String novaData = ano + "-" + mes + "-" + dia;
		LocalDate abertura = LocalDate.parse(novaData);
		if (abertura.compareTo(now) < 0) {
			long diferencaMeses = ChronoUnit.MONTHS.between(abertura, now);
			i = (int) diferencaMeses;
		}
		return i;
	}
	
		
	

}

