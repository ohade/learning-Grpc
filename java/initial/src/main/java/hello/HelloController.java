package hello;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {
    private final FirstClient clientJava;
    private final FirstClient clientPython;

    public HelloController() {
        clientJava = new FirstClient(8980);
        clientPython = new FirstClient(50051);
    }
    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/block1")
    public FeMessage block1(@RequestParam(value="counter", defaultValue="1") int counter,
                            @RequestParam(value="phrase", defaultValue="hello world") String phrase) {

        return new FeMessage(clientJava.getCombine(counter, phrase));
    }

    @RequestMapping("/block2")
    public FeMessage block2(@RequestParam(value="counter", defaultValue="1") int counter,
                         @RequestParam(value="phrase", defaultValue="hello world") String phrase) {

        return new FeMessage(clientPython.getCombine(counter, phrase));
    }
}
