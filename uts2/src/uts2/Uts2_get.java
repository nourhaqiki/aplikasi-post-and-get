/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts2;

/**
 *
 * @author nour haqiki
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL; 
import org.json.JSONObject;
public class Uts2_get {
	public static void main(String[] args) {
     try {
         Uts2_get.call_me();
        } catch (Exception e) {
         e.printStackTrace();
       }
     }
	   
public static void call_me() throws Exception {
     String url = "https://httpbin.org/ip";
     String urlParameters = "name = nour haqiki & npm = 06.2017.1.06769";
     URL obj = new URL(url);
     HttpURLConnection con = (HttpURLConnection) obj.openConnection();
     // optional default is GET
     con.setRequestMethod("GET");
     //add request header
     con.setRequestProperty("User-Agent", "Mozilla/5.0");
     int responseCode = con.getResponseCode();
     System.out.println("\nSending 'GET' request to URL : " + url);
     System.out.println("Response Code : " + responseCode);
     BufferedReader in = new BufferedReader(
             new InputStreamReader(con.getInputStream()));
     String inputLine;
     StringBuffer response = new StringBuffer();
     while ((inputLine = in.readLine()) != null) {
     	response.append(inputLine);
     }
     in.close();
     //print in String
     InetAddress[] addr = InetAddress.getAllByName("httpbin.org");
     System.out.println(response.toString());
     //Read JSON response and print
     JSONObject myResponse = new JSONObject(response.toString());
     System.out.println("result after Reading JSON Response");
     System.out.println("origin ip- "+myResponse.getString("origin"));
     for (InetAddress address : addr)
            { System.out.println("Domain : " + address.getHostName());
     System.out.println("ip : " + address.getHostAddress());}
    
   }
}