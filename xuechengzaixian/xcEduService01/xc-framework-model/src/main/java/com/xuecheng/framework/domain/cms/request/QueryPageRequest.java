package com.xuecheng.framework.domain.cms.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class QueryPageRequest {
    // 接收页面查询的查询条件
    // 站点id
    @ApiModelProperty("站点id")
    private String siteId;

    // 页面id
    @ApiModelProperty("页面ID")
    private String pageId;

    @ApiModelProperty("页面名称")
    // 页面名称
    private String pageName;

    @ApiModelProperty("页面别名")
    // 页面别名
    private String pageAliase;

    @ApiModelProperty("模版id")
    // 模板id
    private String templateId;
}
