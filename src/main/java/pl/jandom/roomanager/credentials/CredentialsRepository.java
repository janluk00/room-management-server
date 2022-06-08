package pl.jandom.roomanager.credentials;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CredentialsRepository extends JpaRepository<Credentials, String> {
    Credentials findCredentialsByEmployeeLogin(String employeeLogin);
    void deleteByEmployeeLogin(String login);
}
