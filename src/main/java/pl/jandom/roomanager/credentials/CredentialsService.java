package pl.jandom.roomanager.credentials;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CredentialsService {

    @Autowired
    CredentialsRepository credentialsRepository;

    public List<Credentials> findAllCredentials() {
        return credentialsRepository.findAll();
    }
}
