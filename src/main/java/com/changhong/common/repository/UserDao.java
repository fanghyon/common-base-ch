package com.changhong.common.repository;

import com.changhong.common.repository.EntityObjectDao;
import com.changhong.common.domain.user.Department;
import com.changhong.common.domain.user.Position;
import com.changhong.common.domain.user.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

/**
 * User: Jack Wang
 * Date: 14-4-9
 * Time: 上午9:25
 */
public interface UserDao extends EntityObjectDao {

    UserDetails findUserByUsername(String mobile);

    List<User> findOverviewUsers(String name, int departmentId, int startPosition, int pageSize);

    int findOverviewUserSize(String name, int departmentId);

    boolean loadUserExist(int userId, String username);

    List<User> loadBeloneManagers(int positionId);

    List<User> loadMemeberByDepartment(int departmentId);

    /***********************************************部门部分**********************************************************/

    List<Department> loadAllDepartments();

    List<Department> loadDepartmentByParentId(int departmentId);

    /***********************************************职位部分**********************************************************/

     List<Position> findAllPositions();

    List<Position> findOverviewPositions(int startPosition, int pageSize);

    int findOverviewPositionSize();

    /***********************************************签到部分**********************************************************/

    void deleteUserQianDaoInfo(int placeId, int timeId);

}
