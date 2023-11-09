package auto.cc.info.config;

import auto.cc.info.security.JwtAuthenticationEntryPoint;
import auto.cc.info.security.JwtAuthenticationProvider;
import auto.cc.info.security.JwtAuthenticationTokenFilter;
import auto.cc.info.security.JwtSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.session.HttpSessionEventPublisher;

@EnableWebSecurity
@EnableGlobalMethodSecurity(jsr250Enabled = true )
@Configuration
public class SpringSecConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private JwtAuthenticationProvider authenticationProvider;
    @Autowired
    private JwtAuthenticationEntryPoint entryPoint;
    @Bean
    public JwtAuthenticationTokenFilter authenticationTokenFilterGraphQl() throws Exception {
        JwtAuthenticationTokenFilter filter = new JwtAuthenticationTokenFilter("/graphql/**");
        filter.setAuthenticationManager(authenticationManager());
        filter.setAuthenticationSuccessHandler(new JwtSuccessHandler());
        return filter;
    }
    @Bean
    public JwtAuthenticationTokenFilter authenticationTokenFilterREST() throws Exception {
        JwtAuthenticationTokenFilter filter = new JwtAuthenticationTokenFilter("/api/**");
        filter.setAuthenticationManager(authenticationManager());
        filter.setAuthenticationSuccessHandler(new JwtSuccessHandler());
        return filter;
    }
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/graphql/**","/swagger-resources","/api/**")
                .permitAll()
                .and()
                .exceptionHandling().authenticationEntryPoint(entryPoint)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        httpSecurity.addFilterBefore(authenticationTokenFilterREST(),UsernamePasswordAuthenticationFilter.class);
        httpSecurity.addFilterBefore(authenticationTokenFilterGraphQl(), UsernamePasswordAuthenticationFilter.class);
        httpSecurity.headers().cacheControl();
    }
    @Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }
    @Bean
    public HttpSessionEventPublisher httpSessionEventPublisher() {
        return new HttpSessionEventPublisher();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
