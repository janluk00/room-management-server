package pl.jandom.roomanager.credentials;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CredentialsService {

    @Autowired
    CredentialsRepository credentialsRepository;

    public List<Credentials> findAllCredentials() {
        return credentialsRepository.findAll();
    }

    public void addNewCredentials(Credentials newCredentials){
        Optional<Credentials> credentialsTestLogin = credentialsRepository
                .findCredentialsByEmployeeLogin(newCredentials.getEmployeeLogin());

        if (credentialsTestLogin.isPresent()){
            throw new IllegalStateException("Ten login jest juz zajety!");
        }

        credentialsRepository.save(newCredentials);
    }

    public Optional<Credentials> findCredentialsByLogin(String login){
        Optional<Credentials> optionalCredentials = credentialsRepository
                .findCredentialsByEmployeeLogin(login);

        if(optionalCredentials.isEmpty()){
            throw new IllegalStateException(
                    "Uzytkownik o loginie " + login + " nie zostal znaleziony" );
        }

        return credentialsRepository.findCredentialsByEmployeeLogin(login);
    }

    @Transactional
    public void updatePassword(String login, String password){
        Credentials credentials = credentialsRepository.findCredentialsByEmployeeLogin(login)
                .orElseThrow(() -> new IllegalStateException(
                        "Uzytkownik o loginie: " + login + " nie istenieje"));

        if(password != null && password.length() > 0 &&
        !password.equals(credentials.getPassword())){
            credentials.setPassword(password);
        }
    }

    @Transactional
    public void removeCredentials(String login){
        Credentials credentials = credentialsRepository.findCredentialsByEmployeeLogin(login)
                .orElseThrow(() -> new IllegalStateException(
                        "Uzytkownik o loginie: " + login + " nie znajduje sie w bazie danych!"
                ));

        credentialsRepository.deleteByEmployeeLogin(login);
    }


}
