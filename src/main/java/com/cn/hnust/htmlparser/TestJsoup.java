package com.cn.hnust.htmlparser;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class TestJsoup {
	public static void main(String[] args) {
		/*Document doc;
		try {
			doc = Jsoup.connect("http://mp.weixin.qq.com/s/kiN0aOUaKlAL538OQbRKQg").get();
//			String title = doc.title();
			Elements imgs = doc.getElementsByTag("img");
			for(int i = 0; i < imgs.size() ;i++) {
				if(!imgs.get(i).hasAttr("src") && imgs.get(i).hasAttr("data-src")) {
					String attr = imgs.get(i).attr("data-src");
					imgs.get(i).removeAttr("data-src");
//				System.out.println(attr);
					imgs.get(i).attr("src", attr);
				}
			}
			doc.getElementsByTag("script").remove();
//			System.out.println(imgs.);
			System.out.println(doc);
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		String html = HtmlParser.parseHTML("https://mp.weixin.qq.com/s/ZWsqyuu1WOhu9XkZNQLinw");
		System.out.println(html);
	}
}
