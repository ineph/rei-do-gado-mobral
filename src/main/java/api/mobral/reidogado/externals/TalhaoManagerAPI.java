package api.mobral.reidogado.externals;

import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TalhaoManagerAPI {

//    private final RestTemplate restTemplate;
//
//    public TalhaoManagerAPI(RestTemplate restTemplate){
//        this.restTemplate = restTemplate;
//    }

    public void postNovoTalhao(String body) {
        //TODO: adicionar variavel de ambiente:
        String url = "http://localhost:8080/cadastro";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(body, headers);

        String res = restTemplate.postForObject(url, entity, String.class);
    }
}
