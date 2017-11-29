package filter;

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

import mng.pojo.Mng;
import rol.pojo.Rol;

/**
 * Servlet Filter implementation class roleLoginFilter
 */
public class roleLoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public roleLoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse reqs = (HttpServletResponse)response;
		System.out.println("roleLoginFilter----------");
		HttpSession session = req.getSession();
		Rol rol = (Rol)session.getAttribute("rolInfo");
		if(rol == null)
			reqs.sendRedirect("login.jsp");
		else
			chain.doFilter(req, reqs);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("---------roleLogin Filter--------");
	}

}
