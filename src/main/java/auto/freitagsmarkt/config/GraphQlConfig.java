package auto.cc.info.config;

import auto.cc.info.dto.UserCommand;
import auto.cc.info.security.JwtGenerator;
import graphql.scalars.ExtendedScalars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

@Configuration
public class GraphQlConfig {
    @Autowired
    private JwtGenerator jwtGenerator;

    @Bean
    public RuntimeWiringConfigurer runtimeWiringConfigurer() {
        return wiringBuilder -> wiringBuilder.scalar(ExtendedScalars.Json);
    }
    @Bean
    void generateGuestToken(){
        UserCommand userCommand = new UserCommand();
        userCommand.setUserName("AOT_TOA");
        userCommand.setPassword("TOA_TOA");
        userCommand.setRole("GUEST");
        String token = jwtGenerator.generate(userCommand);
        System.out.println("TOKEN: "+token);
    }

}
