package spring.boot.restfulcrud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import spring.boot.restfulcrud.filter.JWTAuthenticationFilter;
import spring.boot.restfulcrud.filter.JWTLoginFilter;

/*Ứng dụng này có chức năng đăng nhập, Client có thể gửi yêu cầu đăng nhập với phương thức POST. 
 * Vì vậy không cần thiết tạo ra một trang đăng nhập. Thay vào đó chúng ta có một Filter (bộ lọc), khi một request với đường dẫn /login, nó sẽ được Filter này xử lý.
 * Các request muốn đi tới Controller, chúng phải vượt qua các Filter (bộ lọc)*/

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter  {

	/* Bảo mật RESTful API với Basic Authentication (Xác thực cơ bản).
	@Autowired
	private AuthenticationEntryPoint authEntryPoint;
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		// CSRF (cross site request forgery)
		// laf ky thuat tan cong bang cach su dung quyen chung thuc cua ng dung doi voi 1 website
		http.csrf().disable();
		
		// Tất cả các request gửi tới Web Server yêu cầu phải được xác thực
        // (authenticated).
        http.authorizeRequests().anyRequest().authenticated();
 
        // Sử dụng AuthenticationEntryPoint để xác thực user/password
        http.httpBasic().authenticationEntryPoint(authEntryPoint);
	}*/
	
	/* Bảo mật RESTful API với JWT (JSON Web Token). */
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		// CSRF (cross site request forgery)
		// la ky thuat tan cong bang cach su dung quyen chung thuc cua ng dung doi voi 1 website
		http.csrf().disable().authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers(HttpMethod.POST, "/login").permitAll()
		.antMatchers(HttpMethod.GET, "/login").permitAll()
		.anyRequest().authenticated()
		.and()
		//
        // Add Filter 1 - JWTLoginFilter
        //
        .addFilterBefore(new JWTLoginFilter("/login", authenticationManager()),
                UsernamePasswordAuthenticationFilter.class)
        //
        // Add Filter 2 - JWTAuthenticationFilter
        //
        .addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
	}
	
	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }
	
	 @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	         
	        String password = "123";
	 
	        String encrytedPassword = this.passwordEncoder().encode(password);
	        System.out.println("Encoded password of 123=" + encrytedPassword);
	         
	         
	        InMemoryUserDetailsManagerConfigurer<AuthenticationManagerBuilder> //
	        mngConfig = auth.inMemoryAuthentication();
	 
	        // Định nghĩa 2 người dùng, lưu trữ trong bộ nhớ.
	        // ** Spring BOOT >= 2.x (Spring Security 5.x)
	        // Spring auto add ROLE_
	        UserDetails u1 = User.withUsername("tom").password(encrytedPassword).roles("USER").build();
	        UserDetails u2 = User.withUsername("jerry").password(encrytedPassword).roles("USER").build();
	 
	        mngConfig.withUser(u1);
	        mngConfig.withUser(u2);
	    }
}
