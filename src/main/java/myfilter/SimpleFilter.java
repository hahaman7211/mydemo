package myfilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebFilter(filterName = "myFilter", urlPatterns = {"/homepage/gohomepage", "/homepage/dolist", 
		//"/homepage/showform", "/homepage/addcustomer" } )
@WebFilter(filterName = "myFilter", urlPatterns = {"/*"} )
public class SimpleFilter implements Filter{
	
	private ArrayList<String> urlList;

	@Override
	public void destroy() {
			
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		//System.out.println("Remote Host:"+request.getRemoteHost());
	    //System.out.println("Remote Address:"+request.getRemoteAddr());
		System.out.println("hello");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String url = req.getServletPath();
		boolean allowedRequest = false;
		
		if(urlList.contains(url)) {
			allowedRequest = true;
		}
		
		if (allowedRequest) {
			if(req.getSession().getAttribute("loginEmlp")==null) {
				res.sendRedirect(req.getContextPath());
				return;
			}
		}
	
	    //HttpSession session = req.getSession(false);
		//if (null == session) {
			//req.getRequestDispatcher("index.jsp").forward(request, response);
			 //req.getSession();
			//res.sendRedirect(req.getContextPath());
			//res.sendRedirect(req.getContextPath());
			//return;
		//}
		
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		String urls = "/homepage/gohomepage,/homepage/dolist,"
				+ "/homepage/showform,/homepage/addcustomer";
		
		StringTokenizer token = new StringTokenizer(urls, ",");

		urlList = new ArrayList<String>();

		while (token.hasMoreTokens()) {
			urlList.add(token.nextToken());
		}
		
		
	}

}
