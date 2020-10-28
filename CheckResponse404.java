
package DescargarStatusCode;

import java.io.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.apache.http.HttpResponse;
import org.junit.Assert;
public class CheckResponse404 {

	public static void main(String[] args)throws ClientProtocolException, IOException {
		// TODO Auto-generated method stub
		String url = "https://cvfcpn.umsa.bo/my/3";
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(url);
		
		HttpResponse response =client.execute(request);
		int actualResponseCode = response.getStatusLine().getStatusCode();
		int expectedResponseCode = 404;
		
		Assert.assertEquals(expectedResponseCode, actualResponseCode);
		
		BufferedReader rd=new BufferedReader
				(new InputStreamReader( response.getEntity().getContent()));
		
		StringBuffer result = new StringBuffer();
		String line="";
		while((line=rd.readLine())!=null)
			result.append(line);
		
		System.out.println( "404 Not Found "+result);
		;
		
	}

}
