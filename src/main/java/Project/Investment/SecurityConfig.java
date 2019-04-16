package Project.Investment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import Project.Investment.webcontroller.UserDetailServiceImpl;


@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private UserDetailServiceImpl userDetailsService;

	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .authorizeRequests()
        .antMatchers("/css/**")
        .permitAll() 
        .and()
        
        //poista tämä testien jälkeen
        .authorizeRequests()
        .antMatchers("/commentlist")
        .permitAll() 
        .and()
        
        
        //autorisointi
        .authorizeRequests()
        .antMatchers("/userlist", "/deleteuser/{id}", "/View/{id}", "/delete/{id}", "/removemetal/{id}", "/logout")
        .hasAuthority("ADMIN")
        .and()
        
        .authorizeRequests()
        .antMatchers("/editmetal/{id}", "/newmetal", "/savemetal", "/logout")
        .hasAuthority("USER")
        .and()
        
        
        .authorizeRequests()
        .antMatchers("/signup", "/saveuser", "/commentlist?language=us", "/commentlist?language=fr", "/commentlist?language=fi", "/commentlist?language=ru", "/commentlist", "/addcommentreply/{id}", "/comment/{id}/replies")
        .permitAll()
        .and()
        
        
        .authorizeRequests()
        .anyRequest()
        .authenticated()
        .and()
        
        
      .formLogin()
          .loginPage("/login")
          .defaultSuccessUrl("/commentlist")
          .permitAll()
          .and()
      .logout()
          .permitAll()
          .and()
        
        
        //-->sallii h2-console näkymän
        .authorizeRequests()
        .antMatchers("/h2-console/**")
        .permitAll()
        .and()
        
        //-->sallii h2-console näkymän
        .csrf()
        .disable()
        .headers()
        .frameOptions()
        .disable();
    }
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
  }
}

