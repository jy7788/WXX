package com.cn.hnust.htmlparser;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class HtmlParser {
	
	public static String parseHTML(String url) {
		Document doc = null;
		try {
			doc = Jsoup.connect(url).get();
			Elements imgs = doc.getElementsByTag("img");
			Elements attribute = doc.getElementsByAttributeValueContaining("style", "display:none;");
			if(attribute != null && attribute.size() > 0) {
				attribute.remove();
			}
			if(imgs != null && imgs.size() > 0) {
				for(int i = 0; i < imgs.size() ;i++) {
					if(!imgs.get(i).hasAttr("src") && imgs.get(i).hasAttr("data-src")) {
						String attr = imgs.get(i).attr("data-src");
						imgs.get(i).removeAttr("data-src");
						imgs.get(i).attr("src", attr);
					}
				}
			}
			doc.getElementsByTag("script").remove();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return doc + "";
	} 
}
