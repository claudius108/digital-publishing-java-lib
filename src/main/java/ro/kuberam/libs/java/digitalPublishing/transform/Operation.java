package ro.kuberam.libs.java.digitalPublishing.transform;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Operation {
	private static Logger LOG = LogManager.getLogger(Operation.class);
	private static String packageName = Operation.class.getPackage().getName() + ".";

	public static String run(InputStream data, String transformationFormula) {
		String result = null;

		try {
			String javaTransformationFormula = Formats.convertToJavaTransformationFormula(transformationFormula);
			Object transformationClass = Class.forName(packageName + javaTransformationFormula).newInstance();
			Method transformationClassMethod = transformationClass.getClass().getMethod("run", InputStream.class);

			String transformationResult = (String) transformationClassMethod.invoke(transformationClass, data);
			LOG.debug("transformationResult = {}", () -> transformationResult);

			result = transformationResult;
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException | ClassNotFoundException | InstantiationException e) {
			e.printStackTrace();
		}

		return result;
	}	

}
