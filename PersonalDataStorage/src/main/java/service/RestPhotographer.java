package service;

import java.awt.Dimension;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamUtils;
import com.github.sarxos.webcam.util.ImageUtils;


/**
 * Serwis restowy odpowiedzialny za zrobienie i zapisanie zdjęcia.
 *
 * @author Tomasz Śmiechowicz
 * @since 0.0.1-SNAPSHOT
 */
@Path("/photo")
public class RestPhotographer {
	
	private static final Logger logger = Logger.getLogger(RestPhotographer.class);
	
	private static final String PHOTO_FOLDER_PATH = "/home/tsmiecho/Desktop/photos/";
	
	@GET
	@Path("/{param}")
	public Response takePhoto(@PathParam("param") String name) {
		
		Webcam webcam = Webcam.getDefault();

		if (webcam == null) {
			logger.error("No webcam detected");
			return Response.status(2).build();
		}
		
		if(logger.isDebugEnabled()){
			logger.debug("Webcam: " + webcam.getName());
		}
		
		webcam.setViewSize(new Dimension(640, 480));
		webcam.open();
 		WebcamUtils.capture(webcam, PHOTO_FOLDER_PATH + name, ImageUtils.FORMAT_BMP);
 		webcam.close();
 
		return Response.status(200).build();
 
	}

}
