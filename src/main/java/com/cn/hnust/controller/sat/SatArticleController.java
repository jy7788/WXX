package com.cn.hnust.controller.sat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.hnust.kit.kit.ExchangeCode2OpenId;
import com.cn.hnust.kit.kit.WeixinBasicKit;
import com.cn.hnust.kit.kit.WeixinUserUtil;
import com.cn.hnust.model.JsapiTicket;
import com.cn.hnust.model.WUser;
import com.cn.hnust.model.WeixinContext;
import com.cn.hnust.model.WeixinFinalValue;
import com.cn.hnust.model.sat.SatArticle;
import com.cn.hnust.model.sat.SatUser;
import com.cn.hnust.service.sat.ISatArticleService;
import com.cn.hnust.service.sat.ISatUserService;
import com.cn.hnust.util.JsonUtil;
import com.cn.hnust.util.ParamUtil;

@Controller
@RequestMapping("satarticle")
public class SatArticleController {
	
	@Autowired
	private ISatArticleService satArticleService;
	@Autowired
	private ISatUserService satUserService;
	
	@RequestMapping("/informationCenter")
	public String newsCenter() {
		return "sat/mobile/html/Information.jsp";
	}
	
	@RequestMapping("/gotoNewsList")
	public String gotoNewsList() {
		String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + WeixinFinalValue.APPID +"&redirect_uri=" + WeixinFinalValue.SERVER_URL + "satarticle/list&response_type=code&scope=snsapi_base&state=1#wechat_redirect";
		return "redirect:" + url;
	}
	
	/**
	 * 新闻中心列表
	 * @author fanfte
	 * @param model
	 * @return
	 * 2017年8月2日
	 */
	@RequestMapping("/list")
	public String listArticles(HttpServletRequest request, Model model) {
		List<SatArticle> list = satArticleService.list();
		String list2json = JsonUtil.getInstance().list2json(list);
		System.out.println(list2json);
		model.addAttribute("articleList", list);
		
		String code = request.getParameter("code");
		WUser wechatUser = null;
		if(code != null) {
			System.out.println("获取的code: "+ code);
	        String openid = ExchangeCode2OpenId.exchange(code);
	        if(openid != null) {
	        	System.out.println("网页授权获取到的openid: "+openid);
	        	wechatUser = WeixinUserUtil.getWechatUser(openid);
	        	model.addAttribute("openid", openid);
	        	
	        	if(openid != null && satUserService.loadByOpenId(openid) == null) {
	        		return "redirect:" + WeixinFinalValue.SERVER_URL + "satuser/gotoUserCenter";
	        	}
	        	
	        }else { 
	        	System.out.println("goto article list");
	        	return "redirect:" + WeixinFinalValue.SERVER_URL + "satarticle/gotoNewsList";
	        }
		}
		return "sat/mobile/html/Information.jsp";
	}
	
	/**
	 * 新闻中心详情
	 * @author fanfte
	 * @param id
	 * @param model
	 * @return
	 * 2017年8月2日
	 */
	@RequestMapping(value="/detail",method=RequestMethod.GET)
	public String satArticleDetail(@RequestParam("id") String id, @RequestParam("openid") String openid, HttpServletRequest request, Model model) {
		SatArticle satArticle = satArticleService.loadContentById(id);
		
		if(satArticle != null) {
			model.addAttribute("satArticle", satArticle);
		}
		if(openid != null) {
			SatUser satUser = satUserService.loadByOpenId(openid);
			model.addAttribute("satUser", satUser);
		}
		
		String appId=WeixinContext.getInstance().getAppId();//应用id  
        String appsecret=WeixinContext.getInstance().getAppSecurt();//应用秘钥  
       //1,获取access_token  
//       AccessToken accessToken = WeixinContext.getInstance().get;  
//       String access_token=accessToken.getAccess_token();  
       //2,获取调用微信jsapi的凭证  
       JsapiTicket ticket = WeixinContext.getInstance().getTicket(); 
       System.out.println("ticket " + ticket.getTicket());
       Map<String,String> map = WeixinBasicKit.sign(ticket.getTicket(), WeixinFinalValue.SERVER_URL + "satarticle/detail?id=" + id + "&openid=" + openid );  
      
	   request.setAttribute("timestamp", map.get("timestamp"));  
	   request.setAttribute("nonceStr", map.get("nonceStr"));  
	   request.setAttribute("signature", map.get("signature"));  
	   request.setAttribute("appId", appId);  
	      
	   System.out.println("apiticket " + ticket.getTicket() );
	   System.out.println("nonceStr " + map.get("nonceStr"));
	   System.out.println("timeStamp " + map.get("timestamp")); 
	   System.out.println("appId " + appId);
	   System.out.println("url " + map.get("url"));
	   System.out.println("signature " +  map.get("signature"));
		
		return "sat/mobile/html/InformationDetail.jsp";
	}
	
