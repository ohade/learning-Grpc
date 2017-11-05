package hello;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {
    private final SecondClient client;

    public HelloController() {
        client = new SecondClient(8980);
    }

    @RequestMapping("/simple_server_stream")
    public void sstream(@RequestParam(value="counter", defaultValue="1") int counter,
                         @RequestParam(value="phrase", defaultValue="hello world") String phrase) {

        client.getCombineServerStream(counter, phrase);
    }
}
