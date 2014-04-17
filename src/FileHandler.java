import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;


public class FileHandler {
	
	protected String LicenseName;
	protected File ProjectPath;
	final static Charset ENCODING = StandardCharsets.UTF_8;
	
	public FileHandler(String licenseName, File projectPath)
	{
		this.LicenseName = licenseName;
		this.ProjectPath = projectPath;
	}
	
	
	public void copyFile(File source, File dest) throws IOException { //http://www.javalobby.org/java/forums/t17036.html
		 if(!dest.exists())
			 dest.createNewFile();
		 
		 InputStream in = null;
		 OutputStream out = null;
		 try {
			 in = new FileInputStream(source);
			 out = new FileOutputStream(dest);
		    
			 // Transfer bytes from in to out
			 byte[] buf = new byte[1024];
			 int len;
			 while ((len = in.read(buf)) > 0) {
				 out.write(buf, 0, len);
			 }
		 }
		 finally {
			 if(in != null) 
				 in.close();
			 if(out != null) 
				 out.close();
		 }
	}	
	
	public void addLicenseToProject() throws IOException
	{
		File source = new File("LicensesForApplication\\" + this.LicenseName);
		String addLicenseToPath = ProjectPath.toString() + "\\LICENSE.";
		File dest = new File(addLicenseToPath);
		this.copyFile(source,dest);
	}	

}
