package auto.freitagsmarkt.domain.user;

import auto.freitagsmarkt.domain.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User extends BaseEntity {

    @Column(unique=true,nullable = false)
    private String userName;
    private String password;
    private String role;
    private  String email;
}
