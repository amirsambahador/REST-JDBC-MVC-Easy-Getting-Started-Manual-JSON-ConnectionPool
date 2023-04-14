package org.j2os.project.common.json;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class JSON {
    private JSON(){}
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    public static String get(Object o) throws Exception {
        return OBJECT_MAPPER.writeValueAsString(o);
    }
}
