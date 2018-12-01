package ro.kuberam.libs.java.digitalPublishing.Transform;

import org.junit.Test;

import ro.kuberam.libs.java.digitalPublishing.transform.Operation;

public class HtmlToXslFoTest {

	@Test
	public void test() {
		String inputFormat = "html";
		String outputFormat = "xsl-fo";
		
		String result = null;
		result = Operation.run(this.getClass().getResourceAsStream("invoice.xhtml"), inputFormat, outputFormat);
		
		System.out.println(result);
	}

}
