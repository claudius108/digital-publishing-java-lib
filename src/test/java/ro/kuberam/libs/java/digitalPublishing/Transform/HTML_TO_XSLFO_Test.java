package ro.kuberam.libs.java.digitalPublishing.Transform;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.junit.Test;

public class HTML_TO_XSLFO_Test {

	@Test
	public void test() {
		String inputFormat = "html";
		String outputFormat = "xsl-fo";
		
		String result = null;
		result = Operation.run(this.getClass().getResourceAsStream("invoice.xhtml"), inputFormat, outputFormat);
		
		System.out.println(result);
	}

}
