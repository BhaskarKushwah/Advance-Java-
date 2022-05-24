package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.factory.DeleteJdbc;

import service.OperationsEnp;

/**
 * Servlet implementation class DeleteSvt
 */
@WebServlet("/DeleteSvt")
public class DeleteSvt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		response.getWriter().append("Served at: ").append(request.getContextPath());
		{
			boolean status;
			OperationsEnp operationsEnp = new OperationsEnp();
			operationsEnp.setPratyid(request.getParameter("id"));
			DeleteJdbc deleteJdbc = new DeleteJdbc();
			System.out.println(request.getParameter("id"));
			status = deleteJdbc.delete(operationsEnp);

			if (status) {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Record Deleted Successfully');");
				out.println("location='Home.jsp';");
				out.println("</script>");

			} else {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('please try again');");
				out.println("location='Home.jsp';");
				out.println("</script>");

			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

}
