package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.factory.ResgisterJdbc;
import com.factory.LoginJdbc;

import service.EmailSend;
import service.LoginEnp;
import service.RegisterEnp;

/**
 * Servlet implementation class Resgiter
 */
@WebServlet({ "/register", "/resgiter" })
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RegisterEnp registerEnp = new RegisterEnp();
		String value = request.getParameter("button");
		PrintWriter out = response.getWriter();
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		if (value.equals("sumbit")) {
			System.out.print(value);
			ResgisterJdbc doaParty = new ResgisterJdbc();
			registerEnp.setEmail(request.getParameter("email"));
			registerEnp.setPassword(request.getParameter("password"));
			registerEnp.setFirstName(request.getParameter("firstname"));
			registerEnp.setLastName(request.getParameter("lastname"));
			registerEnp.setAddress(request.getParameter("address"));
			registerEnp.setCity(request.getParameter("city"));
			registerEnp.setZip(request.getParameter("zip"));
			registerEnp.setState(request.getParameter("state"));
			registerEnp.setCountry(request.getParameter("country"));
			registerEnp.setPhone(request.getParameter("phone"));

			try {
				boolean status = false;
				status = doaParty.party(registerEnp);
				EmailSend emailSend = new EmailSend();

				if (status) {
					emailSend.details(registerEnp);
					response.sendRedirect("Home.jsp");
					/*
					 * RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
					 * rd.forward(request, response);
					 */
				} else {
					out.println("<script type=\"text/javascript\">");
					out.println("alert('please try argin');");
					out.println("location='register.jsp';");
					out.println("</script>");

					RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
					rd.forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block

				e.printStackTrace();
			}

		}
		if (value.equals("login")) {
			LoginJdbc loginJdbc = new LoginJdbc();
			boolean status;
			LoginEnp loginEnp = new LoginEnp();
			loginEnp.setEamil(request.getParameter("email"));
			loginEnp.setPassword(request.getParameter("password"));
			String email = request.getParameter("email");
			status = loginJdbc.login(loginEnp);
			if (status) {
				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("email", email);
				httpSession.setMaxInactiveInterval(300);
				RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
				rd.forward(request, response);

			} else {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('please try argin');");
				out.println("location='login.jsp';");
				out.println("</script>");
				request.setAttribute("status", status);
			}

		}

	}
}
