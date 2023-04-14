package org.j2os.project.common.wrapper;

import org.j2os.project.common.exception.RecordNotExistException;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ErrorHandler {
    private ErrorHandler() {
    }

    public static Map getError(Exception e) {
        Map<String, String> map = new HashMap<>();
        e.printStackTrace();
        if (e instanceof ArithmeticException) {
            map.put("CODE", "101");
            map.put("MSG", "Arithmetic Error");
            return map;
        } else if (e instanceof SQLException) {
            map.put("CODE", "102");
            map.put("MSG", "DataBase Error");
            return map;
        } else if (e instanceof RecordNotExistException) {
            map.put("CODE", "103");
            map.put("MSG", "Not Found Error");
            return map;
        } else {
            map.put("CODE", "200");
            map.put("MSG", "Support");
            return map;
        }
    }
}
