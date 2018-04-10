package com.wyh.p2p.filter;

import com.wyh.p2p.entities.Customer;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class LoginFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		Customer customer = (Customer) session.getAttribute("customerUser");
		if (customer != null) {
			chain.doFilter(request, response);
		} else {
			String error = "您尚未登录,请登录!";
			session.setAttribute("error", error);
			request.getRequestDispatcher("/login.html").forward(request, response);
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
	}

}
