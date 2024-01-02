package consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerService {

    @Autowired
    RestTemplate restTemplate;

    @Value("${server.port}")
    int port;

    @RequestMapping("/consumer")
    public String service() {
//        String url = "http://127.0.0.1:8081/producer";
        String url = "http://producer-server/producer";
//        url = "http://172.20.10.9:8082/producer";
        String response = restTemplate.getForObject(url, String.class);
        return "comsumer of port " + port + ", " + response;
    }
}
