package fr.gcm.session.authentication;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author ML11181N
 *
 */
@WebFilter(filterName = "AuthFilter", urlPatterns = "/pages/*" )
public class AuthFilter implements Filter {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(AuthFilter.class);

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		try {
			HttpServletRequest req = (HttpServletRequest) request;
			HttpServletResponse res = (HttpServletResponse) response;
			HttpSession ses = req.getSession(false);

			String reqURI = req.getRequestURI();

			if (reqURI.indexOf("/login.jsf") >= 0
					|| (ses != null && ses.getAttribute("login") != null)) {

				chain.doFilter(request, response);

			} else {
				res.sendRedirect(req.getContextPath() + "/pages/login.jsf");
			}
		} catch (Throwable e) {
			LOGGER.error("Erreur lors de l'authentification", e);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}
}
