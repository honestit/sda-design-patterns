package gof.builder;

import java.util.LinkedHashMap;
import java.util.Map;

public class URLBuilder {

    private String schema;
    private String domain;
    private Integer port;
    private String path;
    private Map<String, String> params = new LinkedHashMap<>();

    public URLBuilder schema(String schema) {
        this.schema = assertNotBlank(schema);
        return this;
    }

    public URLBuilder domain(String domain) {
        this.domain = assertNotBlank(domain);
        return this;
    }

    public URLBuilder port(Integer port) {
        if (port <= 0) {
            throw new IllegalArgumentException("Port nie może być wartością ujemną");
        }
        this.port = port;
        return this;
    }

    public URLBuilder port(String port) {
        try {
            return this.port(Integer.parseInt(port));
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("Wartość portu musi być liczbą", nfe);
        }
    }

    public URLBuilder path(String path) {
        path = assertNotBlank(path);
        if (!path.startsWith("/")) {
            throw new IllegalArgumentException("Poprawna ścieżka musi zaczynać się od '/'");
        }
        this.path = path;
        return this;
    }

    public URLBuilder param(String name, String value) {
        assertNotBlank(name);
        params.put(name, value);
        return this;
    }

    public URLBuilder param(String name) {
        return this.param(name, null);
    }

    public String build() {
        assertNotNull("Schemat", schema);
        assertNotNull("Domena", domain);
        assertNotNull("Ścieżka", path);

        StringBuilder builder = new StringBuilder(schema)
                .append("://")
                .append(domain);
        if (port != null) {
            builder.append(":").append(port);
        }
        builder.append(path);
        if (!params.isEmpty()) {
            builder.append("?");
            boolean first = true;
            for (String param : params.keySet()) {
                if (!first) {
                    builder.append("&");
                }
                first = false;
                builder.append(param);
                String value = params.get(param);
                if (value != null) {
                    builder.append("=").append(value);
                }
            }
        }
        return builder.toString();
    }

    private void assertNotNull(String field, Object value) {
        if (value == null) throw new IllegalStateException(field + " musi być określone");
    }

    private String assertNotBlank(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Nieprawidłowa wartość");
        } else {
            return value;
        }
    }
}
