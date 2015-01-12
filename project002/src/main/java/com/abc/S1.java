package com.abc;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class S1
 */
public class S1 extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public S1()
	{
		// TODO Auto-generated constructor stub 
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");

		String action = request.getParameter("action");
		if ("login_input".equals(action))
		{
			// request.getRequestDispatcher("login.jsp")
			// .forward(request, response);

			response.sendRedirect("login.jsp");
		}
		else if ("login".equals(action))
		{
			for (int k = 0; k < 1000; k++)
			{
				String name = request.getParameter("name");
				String password = request.getParameter("password");

				//System.out.println("name->" + name + ",password->" + password);

				response.getWriter().println(name + "^^^^^^" + password);
				response.getWriter().println("<br/><br/>");

				Cookie[] cks = request.getCookies();

				if (cks == null)
				{
					Cookie c = new Cookie("cookie111", "ck001_" + Math.random());
					response.addCookie(c);
				}
				else
				{
					for (int i = 0; i < cks.length; i++)
					{
						response.getWriter().println(
								cks[i].getName() + ": " + cks[i].getValue());

						cks[i].setMaxAge(2);

						response.getWriter().println("<br/>");
					}
				}

				response.getWriter().println("<br/><br/>");
				HttpSession sn = request.getSession(true);
				response.getWriter().println(sn.getId());
				response.getWriter().println("<br/>");
				response.getWriter()
						.println(new Date(sn.getLastAccessedTime()));
				response.getWriter().println("<br/>");
				response.getWriter().println(
						"From Cookie? "
								+ request.isRequestedSessionIdFromCookie());
				response.getWriter().println("<br/>");
				response.getWriter().println(
						"From URL? " + request.isRequestedSessionIdFromURL());

				response.getWriter().println(
						"<a href=" + response.encodeURL("S1?action=login")
								+ ">refresh</a>");

				response.getWriter().println("<br/><br/>");

				ServletContext sc = this.getServletContext();
				Object obj = sc.getAttribute("times");

				if (obj == null)
				{
					sc.setAttribute("times", 0);
				}
				else
				{
					int n = Integer.valueOf(obj.toString());
					n++;
					sc.setAttribute("times", n);
				}

				response.getWriter().println(
						"Visit times: " + sc.getAttribute("times"));

			}
		}
		else
		{
			System.out.println("else");
			response.getWriter().println(Math.random());
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
