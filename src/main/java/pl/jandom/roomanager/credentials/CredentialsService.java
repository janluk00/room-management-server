package pl.jandom.roomanager.credentials;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.jandom.roomanager.employee.Employee;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static pl.jandom.roomanager.employee.EmployeeService.EMPLOYEE_LOGIN_NOT_FOUND;
import static pl.jandom.roomanager.employee.EmployeeService.EMPLOYEE_LOGIN_TAKEN;

@Service
public class CredentialsService {

    @Autowired
    CredentialsRepository credentialsRepository;

    public List<Credentials> findAllCredentials() {
        return credentialsRepository.findAll();
    }

    public void addNewCredentials(Credentials newCredentials){
        Credentials credentialsTestLogin = credentialsRepository
                .findCredentialsByEmployeeLogin(newCredentials.getEmployeeLogin());

        if (credentialsTestLogin != null){
            throw new IllegalStateException(EMPLOYEE_LOGIN_TAKEN);
        }

        credentialsRepository.save(newCredentials);
    }

    public Credentials findCredentialsByLogin(String login){
        Credentials credentials = credentialsRepository
               .findCredentialsByEmployeeLogin(login);

        if(credentials == null){
           throw new IllegalStateException(
                    String.format(EMPLOYEE_LOGIN_NOT_FOUND, login));
        }

        return credentialsRepository.findCredentialsByEmployeeLogin(login);
    }

    @Transactional
    public void updatePassword(String login, String password){
        Credentials credentials = credentialsRepository.findCredentialsByEmployeeLogin(login);

        if(credentials == null) {
            throw new IllegalStateException(String.format(EMPLOYEE_LOGIN_NOT_FOUND, login));
        }

        else if(password != null && password.length() > 0 &&
        !password.equals(credentials.getPassword())){
            credentials.setPassword(password);
        }
    }

    @Transactional
    public void removeCredentials(String login){
        Credentials credentials = credentialsRepository.findCredentialsByEmployeeLogin(login);

        if(credentials == null) {
            System.out.println(String.format(EMPLOYEE_LOGIN_NOT_FOUND, login));
        }

        credentialsRepository.deleteByEmployeeLogin(login);
    }

    public Boolean checkCorrectnessOfCredentials(String login, String password) {
        Credentials credentials = credentialsRepository.findCredentialsByEmployeeLogin(login);
        if(credentials == null){
            return false;
        }
        boolean isCorrectPassword = password.equals(credentials.getPassword());

        if(isCorrectPassword){
            return true;
        }

        return false;
    }
}
