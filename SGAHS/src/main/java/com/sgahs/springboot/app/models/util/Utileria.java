package com.sgahs.springboot.app.models.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Utileria {
	
	public String localDateToString(LocalDate localDate) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        return localDate.format(formatter);
    }

}
