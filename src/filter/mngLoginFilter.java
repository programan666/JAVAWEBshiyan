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

/**
 * Servlet Filter implementation class mngLoginFilter
 */
public class mngLoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public mngLoginFilter() {
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
		System.out.println("mngLoginFilter----------");
		HttpSession session = req.getSession();
		Mng mng = (Mng)session.getAttribute("loginMng");
		if(mng == null)
			reqs.sendRedirect("login.jsp");
		else
			chain.doFilter(req, reqs);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("---------mngLogin Filter--------");
	}

}
