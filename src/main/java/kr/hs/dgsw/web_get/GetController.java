package kr.hs.dgsw.web_get;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class GetController {
    private String makeGreet(String say, String to) {
        return say + " " + to + "!";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/greeting")
    public String greeting(
            @RequestParam(value = "say", defaultValue = "Hello", required = false) String say,
            @RequestParam(value = "to", defaultValue = "world", required = false) String to
    ) {
        return makeGreet(say, to);
    }
    
    @RequestMapping(method = RequestMethod.GET, value = {"greeting1", "/greeting1/{say}", "/greeting1/{say}/{to}"})
    public String greeting1(
            @PathVariable Optional<String> say,
            @PathVariable Optional<String> to
    ) {
        String realSay = say.orElse("Hello");
        String realTo = to.orElse("world");
        return makeGreet(realSay, realTo);
    }
}
