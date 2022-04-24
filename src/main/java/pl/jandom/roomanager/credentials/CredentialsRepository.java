package pl.jandom.roomanager.credentials;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CredentialsRepository extends JpaRepository<Credentials, String> {
}
