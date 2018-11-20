package ro.kuberam.libs.java.digitalPublishing.Transform;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import be.re.css.CSSToXSLFO;
import be.re.css.CSSToXSLFOException;

public class HtmlToXslFo {

	public String run(InputStream inputNodeStream) {
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {
			CSSToXSLFO.convert(inputNodeStream, out);
		} catch (IOException | CSSToXSLFOException e) {
			e.printStackTrace();
		}

		return out.toString();
	}
}
