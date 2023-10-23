package api.mobral.reidogado.externals;

import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpHeaders;
import java.net.http.HttpResponse;

public class TalhaoManagerAPI {

    private final RestTemplate restTemplate;
//    private final String body;

    public TalhaoManagerAPI(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
//        this.body = body;
    }

    public void postNovoTalhao(String body) {
        //TODO: adicionar variavel de ambiente:
        String url = "http://localhost:8080";
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(body);
        String res = restTemplate.postForObject(url, entity, String.class);
        System.out.println(res);
    }
}
