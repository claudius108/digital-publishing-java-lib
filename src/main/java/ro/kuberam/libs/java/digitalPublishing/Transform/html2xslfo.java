package ro.kuberam.libs.java.digitalPublishing.Transform;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import be.re.css.CSSToXSLFO;
import be.re.css.CSSToXSLFOException;

public class html2xslfo {

	public static String run(InputStream inputNodeStream)
			throws FileNotFoundException, IOException, CSSToXSLFOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		CSSToXSLFO.convert(inputNodeStream, out);

		return out.toString();
	}
}
