package classes;

import java.text.SimpleDateFormat;

public class DateConverter {

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm dd/MM/yyyy");

    public static String format(long mills){ return dateFormat.format(mills); }

}
