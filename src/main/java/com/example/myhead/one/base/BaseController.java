package com.example.myhead.one.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
     * 显示 list 界面
     */
    @RequestMapping("/showList")
    public String showList() {
        return this.viewName(this.getPathPrefix()) + "-list";
    }

    /**
     * 显示 create 创建页面
     */
    @RequestMapping(value = "/showCreatePage", method = RequestMethod.GET)
    public String showCreatePage(Model model) {
        return doShowCreatePage();

    }

    public String doShowCreatePage() {
        return this.viewName(this.getPathPrefix()) + "-create";
    }

    /**
     * 显示 update 编辑界面
     */
    @RequestMapping(value = "/showUpdatePage/{id}", method = RequestMethod.GET)
    public String updatePage(@PathVariable String id, Model model) {
        E entity = baseService.get(id);
        return doShowUpdatePage(entity, model);

    }

    public String doShowUpdatePage(E entity, Model model) {
        model.addAttribute("e", entity);
        return this.viewName(this.getPathPrefix()) + "-update";
    }

    @RequestMapping(value = "showDetailPage/{id}", method = RequestMethod.GET)
    public String showDeleteForm(@PathVariable("id") String id, Model model) {
        E entity = baseService.get(id);
        return doShowDetailPage(entity, model);
    }

    public String doShowDetailPage(E entity, Model model) {
        model.addAttribute("e", entity);
        return this.viewName(this.getPathPrefix() + "-detail");

    }
}