	/**
	 * 我发布的文章详情 
	 * @author fanfte
	 * @param id
	 * @param openid
	 * @param type
	 * @param model
	 * @return
	 * 2017年8月2日
	 */
	@RequestMapping(value="/myArticleDetail",method=RequestMethod.GET)
	public String satMyArticleDetail(@RequestParam("id") String id, @RequestParam("openid") String openid, Model model) {
		SatArticle satArticle = satArticleService.loadMyArticleContent(id, openid);
		SatUser satUser = satUserService.loadByOpenId(openid);
		if(satArticle != null) {
			model.addAttribute("satArticle", satArticle);
			model.addAttribute("satUser", satUser);
		}
		return "sat/mobile/html/InformationDetail.jsp";
	}
	/**
	 * 我的文章列表
	 * @author fanfte
	 * @param openid
	 * @param model
	 * @return
	 * 2017年8月2日
	 */
	@RequestMapping(value="/listMyArticles/{openid}",method=RequestMethod.GET)
	public String satArticleListMyArticles(@PathVariable String openid, Model model) {
		List<SatArticle> myArticles = satArticleService.listSatArticlesByOpenId(openid);
		if(myArticles != null) {
			model.addAttribute("myArticles", myArticles);
			model.addAttribute("openid", openid);
		}
		return "sat/mobile/html/articleList.jsp";
	}
	
	@RequestMapping("/gotoArticleSelfCreate")
	public String gotoArticleSelfCreate() {
		return "sat/mobile/html/articleEdit.jsp";
	}
	
	@RequestMapping("/gotoArticleReproduce")
	public String gotoArticleReproduce() {
		return "sat/mobile/html/articleEdit.jsp";
	}
	
	@RequestMapping(value="/updateUserShareCount", method=RequestMethod.POST)
	@ResponseBody
	public String updateShareCount(@RequestParam("articleId") String articleId, @RequestParam("openid") String openid) {
//		System.out.println(map.size());
		System.out.println(articleId + "   " +openid);
		Map<String,Object> map = new HashMap<>();
		map.put("articleId", articleId);
		map.put("openid", openid);
		String jsondata = ParamUtil.getJSONString(1, map);
		System.out.println("jsonData " + jsondata);
		String result = WeixinBasicKit.sendJsonPost(WeixinFinalValue.SERVER_URL + "satarticle/getDataJson", jsondata.toString());
		System.out.println(result);
		return "share success";
	}
	
	@RequestMapping(value="/getDataJson", method=RequestMethod.POST)
	@ResponseBody
	public String getDataJson(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("getDataJson successc");
		Map<String,Object> map = new HashMap<>();
		map.put("param1", "a");
		map.put("param2", "b");
		map.put("param3", "c");
		String result = ParamUtil.getJSONString(map);
		System.out.println(result);
		return result;
	}
	
	@RequestMapping(value="/getArticlesByCategory", method = RequestMethod.POST)
	@ResponseBody
	public String getMoreDetail() {
		List<SatArticle> articleList = satArticleService.list();
		String string = JsonUtil.getInstance().list2json(articleList);
		System.out.println("articles vvv " + string);
		return string;
	}
	@RequestMapping(value="/statistics", method = RequestMethod.GET)
	public String getStatistics() {
		return "sat/mobile/html/shujutongji.jsp";
	}
	
	
	/**
	 * 根据类别名称查出文章列表
	 * @param classifyName 类别名字
	 */
	@RequestMapping(value="/listArticlesByClassifyName", method=RequestMethod.POST)
	@ResponseBody
	public String listArticlesByClassifyName(@RequestParam("classifyName") String classifyName) {
//		System.out.println(map.size());
		System.out.println(classifyName );
		List<SatArticle> list = satArticleService.listByClassifyName(classifyName);
		return JsonUtil.getInstance().list2json(list);
	}
}
