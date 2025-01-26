package auto.cc.info.domain.user;

import auto.cc.info.domain.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class User extends BaseEntity {

    @Column(unique=true,nullable = false)
    private String userName;
    private String password;
    private String role;
    private  String email;
}
