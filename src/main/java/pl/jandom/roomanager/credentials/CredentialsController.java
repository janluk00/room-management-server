package pl.jandom.roomanager.credentials;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/credentials") /* localhost:8080/credentials */
public class CredentialsController {

    private final CredentialsService credentialsService;

    @Autowired
    public CredentialsController(CredentialsService credentialsService) {
        this.credentialsService = credentialsService;
    }

    @GetMapping("/list")
    public List<Credentials> findAllCredentials(){
        return credentialsService.findAllCredentials();
    }

    @GetMapping("/{login}")
    public Credentials getEmployeeByLogin(@PathVariable("login") String login){
        return credentialsService.findCredentialsByLogin(login);
    }

    @GetMapping("/checkCredentials/{login}/{password}")
    public Boolean isCorrectLoginAndPassword(@PathVariable("login") String login, @PathVariable("password") String password){
        return credentialsService.checkCorrectnessOfCredentials(login, password);
    }

    @PostMapping("/add")
    public void registerNewUser(@RequestBody Credentials newCredentials){
        credentialsService.addNewCredentials(newCredentials);
    }

    @PutMapping("/editPassword/{login}")
    public void editCredentialsPasswordByLogin(@PathVariable("login") String login,
                                        @RequestParam(required = false) String password){
        credentialsService.updatePassword(login, password);
    }

    @DeleteMapping("/delete/{login}")
    public void removeCredentialsByLogin(@PathVariable("login") String login){
        credentialsService.removeCredentials(login);
    }
}
