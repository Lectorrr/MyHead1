package com.example.myhead.one.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.Serializable;

/**
 * @author lector
 */
public class BaseController<E extends BaseEntity, T extends Serializable> {

    @Autowired
    private BaseService<E> baseService;

    protected String PathPrefix;

    private String viewPrefix;

    protected final Class<E> entityClass;

    protected BaseController() {
        this.entityClass = null;
        setViewPrefix(defaultViewPrefix());
    }

    protected String defaultViewPrefix() {
        String currentViewPrefix = "";
        RequestMapping requestMapping = AnnotationUtils.findAnnotation(getClass(), RequestMapping.class);

        if (requestMapping != null && requestMapping.value().length > 0) {
            currentViewPrefix = requestMapping.value()[0];
        }

        if (StringUtils.isEmpty(currentViewPrefix)) {
            currentViewPrefix = this.entityClass.getSimpleName();
        }
        return currentViewPrefix;
    }

    public String viewName(String suffixName) {

        if (!suffixName.startsWith("/")) {
            suffixName = "/" + suffixName;
        }
        return getViewPrefix() + suffixName;
    }

    public void setViewPrefix(String viewPrefix) {

        if (viewPrefix.startsWith("/")) {
            viewPrefix = viewPrefix.substring(1);
        }
        this.viewPrefix = viewPrefix;
    }

    public String getViewPrefix() {
        return viewPrefix;
    }

    public String getPathPrefix() {
        return PathPrefix;
    }

    public void setPathPrefix(String pathPrefix) {
        PathPrefix = pathPrefix;
    }


    /**
     * list 查方法
     */

    /**
     * 显示 create 创建页面
     */
    @RequestMapping("/showCreatePage")
    public String showCreatePage() {
        return this.getPathPrefix() + "create";
    }

    /**
     * 显示 list 界面
     */
    @RequestMapping("/showList")
    public String showList() {
        return this.viewName(this.getPathPrefix()) + "-list";
    }

    /**
     * 显示 update 编辑界面
     */
    @RequestMapping("/updatePage/{id}")
    public String updatePage(@PathVariable String id, Model model) {
        Object object = baseService.get(id);
        model.addAttribute("e", object);
        return this.getPathPrefix() + "update";
    }

    /**
     * add 增加方法
     */


    /**
     * add 增加 json 数据格式方法
     */


    /**
     * 删除
     *
     * @param id 实体的id
     */


    /**
     * 批量删除
     *
     * @param json
     * @return
     */


    /**
     * 查看详细数据
     *
     * @param id 实体id
     */

}
