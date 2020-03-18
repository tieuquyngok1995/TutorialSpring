package spring.boot.restfulcrud.filter;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import spring.boot.restfulcrud.service.TokenAuthenticationService;

/*Khi một request với đường dẫn /login gửi đến Server, nó sẽ được xử lý bởi JWTLoginFilter, 
 * lớp này sẽ kiểm tra username/password, nếu hợp lệ, một chuỗi ủy quyền (Authorization string) sẽ được đính kèm vào Response Header trả về cho Client.*/

public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {

	public JWTLoginFilter(String url, AuthenticationManager authManager) {
		super(new AntPathRequestMatcher(url));
		setAuthenticationManager(authManager);
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		String userName = request.getParameter("username");
		String passWord = request.getParameter("password");
		
		System.out.printf("JWTLoginFilter.attemptAuthentication: username/password= %s,%s", userName, passWord);
        System.out.println();
        
		return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(userName, passWord, Collections.emptyList()));
	}
	
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) {
		System.out.println("JWTLoginFilter.successfulAuthentication:");
		 
        // Write Authorization to Headers of Response.
        TokenAuthenticationService.addAuthentication(response, authResult.getName());
 
        String authorizationString = response.getHeader("Authorization");
 
        System.out.println("Authorization String=" + authorizationString);
	}

}
