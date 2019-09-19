package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.CmsPageParam;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CmsPageRepositoryTest {

    // 有ManageCmsApplication启动类进行包扫描，所以该类也进入了容器中，可以直接获取
    @Autowired
    CmsPageRepository cmsPageRepository;

    // 查询所有
    @Test
    public void testFindAll() {
        List<CmsPage> cmsPages = cmsPageRepository.findAll();
        System.out.println(cmsPages);
    }

    // 分页查询
    @Test
    public void testFindPage() {
        // 分页参数
        int page = 1; // 从0开始
        int size = 10;
        Pageable pageable = PageRequest.of(page, size);
        Page<CmsPage> cmsPages = cmsPageRepository.findAll(pageable);
        System.out.println(cmsPages);
    }

    //添加
    @Test
    public void testInsert() {
        // 定义实体类
        CmsPage cmsPage = new CmsPage();
        cmsPage.setSiteId("s01");
        cmsPage.setTemplateId("t01");
        cmsPage.setPageName("测试页面");
        cmsPage.setPageCreateTime(new Date());
        List<CmsPageParam> cmsPageParams = new ArrayList<>();
        CmsPageParam cmsPageParam = new CmsPageParam();
        cmsPageParam.setPageParamName("param1");
        cmsPageParam.setPageParamValue("value1");
        cmsPageParams.add(cmsPageParam);
        cmsPage.setPageParams(cmsPageParams);
        cmsPageRepository.save(cmsPage);
        System.out.println(cmsPage);
    }

    // 删除
    @Test
    public void testDelete() {
        cmsPageRepository.deleteById("5b17a2c511fe5e0c409e5eb3");
    }

    // 修改
    @Test
    public void testUpdate() {
        // 查询对象
        Optional<CmsPage> optional = cmsPageRepository.findById("");
        if (optional.isPresent()) {
            CmsPage cmsPage = optional.get();
            // 设置要修改的值
            cmsPage.setPageAliase("test01");
            // 修改
            CmsPage save = cmsPageRepository.save(cmsPage);
            System.out.println(save);
        }
    }
}

