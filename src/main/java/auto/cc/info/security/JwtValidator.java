package auto.cc.info.security;

import auto.cc.info.commands.UserCommand;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;
import java.util.function.Function;

import java.util.Date;

@Component
public class JwtValidator {
    private String secret = "$2a$10$EWk4NyP6rnCeeuMKNogTgO0lU43BQT/XjS.dLVcMwO0JBfQ75zqiW";
    String secretKey= "Freedom is slavery";

    public UserCommand validate(String token){
        UserCommand jwtUser = null;
        try {
            AESEncryptionDecryption aesEncryptionDecryption = new AESEncryptionDecryption();
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        if(!isTokenExpired(token)){
            String decryptedString = aesEncryptionDecryption.decrypt(body.getSubject(), secretKey);
            jwtUser = new UserCommand();
            jwtUser.setUserName(decryptedString);
            jwtUser.setPassword((String) body.get("password"));
            jwtUser.setRole((String) body.get("role"));
            System.out.println("ROLE:" + jwtUser.getRole());
         }
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return jwtUser;
    }
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    private Claims extractAllClaims(String token) {
        return  Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();

    }
    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

}
