package hello;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {
    private final FirstClient client1;
    private final FirstClient client2;

    public HelloController() {
        client1 = new FirstClient(8980);
        client2 = new FirstClient(50051);
    }
    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/block1")
    public FeMessage block1(@RequestParam(value="counter", defaultValue="1") int counter,
                            @RequestParam(value="phrase", defaultValue="hello world") String phrase) {

        return new FeMessage(client1.getCombine(counter, phrase));
    }

    @RequestMapping("/block2")
    public FeMessage block2(@RequestParam(value="counter", defaultValue="1") int counter,
                            @RequestParam(value="phrase", defaultValue="hello world") String phrase) {

        return new FeMessage(client2.getCombine(counter, phrase));
    }
}
