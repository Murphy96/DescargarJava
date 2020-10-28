package DescargarStatusCode;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Descarga {
	public static void main(String[] args) throws IOException {
        // Make sure that this directory exists
		URL url = new URL("http://www.titulosnauticos.net/trigonometria/Trigonometria.pdf");
        System.out.println("El protocolo utilizado es: " + url.getProtocol());
        System.out.println("El puerto utilizado es: "+url.getPort());
	    System.out.println("El host es: " + url.getHost());
	    System.out.println(url);
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "Your Robot Name");
        connection.connect();
        int code = connection.getResponseCode();
        int code1=connection.HTTP_VERSION;
        System.out.println("Version HTTP "+code1);
        System.out.println("Response code of the object is "+code);
        if (code==200)
        {
            System.out.println("ok");
        }
        else  {
        	System.out.println();
        	
        } 
         String dirName = "D:\\Auxiliaturas\\inf-273\\codigosAlum\\RamosGuitierrez";
         
        try {
            saveFileFromUrlWithJavaIO(
                dirName + "\\trigonometria.pdf", "http://www.titulosnauticos.net/trigonometria/Trigonometria.pdf");
            System.out.println("El archivo ah sido descargado satisfatoriamente");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
    // Using Java IO
    public static void saveFileFromUrlWithJavaIO(String fileName, String fileUrl)
    throws MalformedURLException, IOException {
        BufferedInputStream in = null;
        FileOutputStream fout = null;
        try { in = new BufferedInputStream(new URL(fileUrl).openStream());
            fout = new FileOutputStream(fileName);
            byte data[] = new byte[1024];
            int count;
            while ((count = in .read(data, 0, 1024)) != -1) {
                fout.write(data, 0, count);
            }
        } finally {
            if ( in != null)
                in .close();
            if (fout != null)
                fout.close();
        }
    }
    // Using Commons IO library
    // Available at http://commons.apache.org/io/download_io.cgi
    public static void saveFileFromUrlWithCommonsIO(String fileName,
        String fileUrl) throws MalformedURLException, IOException {
        //FileUtils.copyURLToFile(new URL(fileUrl), new File(fileName));
    }
}
