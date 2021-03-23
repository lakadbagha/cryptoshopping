package crypto.blockchain.shopviacrypto.utility;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;



public class BitcoinRate {

	private static String sendGetPrice() throws Exception {

//		URL obj = new URL("https://www.zebapi.com/api/v1/market/ticker/btc/inr");
//		URL obj = new URL("https://www.unocoin.com/trade?sell");
		URL obj = new URL("https://api.unocoin.com/api/trades/sell");

		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		// add request header
		con.setRequestProperty("User-Agent",
				"Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");

//		int responseCode = con.getResponseCode();
//		System.out.println(responseCode);
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		 return (response.substring(response.indexOf("selling_price")+16,response.indexOf("}")-1));
		
	}

	public static Double GetBitcoinRate() {
		Double sellPrice;
		try {
//			String cost = sendGetPrice().substring(sendGetPrice().indexOf("sell") + 7, sendGetPrice().indexOf(",") - 1);
			String cost = sendGetPrice();
			Float costPrice = Float.parseFloat(cost);
			System.out.println(costPrice);
			Float discount = 1f;
			DecimalFormat df = new DecimalFormat("#.##");
			sellPrice = Double.valueOf(df.format(costPrice - (costPrice * discount / 100)));
			
			System.out.println(sellPrice);
			return (sellPrice);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
