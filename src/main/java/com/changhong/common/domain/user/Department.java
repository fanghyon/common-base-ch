package com.changhong.common.domain.user;

import com.changhong.common.domain.EntityBase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * User: Administrator
 * Date: 16-3-27
 * Time: 上午8:29
 */
public class Department extends EntityBase {

    public static final String NAME = "d_name";
    public static final String PARENT_ID = "parent_id";
    public static final String CHILD_COUNT = "child_count";

    private String name;

    private Department parent;

    private List<Department> children;

    public Department() {
    }

    public Department(int id, String name) {
        setId(id);
        this.name = name;
    }

    public boolean isLeaf() {
        if (children == null || children.isEmpty()) {
            return true;
        }
        return false;
    }

    public List<Department> getAllDepartmentBelow() {
		List<Department> all = new ArrayList<Department>();
		List<Department> children = this.getChildren();
		if (children != null) {
			all.addAll(children);
			Iterator i = children.iterator();
			while (i.hasNext()) {
				Department department = (Department) i.next();
				all.addAll(department.getAllDepartmentBelow());
			}
		}
		return all;
	}

    public List<Department> getAllDepartmentBelowWithItself() {
		List<Department> all = new ArrayList<Department>();
        all.add(this);
		List<Department> children = this.getChildren();
		if (children != null) {
			all.addAll(children);
			Iterator i = children.iterator();
			while (i.hasNext()) {
				Department department = (Department) i.next();
				all.addAll(department.getAllDepartmentBelow());
			}
		}
		return all;
	}

    public List getAllDepartmentAbove() {
		List<Department> all = new ArrayList<Department>();
		Department parent = this.getParent();
		if (parent != null) {
			all.addAll(parent.getAllDepartmentAbove());
			all.add(parent);
		}
		return all;
	}

    public List<Department> getAllSitesAboveWithItself() {
		List<Department> all = new ArrayList<Department>();
		Department parent = this.getParent();
		if (parent != null) {
			all.addAll(parent.getAllDepartmentAbove());
			all.add(parent);
		}
        all.add(this);
		return all;
	}

    public String getFullDepartmentPath() {
        List<Department> all = getAllSitesAboveWithItself();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < all.size(); i++) {
            Department site = all.get(i);
            builder.append("/" + site.getName());
        }

        return builder.toString();
    }

    /**********************************GETTER/SETTER*****************************************/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getParent() {
        return parent;
    }

    public void setParent(Department parent) {
        this.parent = parent;
    }

    public List<Department> getChildren() {
        return children;
    }

    public void setChildren(List<Department> children) {
        this.children = children;
    }
}
