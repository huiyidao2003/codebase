package org.victor.test.repository;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.victor.test.BaseRepository;
import org.victor.test.wrapper.UserWrapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 数据访问基础类
 * Created by zhengcunwen on 2016/7/16.
 */
@Repository
public class UserRepository extends BaseRepository{

    /**返回user对象类**/
    //public List<> getList

    // todo queryForObject对象只能返回一条记录


    /**得到数量**/
    public int getCountByGender(Integer id){
        String sql = "select count(1) from t_user where id=:id";
        Map<String,Integer> param = new HashMap<String,Integer>();
        param.put("id",id);
        return this.namedParameterJdbcTemplate.queryForObject(sql,param,Integer.class);
    }


    /**根据ID得到pojo对象-使用RowMapper来处理    ！！！！！！ 必须有数据才行，没有数据会报异常**/
    public UserWrapper getUserById1(Integer id){
        String sql = "select * from t_user where id=:id";
        Map<String,Integer> param = new HashMap<String,Integer>();
        param.put("id",id);
        return this.namedParameterJdbcTemplate.queryForObject(sql, param, new RowMapper<UserWrapper>() {
            @Override
            public UserWrapper mapRow(ResultSet resultSet, int i) throws SQLException {
                if(!resultSet.wasNull()){
                    UserWrapper wrapper = new UserWrapper();
                    wrapper.setAge(resultSet.getInt("id"));
                    wrapper.setDeptId(resultSet.getInt("dept_id"));
                    wrapper.setGender(resultSet.getInt("gender"));
                    wrapper.setId(resultSet.getInt("id"));
                    wrapper.setName(resultSet.getString("name"));
                    wrapper.setSalary(resultSet.getBigDecimal("salary"));
                    return wrapper;
                }

                return null;
            }
        });
    }

    /**
     * 根据ID得到pojo对象-使用自动绑定对象处理
     *
     * 数据库字段带下划线支持转换为驼峰方式变量
     *
     * ！！！！！！ 必须有数据才行，没有数据会报异常
     * **/
    public UserWrapper getUserById2(Integer id){
        String sql = "select * from t_user where id=:id";
        Map<String,Integer> param = new HashMap<String,Integer>();
        param.put("id",id);
        return (UserWrapper) this.namedParameterJdbcTemplate.queryForObject(sql, param, new BeanPropertyRowMapper(UserWrapper.class));
    }


    /**
     * 根据ID得到pojo对象-使用自动绑定对象处理
     *
     *
     * ！！！！！！ 必须有数据才行，没有数据会报异常
     *
     *
     * **/
    public UserWrapper getUserById3(Integer id){
        String sql = "select * from t_user where id=:id";
        Map<String,Integer> param = new HashMap<String,Integer>();
        param.put("id",id);


        List<UserWrapper> list = this.namedParameterJdbcTemplate.query(sql, param, new RowMapper<UserWrapper>() {
            @Override
            public UserWrapper mapRow(ResultSet resultSet, int i) throws SQLException {
                UserWrapper wrapper = new UserWrapper();
                wrapper.setAge(resultSet.getInt("id"));
                wrapper.setDeptId(resultSet.getInt("dept_id"));
                wrapper.setGender(resultSet.getInt("gender"));
                wrapper.setId(resultSet.getInt("id"));
                wrapper.setName(resultSet.getString("name"));
                wrapper.setSalary(resultSet.getBigDecimal("salary"));
                return wrapper;
            }
        });

        return list != null && list.size() > 0?list.get(0):null;
    }


    /**
     * in 查询，数据库字段带下划线支持转换为驼峰方式变量
     * @param ids
     * @return
     */
    public List<UserWrapper> getListByIn(List<Integer> ids){
        String sql = "select * from t_user where id in(:id)";
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("id",ids);
        return this.namedParameterJdbcTemplate.query(sql,param,new BeanPropertyRowMapper(UserWrapper.class));
    }

    /**
     * in 查询，返回一个Map的list
     * @param ids
     * @return
     */
    public List<Map<String,Object>> getListByIn2(List<Integer> ids){
        String sql = "select * from t_user where id in(:id)";
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("id",ids);
        return this.namedParameterJdbcTemplate.query(sql,param,new ColumnMapRowMapper());
    }


    /**保存或者修改-使用pojo对象**/
    public void save(UserWrapper wrapper){
        String sql = "insert t_user (name,salary,dept_id,age,gender) values(:name,:salary,:dept_id,:age,:gender)";

        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(wrapper);

        namedParameterJdbcTemplate.update(sql,sqlParameterSource);
    }

    /**保存或者修改-使用map对象**/
    public void update(){
        String sql = "update t_user set name='张曼玉' where id=:id";

        Map<String,Integer> param = new HashMap<String,Integer>();
        param.put("id",1);

        namedParameterJdbcTemplate.update(sql,param);
    }

    public List<Map<String,Object>> getListByLike(String txt){
        String sql = "select * from t_user where name like '%" + txt +"%'";
        Map<String,String> param = new HashMap<String,String>();
        param.put("txt",txt);

        return this.namedParameterJdbcTemplate.query(sql,param,new ColumnMapRowMapper());
    }


}


