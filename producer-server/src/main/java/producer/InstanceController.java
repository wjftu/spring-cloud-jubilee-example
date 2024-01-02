package producer;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InstanceController {


    @Autowired
    DiscoveryClient discoveryClient;
    @RequestMapping("/getInstance")
    public List<ServiceInstance> getInstances() {
        List<ServiceInstance> list = discoveryClient.getInstances("PRODUCER-SERVER");
        return list;
    }
}
