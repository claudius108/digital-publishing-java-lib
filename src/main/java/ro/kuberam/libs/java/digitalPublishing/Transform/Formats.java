package ro.kuberam.libs.java.digitalPublishing.Transform;

import java.util.HashMap;
import java.util.Map;

public enum Formats {

	HTML("html", "HTML"), XSL_FO("xsl-fo", "XSLFO");

	private static final Map<String, Formats> FormatsMAP = new HashMap<String, Formats>();
	static {
		for (Formats format : values()) {
			FormatsMAP.put(format.getCode(), format);
		}
	}

	private String code;
	private String javaCode;

	private Formats(String code, String javaCode) {
		this.code = code;
		this.javaCode = javaCode;
	}

	private String getJavaCode() {
		return this.javaCode;
	}

	public String getCode() {
		return this.code;
	}

	public static String getJavaCode(String code) {
		return FormatsMAP.get(code).getJavaCode();
	}
}
