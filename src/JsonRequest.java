

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class JsonRequest 
{
    private final String urlStr;
    
    public JsonRequest() throws MalformedURLException, IOException
    {
	urlStr = "http://headers.jsontest.com/";
	//urlStr = "http://freegeoip.net/json/";
	URL url = new URL(urlStr);
	StringBuilder sb = new StringBuilder();
	Scanner in;
	in = new Scanner(System.in);
	
	HttpURLConnection conn = (HttpURLConnection)url.openConnection();
	conn.setRequestMethod("GET");
	conn.setRequestProperty("Accept", "application/json");
	if (conn.getResponseCode() != 200) 
	{
	    throw new RuntimeException("Failed : HTTP error code : "
		    + conn.getResponseCode());
	}
	
	BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

	String output;
	System.out.println("Output from Server .... \n");

	while ((output = br.readLine()) != null) 
	{
	    sb.append(output);
	    in.next();
	    System.out.println(sb.toString());
	}
	conn.disconnect();
    }
}
