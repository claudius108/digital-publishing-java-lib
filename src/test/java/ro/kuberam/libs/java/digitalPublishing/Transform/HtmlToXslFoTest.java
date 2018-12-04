package ro.kuberam.libs.java.digitalPublishing.Transform;

import static java.nio.charset.StandardCharsets.UTF_8;

import org.junit.Test;

import ro.kuberam.libs.java.digitalPublishing.transform.Operation;
import ro.kuberam.libs.java.digitalPublishing.utils.InputStreamToByteArray;

public class HtmlToXslFoTest {

	@Test
	public void test() {
		String inputFormat = "html";
		String outputFormat = "xsl-fo";

		String result = new String(
				Operation.run(InputStreamToByteArray.run(this.getClass().getResourceAsStream("invoice.xhtml")),
						inputFormat, outputFormat),
				UTF_8);

		System.out.println(result);
	}

}
