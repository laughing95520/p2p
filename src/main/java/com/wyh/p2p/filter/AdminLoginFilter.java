package com.wyh.p2p.filter;

import com.wyh.p2p.entities.Admin;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class AdminLoginFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		Admin admin = (Admin) session.getAttribute("currnetUser");
		if (admin != null) {
			chain.doFilter(request, response);
		} else {
			/*String errorInfo = "您尚未登录,请登录!";
			session.setAttribute("errorInfo", errorInfo);*/
			request.getRequestDispatcher("/loginAdmin.jsp").forward(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
