package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import service.Controller;
import service.ControllerImpl;

/**
 * Główny serwlet aplikacji.
 *
 * @author Tomasz Śmiechowicz
 * @since 0.0.1-SNAPSHOT
 */
public class MainServlet extends HttpServlet {
	
	private static final Logger logger = Logger.getLogger(MainServlet.class);

	private static final long serialVersionUID = 2125688435340127736L;

	private Controller controller = new ControllerImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try{
			controller.createPerson(req);
		}catch(Exception e){
			logger.error(e.getMessage());
		}finally{
			req.getRequestDispatcher("/thanks").forward(req, resp);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
