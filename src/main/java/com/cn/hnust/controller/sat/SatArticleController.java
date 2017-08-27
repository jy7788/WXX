package com.cn.hnust.controller.sat;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
import com.cn.hnust.model.sat.SatAdvertisement;
import com.cn.hnust.model.sat.SatArticle;
import com.cn.hnust.model.sat.SatArticleShare;
import com.cn.hnust.model.sat.SatUser;
import com.cn.hnust.service.sat.ISatAdService;
import com.cn.hnust.service.sat.ISatArticleService;
import com.cn.hnust.service.sat.ISatArticleShareService;
import com.cn.hnust.service.sat.ISatUserService;
import com.cn.hnust.util.JsonUtil;
import com.cn.hnust.util.ParamUtil;

@Controller
@RequestMapping("satarticle")
public class SatArticleController {
	
	@Autowired
	private ISatArticleService satArticleService;
	@Autowired
	private ISatArticleShareService satArticleShareService;
	@Autowired
	private ISatUserService satUserService;
	
	@Autowired
	private ISatAdService satAdService;
	
	/**
	 * 进入新闻中心
	 * @author fanfte
	 * 
	 * @return
	 * 2017年8月25日
	 */
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
		} else { 
        	System.out.println("goto article list");
        	return "redirect:" + WeixinFinalValue.SERVER_URL + "satarticle/gotoNewsList";
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
		String visitorOpenid = request.getParameter("visitorOpenid");  
		String adId = request.getParameter("adId");
		String from = request.getParameter("from");
		System.out.println(openid + "adid " + adId + " visitorOpenid " + visitorOpenid);
		
		/*Map<String, String[]> parameterMap = request.getParameterMap();
		StringBuffer url = new StringBuffer();
		url.append(WeixinFinalValue.SERVER_URL + "satarticle/detail?");
		for (String key : parameterMap.keySet()) {
			url.append(key).append("=" + request.getParameter(key) +"&");
			//System.out.println("key= "+ key + " and value= " + parameterMap.get(key));
	    }
		String reqUrl = url.toString();
		reqUrl = reqUrl.substring(0, reqUrl.length() - 1);
		System.out.println(reqUrl);*/
		
		if(satArticle != null) {
			model.addAttribute("satArticle", satArticle);
		}
		//发文者的openid
		if(openid != null) {
			SatUser satUser = satUserService.loadByOpenId(openid);
			model.addAttribute("satUser", satUser);
		}
		if(!StringUtils.isEmpty(from) ) {//分享之后的文章
			model.addAttribute("auth", "aread");
			SatArticleShare articleShare = null;
			//更新文章查看次数
			if(!StringUtils.isEmpty(openid) && !StringUtils.isEmpty(id)) {
				articleShare = satArticleShareService.load(openid, id);
				if(articleShare != null) {
					articleShare.setWatches(articleShare.getWatches() + 1);
					articleShare.setUpdateTime(new Date());
					satArticleShareService.update(articleShare);
				}
			}
			//加载广告数据
			if(articleShare != null && articleShare.getAdvisId() != null) {
				System.out.println("adid " + articleShare.getAdvisId());
				SatAdvertisement ad = satAdService.load(articleShare.getAdvisId());//得到分享文章对应的广告
				model.addAttribute("ad", ad);
			}
			String appId=WeixinContext.getInstance().getAppId();//应用id  
	        String appsecret=WeixinContext.getInstance().getAppSecurt();//应用秘钥  
	       //1,获取access_token  
//	       AccessToken accessToken = WeixinContext.getInstance().get;  
//	       String access_token=accessToken.getAccess_token();  
	       //2,获取调用微信jsapi的凭证  
	       JsapiTicket ticket = WeixinContext.getInstance().getTicket(); 
	       System.out.println("ticket " + ticket.getTicket());
	       Map<String,String> map = WeixinBasicKit.sign(ticket.getTicket(), WeixinFinalValue.SERVER_URL + "satarticle/detail?id="
	    		   					+ id + "&openid=" + openid + "&from=" + from );  
	      
		   request.setAttribute("timestamp", map.get("timestamp"));  
		   request.setAttribute("nonceStr", map.get("nonceStr"));  
		   request.setAttribute("signature", map.get("signature"));  
		   request.setAttribute("appId", appId);  
		   System.out.println("signature " +  map.get("signature"));
			return "sat/mobile/html/ShareInformationDetail.jsp";
		} else {//原文章
			//更新原文章阅读次数
			satArticle.setWatches(satArticle.getWatches() + 1);
			satArticle.setUpdateTime(new Date());
			satArticleService.update(satArticle);
			model.addAttribute("auth", "aedit");
			String appId=WeixinContext.getInstance().getAppId();//应用id  
	        String appsecret=WeixinContext.getInstance().getAppSecurt();//应用秘钥  
	       //1,获取access_token  
	//       AccessToken accessToken = WeixinContext.getInstance().get;  
	//       String access_token=accessToken.getAccess_token();  
	       //2,获取调用微信jsapi的凭证  
	       JsapiTicket ticket = WeixinContext.getInstance().getTicket(); 
	       System.out.println("ticket " + ticket.getTicket());
	//       Map<String,String> map = WeixinBasicKit.sign(ticket.getTicket(), WeixinFinalValue.SERVER_URL + "satarticle/detail?id=" + id + "&openid=" + openid );
	       Map<String,String> map = WeixinBasicKit.sign(ticket.getTicket(), WeixinFinalValue.SERVER_URL + "satarticle/detail?id=" + id + "&openid=" + openid);  
	      
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
	}
	
	/**
	 * 新闻中心详情
	 * @author fanfte
	 * @param id
	 * @param model
	 * @return
	 * 2017年8月2日
	 */
	@RequestMapping(value="/readArticle",method=RequestMethod.GET)
	public String readArticle(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		String openid = request.getParameter("openid");
		String adId = request.getParameter("adId");
		String from = request.getParameter("from");
		SatAdvertisement ad = satAdService.load(adId);
		if(ad != null) {
			model.addAttribute("ad", ad);
		}
		if(!StringUtils.isEmpty(from)) {
			System.out.println("from " + from);
			return "redirect:" + WeixinFinalValue.SERVER_URL + "satarticle/readArticle?id=" + id + "&openid=" + openid + "&adId=" + adId;
		}
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
		
		return "sat/mobile/html/SharesInformationDetail.jsp";
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
		SatArticle satArticle = satArticleService.loadMyArticleContent(id);
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
		List<SatArticleShare> share = satArticleShareService.listByOpenid(openid);
		for(SatArticle a : myArticles) {
			for(SatArticleShare s: share) {
				if(a.getId().equals(s.getArticleId())) {
					a.setShares(s.getShares());
					a.setStars(s.getStars());
					a.setWatches(s.getWatches());
				}
			}
		}
		System.out.println("size" + myArticles.size());
		if(myArticles != null) {
			model.addAttribute("myArticles", myArticles);
			model.addAttribute("openid", openid);
		}
		return "sat/mobile/html/articleList.jsp";
	}
	
	/**
	 * 别人的微站
	 * @author fanfte
	 * @param openid
	 * @param model
	 * @return
	 * 2017年8月2日
	 */
	@RequestMapping(value="/othersStation",method=RequestMethod.GET)
	public String othersStation(@RequestParam String openid, Model model) {
		List<SatArticle> myArticles = satArticleService.listSatArticlesByOpenId(openid);
		List<SatArticleShare> share = satArticleShareService.listByOpenid(openid);
		for(SatArticle a : myArticles) {
			for(SatArticleShare s: share) {
				if(a.getId().equals(s.getArticleId())) {
					a.setShares(s.getShares());
					a.setStars(s.getStars());
					a.setWatches(s.getWatches());
				}
			}
		}
		System.out.println("size" + myArticles.size());
		if(myArticles != null) {
			model.addAttribute("myArticles", myArticles);
			model.addAttribute("openid", openid);
		}
		return "sat/mobile/html/othersList.jsp";
	}
	
	@RequestMapping("/gotoArticleSelfCreate")
	public String gotoArticleSelfCreate() {
		return "sat/mobile/html/articleEdit.jsp";
	}
	
	@RequestMapping("/gotoArticleReproduce")
	public String gotoArticleReproduce() {
		return "sat/mobile/html/articleEdit.jsp";
	}
	
	
	/**
	 * 更新分享次数
	 * @author fanfte
	 * 
	 * @param articleId
	 * @param openid
	 * @return
	 * 2017年8月25日
	 */
	@RequestMapping(value="/updateUserShareCount", method=RequestMethod.POST)
	@ResponseBody
	public String updateShareCount(HttpServletRequest request) {
		String articleId = request.getParameter("articleId");
		String openid = request.getParameter("openid");
		String adId = request.getParameter("adId");
		System.out.println(articleId + "  " + openid + " " + adId);
		if(!StringUtils.isEmpty(articleId) && !StringUtils.isEmpty(openid)
				) {
			SatArticle satArticle = satArticleService.loadArticleById(articleId);
			if(satArticle != null) {//更新原文章分享次数
				satArticle.setShares(satArticle.getShares() + 1);
				satArticle.setUpdateTime(new Date());
				satArticleService.update(satArticle);
			}
			SatArticleShare share = satArticleShareService.load(openid, articleId);
			
			if(share != null) {//分享过更新分享次数t_sat_article
				if(StringUtils.isNoneEmpty(adId)) {
					share.setAdvisId(adId);
				}
				share.setShares(share.getShares() + 1);
				share.setUpdateTime(new Date());
				satArticleShareService.update(share);
			} else {//没有分享过新增文章分享记录  在文章分享表t_sat_article_share
				SatArticleShare shareArticle = new SatArticleShare();
				shareArticle.setId(UUID.randomUUID().toString());
				shareArticle.setArticleId(articleId);
				shareArticle.setAdvisId(adId);
				shareArticle.setCreateTime(new Date());
				shareArticle.setUpdateTime(new Date());
				shareArticle.setUserId(openid);
				satArticleShareService.insert(shareArticle);
			}
			return "share success";
		}
		return "share failed";
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

	@RequestMapping(value="/statistics", method = RequestMethod.GET)
	public String getStatistics(HttpServletRequest request, Model model) {
		String openid = request.getParameter("openid");
		System.out.println("oepnid "+ openid); 
		if(StringUtils.isNoneEmpty(openid)) {
			System.out.println("oepnid "+ openid); 
			SatUser user = satUserService.loadByOpenId(openid);
			model.addAttribute("openid", openid);
			if(user != null ) {
				return "sat/mobile/html/shujutongji.jsp";
			} else {
				return "sat/mobile/html/shujutongji.jsp";
			}
		} else {
			return "sat/mobile/html/shujutongji.jsp";
		}
	}
	
	
	/**
	 * 根据类别名称查出文章列表
	 * @param classifyName 类别名字
	 * @return 文章Json数据
	 */
	@RequestMapping(value="/listArticlesByClassifyName", method=RequestMethod.POST)
	@ResponseBody
	public String listArticlesByClassifyName(@RequestParam("classifyName") String classifyName) {
		List<SatArticle> list = null;
		System.out.println(classifyName );
		if(classifyName.equals("本周头条")) {
			list = satArticleService.list();
		} else {
			list = satArticleService.listByClassifyName(classifyName);
			System.out.println(list.size());
		}
		return JsonUtil.getInstance().list2json(list);
	}
	
	@RequestMapping(value="/getLike", method=RequestMethod.POST)
	@ResponseBody
	public String listArticlesLike(@RequestParam("title") String title) {
		List<SatArticle> list = satArticleService.listSatArticleLike(title);
		if(list != null && list.size() !=0){
			System.out.println(JsonUtil.getInstance().list2json(list));
			return JsonUtil.getInstance().list2json(list);
		} else {
			return "get failed";
		}
	}
	/**
	 * 收藏文章
	 */
	@RequestMapping(value="/collectArticle", method=RequestMethod.POST)
	@ResponseBody
	public String collectArticle(HttpServletRequest request) {
		String articleId = request.getParameter("articleId");
		String openid = request.getParameter("openid");
		System.out.println("openid " + openid + "aid " + articleId);
		if(!StringUtils.isEmpty(articleId) && !StringUtils.isEmpty(openid)) {
			List<SatArticle> list = satArticleService.listArticleCollections(openid, articleId);
			System.out.println("size " + list.size());
			if(list != null && list.size() > 0){
				return "already collected";
			} else {
				satArticleService.collectArticle(openid, articleId);
				return "collect success";
			}
		}
		return "collect failed";
	}
	
	/**
	 * 得到收藏列表
	 */
	@RequestMapping(value="/listMyCollections", method=RequestMethod.POST)
	@ResponseBody
	public String listMyCollections(HttpServletRequest request) {
		String openid = request.getParameter("openid");
		if(!StringUtils.isEmpty(openid)) {
			List<SatArticle> list = satArticleService.listMyCollections(openid);
			System.out.println("list coll " + list.size());
			if(list != null && list.size() > 0){
				String result = JsonUtil.getInstance().list2json(list);
				return result;
			} else {
				return "list failed";
			}
		}
		return "list failed";
	}
	
	/**
	 * 得到收藏列表
	 */
	@RequestMapping(value="/listMyShares", method=RequestMethod.POST)
	@ResponseBody
	public String listMyShares(HttpServletRequest request) {
		String openid = request.getParameter("openid");
		if(!StringUtils.isEmpty(openid)) {
			List<SatArticleShare> share = satArticleShareService.listByOpenid(openid);
			List<SatArticle> list = satArticleService.listSatArticlesByOpenId(openid);
			System.out.println("list share " + list.size());
			if(list != null && list.size() > 0){
				for(SatArticle a: list) {
					for(SatArticleShare s : share) {
						if(a.getId().equals(s.getArticleId())) {
							a.setShares(s.getShares());
							a.setStars(s.getStars());
							a.setWatches(s.getWatches());
						}
					}
				}
				String result = JsonUtil.getInstance().list2json(list);
				return result;
			} else {
				return "list failed";
			}
		}
		return "list failed";
	}
	
	/**
	 * 删除我的收藏一条记录
	 */
	@RequestMapping(value="/deleteMyCollection", method=RequestMethod.POST)
	@ResponseBody
	public String deleteMyCollection(HttpServletRequest request) {
		String openid = request.getParameter("openid");
		String articleId = request.getParameter("articleId");
		if(!StringUtils.isEmpty(openid) && !StringUtils.isEmpty(articleId)) {
			satArticleService.deleteMyCollection(openid, articleId);
			return "delete success";
		}
		return "delete failed";
	}
	
	/**
	 * 删除我的收藏一条记录
	 */
	@RequestMapping(value="/deleteMyShare", method=RequestMethod.POST)
	@ResponseBody
	public String deleteMyShare(HttpServletRequest request) {
		String openid = request.getParameter("openid");
		String articleId = request.getParameter("articleId");
		if(!StringUtils.isEmpty(openid) && !StringUtils.isEmpty(articleId)) {
			satArticleService.deleteMyCollection(openid, articleId);
			return "delete success";
		}
		return "delete failed";
	}
	
}
