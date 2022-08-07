package design.pattern.circuit;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpCall {

    public static void main(String args[]) throws URISyntaxException, IOException, InterruptedException {
        String url = "https://jsonplaceholder.typicode.com/todos/1";
        HttpRequest request =
                HttpRequest.newBuilder()
                        .uri(new URI(url))
                        .GET()
                        .build();
        HttpResponse<String> response = HttpClient.newBuilder().build().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}
