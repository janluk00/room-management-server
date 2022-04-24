package pl.jandom.roomanager.credentials;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Credentials {
    @Id
    @Column(name = "employee_login")
    private String employeeLogin;
    private String password;
    @Column(name = "is_admin")
    private Boolean isAdmin;
}
