package com.cn.hnust.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.IWeixinMenuDao;
import com.cn.hnust.model.WeixinMenu;
import com.cn.hnust.model.WeixinMenuDto;
import com.cn.hnust.service.IWeixinMenuService;

@Service("weixinMenuService")
public class WeixinMenuService implements IWeixinMenuService {
	
	@Resource
	private IWeixinMenuDao weixinMenuDao;

	public void add(WeixinMenu wm) {
		if(wm.getType().equals("view")) {
			wm.setMenuKey("KEY_" + System.currentTimeMillis());
		}
		weixinMenuDao.add(wm);
	}

	public void delete(int id) {
		weixinMenuDao.delete(WeixinMenu.class, id);
	}

	public void update(WeixinMenu wm) {
		weixinMenuDao.update(wm);
	}

	public WeixinMenu load(int id) {
		return weixinMenuDao.findById(WeixinMenu.class, id);
	}

	public List<WeixinMenu> listAll() {
		return weixinMenuDao.list("WeixinMenuFindAll", null);
	}

	public WeixinMenu loadByKey(String key) {
		return weixinMenuDao.loadByKey(key);
	}

	public List<WeixinMenuDto> gengrateWeixinMenuDto() {
		List<WeixinMenu> menus = this.listAll();
		List<WeixinMenuDto> menuDtos = new ArrayList<WeixinMenuDto>();
		WeixinMenuDto menuDto = null;
		for(WeixinMenu wm : menus) {
			menuDto = new WeixinMenuDto();
			menuDto.setKey(wm.getMenuKey());
			menuDto.setName(wm.getName());
			menuDto.setType(wm.getType());
			menuDto.setId(wm.getId());
			menuDto.setUrl(wm.getUrl());
			if(wm.getPid() == null || wm.getPid() == 0) {
				if(menuDto.getSub_button() == null) {
					menuDto.setSub_button(new ArrayList<WeixinMenuDto>());
				} 
				menuDtos.add(menuDto);
			}else {
				WeixinMenuDto twmd = findById(wm.getPid(), menuDtos);
				if(twmd == null) {
					throw new RuntimeException("�˵�����������");
				}
				twmd.getSub_button().add(menuDto);
			}
		}
		return menuDtos;
	}
	
	private WeixinMenuDto findById(int id, List<WeixinMenuDto> wmds) {
		for(WeixinMenuDto wmd:wmds) {
			if(wmd.getId() == id) {
				return wmd;
			}
		}
		return null;
	}

}
