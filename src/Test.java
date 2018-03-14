import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Test {
	public static void test(File file) throws Exception {
		if (file.exists()) {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = br.readLine();
			String[] lineList = line.split(" ");
			int lineLen = lineList.length;
			StringBuilder[] outList = new StringBuilder[lineLen];
			enterNewStr(lineList, outList, lineLen);

			while ((line = br.readLine()) != null) {
				lineList = line.split(" ");
				enterNewStr(lineList, outList, lineLen);
			}

		}
	}

	public static void enterNewStr(String[] lineList, StringBuilder[] outList, int size) {
		for (int i = 0; i < size; i++) {
			outList[i].append(lineList[i]);
		}
	}

	public static void buildNewFile(StringBuilder[] outList) {
		StringBuilder newFile = new StringBuilder();
		for (StringBuilder sb : outList) {
			newFile.append(outList[0]);
		}
	}

	public static void main(String[] args) {
		File file = new File("");
		try {
			test(file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}