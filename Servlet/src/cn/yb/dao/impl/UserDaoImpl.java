package cn.yb.dao.impl;

import cn.yb.dao.IUserDao;
import cn.yb.model.User;
import cn.yb.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImpl implements IUserDao {

    //声明JdbcTemplate共用
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 登陆
     *
     * @param loginUser 只有用户名和密码
     * @return 包含用户的全部数据，没有查询到返回null
     */
    @Override
    public User login(User loginUser) {
        try {
            //sql
            String sql = "select * from user where username=? and password=?";
            //调用方法
            User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(), loginUser.getPassword());
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
