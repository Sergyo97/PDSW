package edu.eci.pdsw.DynamicWebIntroduction;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Writer;
import java.net.MalformedURLException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.eci.pdsw.DynamicWebIntroduction.models.Todo;

@WebServlet(
		urlPatterns = "/pdswServlet"
		)

public class PDSWServlet extends HttpServlet {

	private static final long serialVersionUID = 36L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Writer responseWriter = resp.getWriter();
		Optional<String> optId = Optional.ofNullable(req.getParameter("id"));
		String id = optId.isPresent() && !optId.get().isEmpty() ? optId.get() : "";

		try {
			Todo todo = Service.getTodo(Integer.parseInt(id));
			resp.setStatus(HttpServletResponse.SC_OK);
			responseWriter.write(todo.toString());
			responseWriter.flush();
		} catch (Exception e) {
			if (e.getClass().equals(FileNotFoundException.class)) {
				resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
				responseWriter.write("The given id was not found! Try again.");
				responseWriter.flush();
			} else if (e.getClass().equals(MalformedURLException.class)) {
				resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
				responseWriter.write("Internal server error.");
				responseWriter.flush();
			} else {
				resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				responseWriter.write("Bad request.");
				responseWriter.flush();
			}
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Writer responseWriter = resp.getWriter();
		Optional<String> optId = Optional.ofNullable(req.getParameter("id"));
		String id = optId.isPresent() && !optId.get().isEmpty() ? optId.get() : "";

		try {
			Todo todo = Service.getTodo(Integer.parseInt(id));
			resp.setStatus(HttpServletResponse.SC_OK);
			responseWriter.write(todo.toString());
			responseWriter.flush();
		} catch (Exception e) {
			if (e.getClass().equals(FileNotFoundException.class)) {
				resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
				responseWriter.write("The given id was not found! Try again.");
				responseWriter.flush();
			} else if (e.getClass().equals(MalformedURLException.class)) {
				resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
				responseWriter.write("Internal server error.");
				responseWriter.flush();
			} else {
				resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				responseWriter.write("Bad request.");
				responseWriter.flush();
			}
		}
	}
}
