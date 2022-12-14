package com.example.miProyectoIntegradorV2.Security;

import com.example.miProyectoIntegradorV2.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConf extends WebSecurityConfigurerAdapter {
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(usuarioService);
        daoAuthenticationProvider.setPasswordEncoder(bCryptPasswordEncoder);
        return daoAuthenticationProvider;
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {

       http
               .csrf().disable()

               .authorizeRequests()
               .antMatchers("/indexUser.html").hasRole("USER")
               .and()
               .authorizeRequests()
               .antMatchers("/turnosListUser.html").hasRole("USER")
               .and()
               .authorizeRequests()
               .antMatchers("/turnosAddUser.html").hasRole("USER")
               .and()
               .authorizeRequests()
               .antMatchers("/index.html").hasRole("ADMIN")
               .and()
               .authorizeRequests()
               .antMatchers("/pacientesList.html").hasRole("ADMIN")
               .and()
               .authorizeRequests()
               .antMatchers("/pacientesAdd.html").hasRole("ADMIN")
               .and()
               .authorizeRequests()
               .antMatchers("/odontologosList.html").hasRole("ADMIN")
               .and()
               .authorizeRequests()
               .antMatchers("/odontologosAdd.html").hasRole("ADMIN")
               .and()
               .authorizeRequests()
               .antMatchers("/turnosList.html").hasRole("ADMIN")
               .and()
               .authorizeRequests()
               .antMatchers("/turnosAdd.html").hasRole("ADMIN")
               .and()
               .formLogin().and().logout();
    }

}


