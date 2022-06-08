package pl.jandom.roomanager.server;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/server")
public class ServerInfo {

    @GetMapping("/isActive")
    public Boolean isServerActive(){
        return true;
    }
}
