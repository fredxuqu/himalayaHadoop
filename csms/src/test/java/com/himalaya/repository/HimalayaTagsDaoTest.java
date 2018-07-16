package com.himalaya.repository;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.himalaya.BaseTestCase;
import com.himalaya.domain.TagsDO;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2017年7月26日 上午11:05:36
* Description
*/
public class HimalayaTagsDaoTest extends BaseTestCase {
	
	@Autowired
	HimalayaTagsDao himalayaTagsDao;
	
	@Test
	public void testGetAll(){
		
		List<TagsDO> tagList = himalayaTagsDao.getAll();
		LOGGER.info("Got tags " + tagList.size());
		for (TagsDO tagsDO : tagList) {
			LOGGER.info("--" + tagsDO.toString());
		}
	}
       
    @Test
    public void testGetById(){
    	TagsDO tag = himalayaTagsDao.getById(new Integer(18));
    	LOGGER.info(tag.toString());
    }
	
    @Test
    public void test01Insert(){
    	TagsDO tag = new TagsDO();
    	tag.setId(1234);
    	tag.setTagName("Fredxu");
    	tag.setStatus(1);
    	tag.setType(2);
    	tag.setRank(1000);
    	tag.setCreateTime(new Date());
    	tag.setModifyTime(new Date());
    	tag.setCreateUser("admin");
    	tag.setModifyUser("admin");
    	himalayaTagsDao.insert(tag);
    }
    
    @Test
    public void test02Update(){
    	TagsDO tag = new TagsDO();
    	tag.setId(1234);
    	tag.setTagName("Wendy Xu");
    	tag.setStatus(2);
    	himalayaTagsDao.update(tag);
    }
 
    @Test
    public void test03Delete(){
    	himalayaTagsDao.delete(1234);
    }
}
