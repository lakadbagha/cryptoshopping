package crypto.blockchain.shopviacrypto.utility;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class ReceiveBTC {

	private String sendGet(String secretKey, Long invoiceId, String publicKey, String apiKey) throws Exception {

		String secret = secretKey;
		String xpub = publicKey;
		String callBackURL = "https://mystore.com?invoice_id=" + invoiceId + "&secret=" + secret;
		String rootURL = "https://api.blockchain.info/v2/receive";
		String parameter = "xpub=" + xpub + "&callback=" + URLEncoder.encode(callBackURL, "UTF-8") + "&key=" + apiKey;
		URL obj = new URL(rootURL + "?" + parameter);

		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		// add request header
		// con.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS
		// X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");

		// int responseCode = con.getResponseCode();
		// System.out.println(responseCode);
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		return (response.toString());
	}

	public String receiveBTCAddress(String secretKey, Long invoiceId, String publicKey, String apiKey) {
		try {
			String address = sendGet(secretKey, invoiceId, publicKey, apiKey);
			System.out.println(address);
			return address.substring(address.indexOf("address") + 12, address.indexOf(",") - 1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
