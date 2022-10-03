package ru.vasiliev.demo.controlers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ru.vasiliev.demo.model.User;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ConsumeWebService {
    private final RestTemplate restTemplate;
    private final String url = "http://94.198.50.185:7081/api/users";

    @GetMapping("/")
    public String getProductList() {
        ResponseEntity<String> entity = restTemplate.getForEntity(url, String.class);
        String cookie = entity.getHeaders().get("Set-Cookie").get(0);

        User user = new User(3l,"James","Brown", (byte) 30);
        createNewUser(user, cookie);



        return entity.getBody();
    }

    public void createNewUser(User user, String cookie) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<User> entity = new HttpEntity<>(user, headers);
        String aaa = restTemplate.exchange(url, HttpMethod.POST, entity, String.class).getBody();
        int a=0;
    }
}


