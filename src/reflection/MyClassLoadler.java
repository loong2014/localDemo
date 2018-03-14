package reflection;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class MyClassLoadler extends ClassLoader {

	// name : com.sunny.LocalInfo
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		byte[] classData = getLoacalClassData(name);
		Class<?> clazz = null;
		if (classData != null) {
			clazz = defineClass(name, classData, 0, classData.length);

		} else {
			clazz = super.findClass(name);
		}

		return clazz;
	}

	// name : com.sunny.LocalInfo
	private byte[] getLoacalClassData(String name) {
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			// 这里我直接引用类在本地的路径，实际操作中需要将name转换成本地文件路径
			String filePath = "file/LocalInfo.class";
			File file = new File(filePath);
			InputStream is = new FileInputStream(file);
			int bufferSize = 1024;
			byte[] buffer = new byte[bufferSize];
			int len = 0;
			while ((len = is.read(buffer)) != -1) {
				baos.write(buffer, 0, len);
			}
			return baos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
