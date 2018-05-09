package br.emprestimo.testeUnitario;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class Principal {

	public static void main(String[] args) {

		DateTimeFormatter fmt = DateTimeFormat.forPattern("dd/MM/YYYY");
		String data = "16/05/2018";
		DateTime umaData = fmt.parseDateTime(data);
		System.out.println(umaData.dayOfWeek().getAsText());
		
			if (umaData.dayOfWeek().getAsText().equals("Domingo"));{
				System.out.println("e domingo");
			}
		}

	}


