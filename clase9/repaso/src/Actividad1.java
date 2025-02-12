package clase9;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.TreeMap;

class Endpoints {
    static String timeSeries = "query?function=TIME_SERIES_DAILY";

    static String appendParameters(String endpoint, String[] parameters) {
        String response = endpoint;
        for (String parameter : parameters) {
            response += "&" + parameter;
        }
        return response;
    }
}

public class Actividad1 {
    static String apiUrl = "https://www.alphavantage.co/";
    static String apiKey = "KEY";

    public static void main(String[] args) {
        try {
            resolveTimeSeriesDial("IBM", 200);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void resolveTimeSeriesDial(String symbol, double amountToInvest) throws Exception {
        String[] parameters = {"symbol=" + symbol, "apikey=" + apiKey};
        StringBuilder result = new StringBuilder();
        URL url = new URL(apiUrl + Endpoints.appendParameters(Endpoints.timeSeries, parameters));

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(conn.getInputStream()))) {
            for (String line; (line = reader.readLine()) != null; ) {
                result.append(line);
            }
        }

        JsonObject response = parseResponse(result.toString());
        printSymbolData(response);

        JsonObject timeSeries = response.getAsJsonObject("Time Series (Daily)");

        double[] precios = new double[timeSeries.keySet().size()];

        int index = 0;
        String firstDay = timeSeries.keySet().toArray()[0].toString();
        double firstPrice = 1;

        for (String key : timeSeries.keySet()) {
            if (index == 0) {
                firstDay = key;
                firstPrice = timeSeries.getAsJsonObject(key).get("4. close").getAsDouble();
            }
            precios[index] = timeSeries.getAsJsonObject(key).get("4. close").getAsDouble();
            index++;
        }

        System.out.println(String.format("Si hubieras invertido $%s el %s habrias ganado $%s", amountToInvest, firstDay, maxProfit(precios.length, precios) * amountToInvest / firstPrice));
    }

    public static void printSymbolData(JsonObject data) {
        System.out.println(data.getAsJsonObject("Meta Data").get("1. Information").getAsString());
        System.out.println(data.getAsJsonObject("Time Series (Daily)"));
    }

    public static double maxProfit(int k, double[] prices) {
        // Verificar si la lista de precios es nula, está vacía o si no se permiten transacciones
        if (prices == null || prices.length == 0 || k == 0) {
            return 0;
        }

        int n = prices.length;

        // Si k es suficientemente grande, podemos hacer todas las transacciones posibles
        if (k >= n / 2) {
            double maxProfit = 0;
            for (int i = 1; i < n; i++) {
                // Acumulamos las ganancias de cada día si hay una subida en el precio
                maxProfit += Math.max(prices[i] - prices[i - 1], 0);
            }
            return maxProfit;
        }

        // Matriz DP donde dp[t][d] almacena la ganancia máxima con t transacciones hasta el día d
        double[][] dp = new double[k + 1][n];

        for (int t = 1; t <= k; t++) {
            double maxDiff = -prices[0]; // Máxima diferencia observada hasta ahora
            for (int d = 1; d < n; d++) {
                // Decidimos si mantenemos la ganancia del día anterior o vendemos en el día actual
                dp[t][d] = Math.max(dp[t][d - 1], prices[d] + maxDiff);
                // Actualizamos maxDiff para evaluar futuras compras
                maxDiff = Math.max(maxDiff, dp[t - 1][d] - prices[d]);
            }
        }

        return dp[k][n - 1]; // Retorna la ganancia máxima posible con k transacciones
    }

    public static JsonObject parseResponse(String response) {
        JsonParser parser = new JsonParser();
        return parser.parse(response).getAsJsonObject();
    }
}
 
