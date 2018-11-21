package ro.kuberam.libs.java.digitalPublishing.Transform;

import java.util.HashMap;
import java.util.Map;

import ro.kuberam.libs.java.digitalPublishing.DigitalPublishingError;
import ro.kuberam.libs.java.digitalPublishing.DigitalPublishingException;

public enum Formats {

	HTML("html", "Html"), XSL_FO("xsl-fo", "XslFo");

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

	public static String getTransformationFormula(String inputFormat, String outputFormat) {
		String transformationFormula = null;
		try {
			transformationFormula = Formats.getJavaCode(inputFormat) + "To" + Formats.getJavaCode(outputFormat);
		} catch (Exception e) {
			try {
				throw new DigitalPublishingException(DigitalPublishingError.TRANSFORMATION_FORMULA);
			} catch (DigitalPublishingException e1) {
				e1.printStackTrace();
			}
		}

		return transformationFormula;
	}
}
