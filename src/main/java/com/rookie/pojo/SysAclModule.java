package com.rookie.pojo;

import java.io.Serializable;

/**
 * sys_acl_module
 * @author 
 */
public class SysAclModule implements Serializable {
    /**
     * 权限模块id
     */
    private Integer id;

    /**
     * 权限模块名称
     */
    private String name;

    /**
     * 上级权限模块id
     */
    private Integer parentId;

    /**
     * 权限模块层级
     */
    private String level;

    /**
     * 权限模块在当前层级下的顺序，由小到大
     */
    private Integer seq;

    /**
     * 状态，1：正常，0：冻结
     */
    private Integer status;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}