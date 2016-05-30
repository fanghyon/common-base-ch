package com.changhong.common.domain.user;

import com.changhong.common.domain.EntityBase;

/**
 * User: Jack Wang
 * Date: 16-3-28
 * Time: 上午11:41
 */
public class Position extends EntityBase {

    public static final String NAME = "p_name";

    private String name;

    private int level;

    /************************************************GET/SET*********************************************/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
