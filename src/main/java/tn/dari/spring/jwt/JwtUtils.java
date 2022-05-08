package tn.dari.spring.jwt;


import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import tn.dari.spring.payload.response.JwtLogin;
import tn.dari.spring.payload.response.LoginResponse;
import tn.dari.spring.security.UserDetailsImpl;

@Component
@Slf4j
public class JwtUtils {
	private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

	@Value("${jwtSecret}")
	private String jwtSecret;

	@Value("${jwtExpirationMs}")
	private int jwtExpirationMs;
	@Autowired
    private AuthenticationManager authenticationManager;


	public String generateJwtToken(Authentication authentication) {

		UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();

		return Jwts.builder()
				.setSubject((userPrincipal.getUsername()))
				.setIssuedAt(new Date())
				.setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
				.signWith(SignatureAlgorithm.HS512, jwtSecret)
				.compact();
	}

	public String getUserNameFromJwtToken(String token) {
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
	}

	public boolean validateJwtToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
			return true;
		} catch (SignatureException e) {
			logger.error("Invalid JWT signature: {}", e.getMessage());
		} catch (MalformedJwtException e) {
			logger.error("Invalid JWT token: {}", e.getMessage());
		} catch (ExpiredJwtException e) {
			logger.error("JWT token is expired: {}", e.getMessage());
		} catch (UnsupportedJwtException e) {
			logger.error("JWT token is unsupported: {}", e.getMessage());
		} catch (IllegalArgumentException e) {
			logger.error("JWT claims string is empty: {}", e.getMessage());
		}

		return false;
	}
	 public LoginResponse login(JwtLogin jwtLogin) {
	        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtLogin.getUsername(),
	                jwtLogin.getPassword()));
	        SecurityContextHolder.getContext().setAuthentication(authenticate);
	        String token = generateJwtToken(authenticate);
	        log.info("token utils:"+token);
	        return new LoginResponse(jwtLogin.getUsername(),token);
	    }
	 

	    /**
	     * Returns the user id encapsulated within the token
	     */
	    public Long getUserIdFromJWT(String token) {
	        Claims claims = Jwts.parser()
	                .setSigningKey(jwtSecret)
	                .parseClaimsJws(token)
	                .getBody();

	        return Long.parseLong(claims.getSubject());
	    }

}
