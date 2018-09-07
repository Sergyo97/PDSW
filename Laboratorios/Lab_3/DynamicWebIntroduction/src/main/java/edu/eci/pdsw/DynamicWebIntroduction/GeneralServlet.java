package edu.eci.pdsw.DynamicWebIntroduction;

import java.io.IOException;
import java.io.Writer;
import java.net.MalformedURLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.eci.pdsw.DynamicWebIntroduction.models.Todo;

@WebServlet(
		urlPatterns = "/generalServlet"
		)

public class GeneralServlet extends HttpServlet{
	
	private static final long serialVersionUID = 37L;

	/*@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Writer responseWriter = resp.getWriter();
		try {
			List<Todo> todos = Service.getTodos();
			resp.setStatus(HttpServletResponse.SC_OK);
			responseWriter.write(Service.todosToHTMLTable(todos));
			responseWriter.flush();
		} catch (Exception e) {
			if (e.getClass().equals(MalformedURLException.class)) {
				resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
				responseWriter.write("Internal server error.");
				responseWriter.flush();
			} else {
				resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				responseWriter.write("Bad request.");
				responseWriter.write(e.getMessage());
				responseWriter.flush();
			}
		}
	}*/

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Writer responseWriter = resp.getWriter();
		try {
			List<Todo> todos = Service.getTodos();
			resp.setStatus(HttpServletResponse.SC_OK);
			resp.setContentType("text/html");
			responseWriter.write(Service.todosToHTMLTable(todos));
			responseWriter.flush();
		} catch (Exception e) {
			if (e.getClass().equals(MalformedURLException.class)) {
				resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
				responseWriter.write("Internal server error.");
				responseWriter.flush();
			} else {
				resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				responseWriter.write("Bad request.");
				responseWriter.write(e.getMessage());
				responseWriter.flush();
			}
		}
	}
	
}
