package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.factory.SearchJdbc;
import com.factory.UpdateJdbc;
import service.OperationsEnp;
import service.SearchEnp;

/**
 * Servlet implementation class HomeSvt
 */
@WebServlet("/HomeSvt")
public class HomeSvt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @throws IOException
	 * @throws ServletException
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String value = " ";
		value = request.getParameter("button");
		SearchJdbc searchJdbc = new SearchJdbc();

		if (value.equals("search")) {

			try {
				SearchEnp searchEnp = new SearchEnp();
				searchEnp.setFirstName(request.getParameter("firstname"));
				searchEnp.setLastName(request.getParameter("lastname"));
				ArrayList<OperationsEnp> operationsEnp = searchJdbc.single(searchEnp);
				RequestDispatcher rd = request.getRequestDispatcher("Search.jsp");
				request.setAttribute("serach", operationsEnp);
				rd.forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String value = request.getParameter("button");
		SearchJdbc searchJdbc = new SearchJdbc();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		if (value.equals("search")) {

			try {
				SearchEnp searchEnp = new SearchEnp();
				searchEnp.setFirstName(request.getParameter("firstname"));
				searchEnp.setLastName(request.getParameter("lastname"));
				searchJdbc.single(searchEnp);
				RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
				rd.forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (value.equals("update")) {
			UpdateJdbc updateJdbc = new UpdateJdbc();
			OperationsEnp operationsEnp = new OperationsEnp();
			operationsEnp.setFirstName(request.getParameter("firstname"));
			operationsEnp.setLastName(request.getParameter("lastname"));
			operationsEnp.setAddress(request.getParameter("address"));
			operationsEnp.setCity(request.getParameter("city"));
			operationsEnp.setZip(request.getParameter("zip"));
			operationsEnp.setState(request.getParameter("state"));
			operationsEnp.setCountry(request.getParameter("Country"));
			operationsEnp.setPhone(request.getParameter("phone"));
			operationsEnp.setPratyid(request.getParameter("partyid"));

			try {

				if (updateJdbc.update(operationsEnp)) {
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Record Update Successfully');");
					out.println("location='Home.jsp';");
					out.println("</script>");

				} else {
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Please try again');");
					out.println("location='Update.jsp';");
					out.println("</script>");

				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}
}
