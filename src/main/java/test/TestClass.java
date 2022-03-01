package test;

import org.cssudii.klog.KLog;
import org.cssudii.klog.Logger;
import org.jetbrains.annotations.NotNull;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class TestClass {
    private static final KLog LOGGER = new KLog();
    private static final CustomLogger CUSTOM_LOGGER = new CustomLogger(
            "https://discord.com/api/webhooks/{hidden_id}/{hidden_token}"
    );

    public TestClass() {
        LOGGER.getLoggers().put("webhook", new TestLogger());
        LOGGER
                .info("info")
                .warn("warn")
                .debug("debug")
                .error("error")
                .printNl(1);

        CUSTOM_LOGGER
                .webhook("test");

    }

    public static void main(String[] args) {
        new TestClass();
    }
}

class CustomLogger extends KLog {
    private static String webhookURL;

    public CustomLogger(String webhookURL_) {
        super();
        webhookURL = webhookURL_;
    }

    public static String getWebhookURL() {
        return webhookURL;
    }

    public CustomLogger webhook(String input) {
        Objects.requireNonNull(getLoggerById("webhook")).log(this, input);
        return this;
    }
}


class TestLogger extends Logger {
    private Webhook webhook = new Webhook();

    @Override
    public void log(@NotNull KLog klog, @NotNull String input) {
        try {
            webhook.send(input, CustomLogger.getWebhookURL());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isDefault() {
        return false;
    }
}

class Webhook {
    public void send(String message, String webUrl) throws IOException {
        URL url = new URL(webUrl);
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.addRequestProperty("Content-Type", "application/json");
        connection.addRequestProperty("User-Agent", "Webhook-Test-Class");
        connection.setDoOutput(true);
        connection.setRequestMethod("POST");

        JSONObject json = new JSONObject();
        json.put("content", message);

        OutputStream stream = connection.getOutputStream();
        stream.write(json.toString().getBytes());
        stream.flush();
        stream.close();

        connection.getInputStream().close();
        connection.disconnect();
    }
}

class JSONObject {

    private final HashMap<String, Object> map = new HashMap<>();

    void put(String key, Object value) {
        if (value != null) {
            map.put(key, value);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Set<Map.Entry<String, Object>> entrySet = map.entrySet();
        builder.append("{");

        int i = 0;
        for (Map.Entry<String, Object> entry : entrySet) {
            Object val = entry.getValue();
            builder.append(quote(entry.getKey())).append(":");

            if (val instanceof String) {
                builder.append(quote(String.valueOf(val)));
            } else if (val instanceof Integer) {
                builder.append(Integer.valueOf(String.valueOf(val)));
            } else if (val instanceof Boolean) {
                builder.append(val);
            } else if (val instanceof JSONObject) {
                builder.append(val.toString());
            } else if (val.getClass().isArray()) {
                builder.append("[");
                int len = Array.getLength(val);
                for (int j = 0; j < len; j++) {
                    builder.append(Array.get(val, j).toString()).append(j != len - 1 ? "," : "");
                }
                builder.append("]");
            }

            builder.append(++i == entrySet.size() ? "}" : ",");
        }

        return builder.toString();
    }

    private String quote(String string) {
        return "\"" + string + "\"";
    }
}