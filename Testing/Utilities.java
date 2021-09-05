package Testing;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilities {

    private static final SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public static boolean isNullOrEmpty(String... strParams) {
        for (String x : strParams)
            if (x == null || x.length() == 0)
                return true;

        return false;
    }

    public static String getCurrentDate() {
        Date date = new Date(System.currentTimeMillis());
        return dateFormatter.format(date);
    }
}

