package ro.kuberam.libs.java.digitalPublishing.Transform;

public enum Formats {

	HTML("html"), XSL_FO("xsl-fo");

	private String code;

	Formats(String code) {
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}
}
