package auto.cc.info.domain.user;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true,nullable = false)
    private String userName;
    private String password;
    private String role;
    private  String email;
}
