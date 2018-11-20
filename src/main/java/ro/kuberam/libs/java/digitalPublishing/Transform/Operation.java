package ro.kuberam.libs.java.digitalPublishing.Transform;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

import ro.kuberam.libs.java.digitalPublishing.DigitalPublishingError;
import ro.kuberam.libs.java.digitalPublishing.DigitalPublishingException;

public class Operation {

	public String run(InputStream data, String inputFormat, String outputFormat) {
		String result = null;
		String transformation = inputFormat + "-to-" + outputFormat;

		try {
			switch (transformation) {
			case "html-to-xsl-fo":
				result = (String) Class.forName("html2xslfo").getConstructor(InputStream.class).newInstance(data);
			default:
				throw new DigitalPublishingException(DigitalPublishingError.TRANSFORMATION_FORMULA);
			}
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException | DigitalPublishingException e) {
			e.printStackTrace();
		}

		return result;
	}

}
