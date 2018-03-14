import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class GifTest {

	public static void main(String[] args) {

//		readFile("/Users/leeco/Documents/workspace/file/600X174.gif", "static gif => ");
		readFile("file/600X174.gif", "static gif => ");
		readFile("file/hesui.gif", " gif => ");
		
	}
	  // Reads next 16-bit value, LSB first
    public static int readShort(InputStream in) throws Exception {
        final int a = in.read();
        if (a == -1)
            throw new Exception("111");
        final int b = in.read();
        if (b == -1)
            throw new Exception("222");
        return a | (b << 8);
    }
    
    public static void readFile(String path,String tag){
    	 try {
    			File f1 = new File(path);
    			if (f1.exists()) {
    				InputStream is = new BufferedInputStream(new FileInputStream(f1), 32768);
    				// file header
    		        String id = "";
    		        for (int i = 0; i < 6; i++)
    		            id += (char) is.read();
    		        if (!id.startsWith("GIF")){
    			        System.out.println(tag+" not gif");
    		        }else{
    			        System.out.println(tag+" is gif");
    		        }
    		    
    		        System.out.println(tag+" id :"+id);
    				int   width = readShort(is);
    				int   height = readShort(is);
    				System.out.println(tag+" w :"+width+" , h :"+height);
    			}
    			} catch (Exception e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    		     
    		
    }
}
