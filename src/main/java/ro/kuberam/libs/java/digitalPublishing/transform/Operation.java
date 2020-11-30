package ro.kuberam.libs.java.digitalPublishing.transform;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Operation {
	private static Logger LOG = LogManager.getLogger(Operation.class);
	private static String packageName = Operation.class.getPackage().getName() + ".";

	public static byte[] run(byte[] inputDocument, String inputFormat, String outputFormat) {
		byte[] result = null;

		try {
			String javaTransformationFormula = Formats.getTransformationFormula(inputFormat, outputFormat);
			Object transformationClass = Class.forName(packageName + javaTransformationFormula).newInstance();
			Method transformationClassMethod = transformationClass.getClass().getMethod("run", byte[].class);

			byte[] transformationResult = (byte[]) transformationClassMethod.invoke(transformationClass, inputDocument);
			LOG.debug("transformationResult = {}", () -> new String(transformationResult, UTF_8));

			result = transformationResult;
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException | ClassNotFoundException | InstantiationException e) {
			e.printStackTrace();
		}

		return result;
	}

}
