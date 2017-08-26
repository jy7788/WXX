package com.cn.hnust.service.sat;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cn.hnust.dao.sat.ISatAdvertisementDao;
import com.cn.hnust.model.WeixinFinalValue;
import com.cn.hnust.model.sat.SatAdvertisement;
import com.cn.hnust.util.SatUtil;

@Service("satAdService")
public class SatAdService implements ISatAdService{
	
	@Autowired
	private ISatAdvertisementDao satAdvertisementDao;

	@Override
	public void insertAd(SatAdvertisement ad) {
		satAdvertisementDao.add(ad);
	}

	@Override
	public void updateAd(SatAdvertisement ad) {
		satAdvertisementDao.update(ad);;
	}

	@Override
	public List<SatAdvertisement> getAdsByUserId(String userId) {
		return satAdvertisementDao.listByOpenid(userId);
	}

	@Override
	public SatAdvertisement load(String id) {
		SatAdvertisement satAdvertisement = satAdvertisementDao.loadById(id);
		return satAdvertisement;
	}

	@Override
	public SatAdvertisement loadArticleAd(String openid, String articleId) {
		SatAdvertisement advertisement = satAdvertisementDao.loadByArticleIdAndOpenId(openid, articleId);
		return advertisement;
	}

	@Override
	public Integer getCount(String openid) {
		return satAdvertisementDao.selectCount(openid);
	}
	
	public String saveImage(MultipartFile file) {
		/*System.out.println(file.getOriginalFilename());
        int dotPos = file.getOriginalFilename().lastIndexOf(".");
        if(dotPos < 0) {
            return null;
        }
        String fileExt = file.getOriginalFilename().substring(dotPos + 1).toLowerCase();
        if(!SatUtil.isFileAllowed(fileExt)) {
            return null;
        }*/
		String contentType = file.getContentType().toLowerCase();
		String fileName = null;
		if(contentType.contains("jpeg") || contentType.contains("jpg")) {
			fileName = UUID.randomUUID().toString().replaceAll("-", "") + ".jpg" ;
		}else if(contentType.contains("png")) {
			fileName = UUID.randomUUID().toString().replaceAll("-", "") + ".jpg" ;
		}else if(contentType.contains("bmp")) {
			fileName = UUID.randomUUID().toString().replaceAll("-", "") + ".bmp" ;
		}else if(contentType.contains("gif")) {
			fileName = UUID.randomUUID().toString().replaceAll("-", "") + ".gif" ;
		}else {
			fileName = UUID.randomUUID().toString().replaceAll("-", "") + ".jpg" ;
		}
        try {
			Files.copy(file.getInputStream(), new File(SatUtil.IMAGE_DIR + fileName).toPath(), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
        return WeixinFinalValue.SERVER_URL + "ad/image?name=" + fileName;

    }

	@Override
	public SatAdvertisement loadUserAds(String openid) {
		return null;
	}

}
