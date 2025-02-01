package auto.cc.info.security;

import auto.cc.info.dto.UserDTO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import java.util.Date;
@Component
public class JwtGenerator {
    public String generate(UserDTO userDTO){
//        Date date = new Date();
//        date.setHours(date.getHours()+2);
        String secretKey= "Freedom is slavery";
        AESEncryptionDecryption aesEncryptionDecryption = new AESEncryptionDecryption();
        String userName = aesEncryptionDecryption.encrypt(userDTO.userName(), secretKey);
        String password = aesEncryptionDecryption.encrypt(userDTO.password(), secretKey);

        Claims claims = Jwts.claims()
                .setSubject(userName);
        claims.put("password",password);
        claims.put("role","ROLE_"+userDTO.role());
        return Jwts.builder().setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30))
                .signWith(SignatureAlgorithm.HS512,"$2a$10$EWk4NyP6rnCeeuMKNogTgO0lU43BQT/XjS.dLVcMwO0JBfQ75zqiW")
                .compact();
    }
//    private Key getSignKey() {
//        byte[] keyBytes= Decoders.BASE64.decode(SECRET);
//        return Keys.hmacShaKeyFor(keyBytes);
//    }



}
