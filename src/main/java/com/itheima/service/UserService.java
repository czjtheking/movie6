package com.itheima.service;

import com.itheima.domain.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface UserService {

    /**
     * 保存
     * @param user
     * @return
     */
    public boolean save(User user);

    /**
     * 修改
     * @param
     * @return
     */
    public boolean upName(Integer userId, String userName);

    public boolean upPsw(Integer userId, String userPsw);
    /**
     * 按id删除
     * @param User_id
     * @return
     */
    public boolean delete(Integer User_id);

    /**
     * 按id查询
     * @param userId
     * @return
     */
    public User findUser(Integer userId);


    public User loginInService(String userAccount, String userPsw,boolean userAd);

    /**
     * 登录
     * @param user
     * @return
     */

    public User registerService(User user);
    /**
     * 注册
     */


}
