package com.outer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.inner.api.bean.User;
import com.inner.api.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * 测试controller
 *
 * @author kecc
 */
@RestController
@RequestMapping("/user")
public class UserController {


    static final String BRANCH_URL = "dubbo://127.0.0.1:20881";

    @Reference(url = BRANCH_URL)
    UserService userService;

    @ApiOperation(value = "新增用户信息", notes = "新增用户信息")
    @ApiImplicitParam(name = "user", value = "用户详细实体", required = true, dataType = "User")
    @PostMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public int addUser(User user) {
        return userService.addUser(user);
    }

    @ApiOperation(value = "查询用户信息", notes = "分页查询用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页数", required = true, dataType = "Integer", paramType = "path"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数", required = true, dataType = "Integer", paramType = "path")
    })
    @GetMapping(value = "/all/{pageNum}/{pageSize}")
    public Object findAllUser(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {
        return userService.findAllUser(pageNum, pageSize);
    }
}
