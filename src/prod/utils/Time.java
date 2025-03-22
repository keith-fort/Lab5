package prod.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {

	static Date currentDate = new Date();
    static SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
    static String formattedDate = formatter.format(currentDate);
    
    public static String getTime() {
    	return formattedDate; // Пример: 01.01.2023 12:34:56
    }
    
}
