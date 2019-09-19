package com.xuecheng.manage_cms.service;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.QueryResult;
import com.xuecheng.manage_cms.dao.CmsPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PageService {

    @Autowired
    CmsPageRepository cmsPageRepository;

    /**
     * 页面查询方法
     *
     * @param page             页码，从1开始计数
     * @param size             每页记录数
     * @param queryPageRequest 查询条件
     * @return
     */
    public QueryResponseResult findList(int page,
                                        int size,
                                        QueryPageRequest queryPageRequest) {
        // 分页参数判断
        if (page <= 0) {
            page = 1;
        }
        // page从1开始，但分页器从0开始
        page = page - 1;
        if (size <= 0) {
            size = 10;
        }
        Pageable pageable = PageRequest.of(page, size);
        Page<CmsPage> pages = cmsPageRepository.findAll(pageable);
        QueryResult queryResult = new QueryResult();
        queryResult.setList(pages.getContent()); // 数据列表
        queryResult.setTotal(pages.getTotalElements()); // 数据总记录数
        return new QueryResponseResult(CommonCode.SUCCESS,queryResult);
    }
}
