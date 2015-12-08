package util;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

/**
 * Utilsowa klasa konfiguracyjna.
 *
 * @author Tomasz Śmiechowicz
 * @since 0.0.1-SNAPSHOT
 */
public class AppUtils {

	private static final Logger logger = Logger.getLogger(AppUtils.class);

	public static final String PHOTO_FOLDER_PATH = "/home/tsmiecho/Desktop/photos/";

	public static final String NAME = "name";

	public static final String MSISDN = "msisdn";

	public static final String MAIL = "mail";

	public static final String COMMENT = "comment";

	public static final String PHOTO_URL = "photoUrl";
	
	public static final String CITY = "city";
	
	public static final String STREET = "street";
	
	public static final String STREET_NUMBER = "streetNumber";
	
	public static final String FLAT_NUMBER = "flatNumber";
	
	public static void writeBundles() {
		ResourceBundle labels = ResourceBundle.getBundle("configuration", Locale.getDefault());
		Enumeration<String> bundleKeys = labels.getKeys();

		while (bundleKeys.hasMoreElements()) {
			String key = (String) bundleKeys.nextElement();
			String value = labels.getString(key);
			if (logger.isDebugEnabled()) {
				logger.debug("key = " + key + ", " + "value = " + value);
			}
		}
	}

	public static String getBundle(String key) {
		ResourceBundle labels = ResourceBundle.getBundle("configuration", Locale.getDefault());
		return labels.getString(key);
	}
}
