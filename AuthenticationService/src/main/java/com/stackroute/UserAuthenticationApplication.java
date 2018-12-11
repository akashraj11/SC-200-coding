package com.stackroute;

import com.stackroute.config.JwtFilter;
import com.stackroute.domain.User;
import com.stackroute.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories()
@SpringBootApplication
public class UserAuthenticationApplication implements CommandLineRunner {

    @Bean
    public FilterRegistrationBean jwtFilter() {
        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new JwtFilter());
        registrationBean.addUrlPatterns("/secure/*");

        return registrationBean;
    }
	public static void main(String[] args) {
		SpringApplication.run(UserAuthenticationApplication.class, args);
	}
    @Autowired
    private UserRepository userRepository;
    @Override
    public void run(String... args) throws Exception {
        String username ="deepu@gmail.com";
        String p1="12345678";
//        BCryptPasswordEncoder bCryptPasswordEncoder =new BCryptPasswordEncoder();
//           String encodedPassword = bCryptPasswordEncoder.encode(p1);

        User user  = new User();
        user.setPassword(p1);
        user.setUsername(username);
        userRepository.save(user);

    }
}
