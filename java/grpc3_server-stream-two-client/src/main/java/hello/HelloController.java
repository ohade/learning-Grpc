package hello;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {
    private final ThirdClient clientJava;

    public HelloController() {
        clientJava = new ThirdClient(8980);
    }


    @RequestMapping("/less_simple_server_stream")
    public void lsstream(@RequestParam(value="counter", defaultValue="1") int counter,
                         @RequestParam(value="phrase", defaultValue="hello world") String phrase) {
        clientJava.getCombineServerStreamLessSimple(counter, phrase);
    }
}
