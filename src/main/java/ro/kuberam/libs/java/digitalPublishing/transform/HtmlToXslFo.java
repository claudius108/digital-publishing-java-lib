package ro.kuberam.libs.java.digitalPublishing.transform;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import be.re.css.CSSToXSLFO;
import be.re.css.CSSToXSLFOException;

public class HtmlToXslFo {

	public byte[] run(byte[] inputDocument) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		try {
			CSSToXSLFO.convert(new ByteArrayInputStream(inputDocument), baos);
		} catch (IOException | CSSToXSLFOException e) {
			e.printStackTrace();
		}

		return baos.toByteArray();
	}
}
