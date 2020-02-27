package mx.com.vrm.viai.configuration;

import static mx.com.vrm.viai.configuration.constantes.Constants.HEADER_AUTHORIZACION_KEY;
import static mx.com.vrm.viai.configuration.constantes.Constants.SUPER_SECRET_KEY;
import static mx.com.vrm.viai.configuration.constantes.Constants.TOKEN_BEARER_PREFIX;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import io.jsonwebtoken.Jwts;

// TODO: Auto-generated Javadoc
/**
 * The Class JWTAuthorizationFilter.
 */
public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

	/**
	 * Instantiates a new JWT authorization filter.
	 *
	 * @param authManager
	 *            the auth manager
	 */
	public JWTAuthorizationFilter(AuthenticationManager authManager) {
		super(authManager);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.web.authentication.www.
	 * BasicAuthenticationFilter#doFilterInternal(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse,
	 * javax.servlet.FilterChain)
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		String header = req.getHeader(HEADER_AUTHORIZACION_KEY);
		if (header == null || !header.startsWith(TOKEN_BEARER_PREFIX)) {
			chain.doFilter(req, res);
			return;
		}
		UsernamePasswordAuthenticationToken authentication = getAuthentication(req);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		chain.doFilter(req, res);
	}

	/**
	 * Gets the authentication.
	 *
	 * @param request
	 *            the request
	 * @return the authentication
	 */
	private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
		String token = request.getHeader(HEADER_AUTHORIZACION_KEY);
		if (token != null) {
			String user = Jwts.parser().setSigningKey(SUPER_SECRET_KEY)
					.parseClaimsJws(token.replace(TOKEN_BEARER_PREFIX, "")).getBody().getSubject();

			if (user != null) {
				return new UsernamePasswordAuthenticationToken(user, null, new ArrayList());
			}
			return null;
		}
		return null;
	}
}
