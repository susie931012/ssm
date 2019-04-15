package com.shsxt.controller;

import com.github.pagehelper.PageInfo;
import com.shsxt.base.BaseQuery;
import com.shsxt.model.ResultInfo;
import com.shsxt.po.User;
import com.shsxt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by xlf on 2019/4/15.
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("queryUser")
    @ResponseBody
    public User queryUser(Integer id) throws Exception {
        return userService.queryById(id);
    }

    @RequestMapping("queryUserList")
    @ResponseBody
    public PageInfo<User> queryUserList(BaseQuery query) throws Exception {
        return userService.queryForPage(query);
    }

    @RequestMapping("saveUser")
    @ResponseBody
    public ResultInfo saveUser(User user) throws Exception {
        ResultInfo resultInfo = new ResultInfo();
        userService.insert(user);
        resultInfo.setCode(200);
        resultInfo.setMsg("添加成功");
        return resultInfo;
    }

    @RequestMapping("deleteUser")
    @ResponseBody
    public ResultInfo deleteUser(Integer id) throws Exception {
        ResultInfo resultInfo = new ResultInfo();
        userService.delete(id);
        resultInfo.setCode(200);
        resultInfo.setMsg("删除成功");
        return resultInfo;
    }


}
