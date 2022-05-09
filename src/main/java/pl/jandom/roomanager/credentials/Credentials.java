package pl.jandom.roomanager.credentials;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Credentials {
    @Id
    @Column(name = "employee_id")
    private Long employeeId;
    @Column(name = "employee_login")
    private String employeeLogin;
    private String password;
    @Column(name = "is_admin")
    private Boolean isAdmin;

    public Credentials(String employeeLogin, String password, Boolean isAdmin) {
        this.employeeLogin = employeeLogin;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public Credentials(String employeeLogin, String password) {
        this.employeeLogin = employeeLogin;
        this.password = password;
    }
}
