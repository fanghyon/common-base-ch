package com.changhong.common.domain.user;

/**
 * User: Jack Wang
 * Date: 15-8-7
 * Time: 下午1:43
 */
public enum RoleType {
    ROLE_ADMIN("系统管理员"),
    ROLE_CONFIG("系统管理"),
    ROLE_JIXIAO("绩效管理"),
    ROLE_TASK("工作管理");

     private String description;

    RoleType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
