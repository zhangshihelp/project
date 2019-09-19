package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.cms.CmsPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

// MongoRepository<模型类，主键类型>
// Spring Data mongodb也提供自定义方法的规则
// 按照findByXXX，findByXXXAndYYY、countByXXXAndYYY等规则定义方法，实现查询操作
public interface CmsPageRepository extends MongoRepository<CmsPage, String> {
    //根据页面名称查询
    CmsPage findByPageName(String pageName);

    //根据页面名称和类型查询
    CmsPage findByPageNameAndPageType(String pageName, String pageType);

    //根据站点和页面类型查询记录数
    int countBySiteIdAndPageType(String siteId, String pageType);

    //根据站点和页面类型分页查询
    Page<CmsPage> findBySiteIdAndPageType(String siteId, String pageType, Pageable pageable);
}
