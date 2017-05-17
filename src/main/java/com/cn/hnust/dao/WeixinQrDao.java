package com.cn.hnust.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cn.hnust.model.WeixinQr;

@Repository("weixinQrDao")
public class WeixinQrDao extends BaseDao<WeixinQr> implements IWeixinQrDao {

	public void delete(int id) {
		super.delete(WeixinQr.class, id);;
	}

	public WeixinQr load(int id) {
		return super.loadBySqlId("weixinQrLoad", id);
	}

	public List<WeixinQr> listBaseQr() {
		Map<String, Object> params = new HashMap<String, Object>();
		return super.list("listBaseQr", params);
	}

	public List<WeixinQr> listTempQr() {
		Map<String, Object> params = new HashMap<String, Object>();
		return super.list("listBaseQr", params);
	}

	public WeixinQr loadBySnum(int snum) {
		return super.loadBySqlId("weixinQrLoadBySnum", snum);
	}

}
