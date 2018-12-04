package ro.kuberam.libs.java.digitalPublishing.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamToByteArray {
	
	public static byte[] run(InputStream input) {
		ByteArrayOutputStream os = null;
		
		try {
			os = new ByteArrayOutputStream();

			byte[] buffer = new byte[1024];
			int len;

			while ((len = input.read(buffer)) != -1) {
				os.write(buffer, 0, len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return os.toByteArray();

		// solution in java 9
		// try (InputStream in = url.openStream()) {
		// return new String(in.readAllBytes(), StandardCharsets.UTF_8);
		// }
	}

}
