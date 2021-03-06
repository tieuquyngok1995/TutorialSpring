package spring.boot.restfulcrud.service;

import java.util.Collections;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/*Lớp TokenAuthenticationService là một lớp tiện ích, nó ghi "Authorization string" (Chuỗi ủy quyền) vào Response Header để trả về cho Client. 
 * Chuỗi ủy quyền này có tác dụng trong một khoảng thời gian (10 ngày). 
 * Điều này có nghĩa là Client chỉ cần login một lần, và có được "Chuỗi ủy quyền" và có thể sử dụng nó trong khoảng thời gian nói trên. 
 * Khi "Chuỗi ủy quyền" hết hạn sử dụng, Client phải login lại để có được chuỗi ủy quyền mới.*/
public class TokenAuthenticationService {
	
	static final long EXPIRATIONTIME = 864_000_000; // 10 days
    
    static final String SECRET = "ThisIsASecret";
     
    static final String TOKEN_PREFIX = "Bearer";
     
    static final String HEADER_STRING = "Authorization";
	

	public static void addAuthentication(HttpServletResponse response, String userName) {
		String JWT = Jwts.builder().setSubject(userName)
				.setExpiration(new Date(System.currentTimeMillis()+EXPIRATIONTIME))
				.signWith(SignatureAlgorithm.HS512, SECRET).compact();
		response.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + JWT);
	}
	
	public static Authentication getAuthentication(HttpServletRequest request) {
		String token = request.getHeader(HEADER_STRING);
		if (token != null) {
			String user = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token.replace(TOKEN_PREFIX, "")).getBody().getSubject();
			
			return user != null ? new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList()) : null;
		}
		return null;
	}

}
