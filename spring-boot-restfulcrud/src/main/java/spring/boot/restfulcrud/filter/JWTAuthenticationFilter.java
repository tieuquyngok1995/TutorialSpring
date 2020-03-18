package spring.boot.restfulcrud.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
 

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import spring.boot.restfulcrud.service.TokenAuthenticationService;

/*Để có thể gọi REST API, Các request sẽ được đính kèm "Authorization string" trên Request Header. 
 * Lớp JWTAuthenticationFilter sẽ kiểm tra "Authorization string", nếu hợp lệ request sẽ được xác thực, nó có thể tiếp tục đi đến Controller.*/
public class JWTAuthenticationFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("JWTAuthenticationFilter.doFilter");
        
        Authentication authentication = TokenAuthenticationService.getAuthentication((HttpServletRequest) request);
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        chain.doFilter(request, response);
	}

}
