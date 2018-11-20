package ro.kuberam.libs.java.digitalPublishing.Transform;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Operation {
	private static String packageName = Operation.class.getPackage().getName() + ".";

	public static String run(InputStream data, String inputFormat, String outputFormat) {
		String result = null;
		String transformation = Formats.getJavaCode(inputFormat) + "_TO_" + Formats.getJavaCode(outputFormat);

		try {
			Object transformationClass = Class.forName(packageName + transformation).newInstance();
			Method transformationClassMethod = transformationClass.getClass().getMethod("run", InputStream.class);

			result = (String) transformationClassMethod.invoke(transformationClass, data);
			System.out.println("result = " + result);

			// case "HTML_TO_XSLFO":
			//
			//
			// result = (String) transformationClass.getDeclaredMethod("run",
			// InputStream.class)
			// .invoke(data);
			// default:
			// throw new
			// DigitalPublishingException(DigitalPublishingError.TRANSFORMATION_FORMULA);
			// }
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException | ClassNotFoundException | InstantiationException e) {
			e.printStackTrace();
		}

		return result;
	}

}
