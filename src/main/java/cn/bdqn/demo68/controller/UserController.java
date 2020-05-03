package cn.bdqn.demo68.controller;


import cn.bdqn.demo68.entity.User;
import cn.bdqn.demo68.service.IUserService;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author furuilong
 * @since 2020-02-14
 */
@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    private IUserService iUserService;


    @GetMapping("/add")
    public String add() {

        return "add";
    }

    @GetMapping("/add/{id}")
    public String add(@PathVariable String id, Model model) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        User list = iUserService.getOne(queryWrapper);
        model.addAttribute("emp", list);
        return "add";
    }

    @PostMapping("/login")
    public String login(@RequestParam String userCode, @RequestParam String userPassword, HttpSession session) {
        System.out.println("111111111111111111111111");
        System.out.println("2222222222222222222222222");
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userCode", userCode);
        queryWrapper.eq("userPassword", userPassword);
        List<User> list = iUserService.list(queryWrapper);
        if (list.size() <= 0) {
            session.setAttribute("exit", "用户名或密码不正确");
            return "HomPage";
        } else {
            session.setAttribute("userCode", userCode);
            return "redirect:/user/list";
        }

    }

    @RequestMapping("/list")
    public String list(Model Model, HttpServletRequest request, HttpSession session) {
        //  QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        //  queryWrapper.eq("userCode","admin");
        //  queryWrapper.eq("userPassword","1234567");
//        //List<User> list = iUserService.list(queryWrapper);
//        List<User> userList = iUserService.findUserList();
//        System.out.println("+++++++++++++++" + userList);
//
//
//        List<User> userList1 = iUserService.findUserList();
//        System.out.println("+++++++++++++++" + userList1);
//        queryWrapper.like("userName","a");
//        queryWrapper.in("userRole","1,2,3");
////
      IPage<User> iPage=new Page<>(2,2);
        IPage<User>  userPage = iUserService.page(iPage, null);

        //List<User> list = iUserService.list();
        List<User> userList = userPage.getRecords();

        // User user = iUserService.getOne(queryWrapper);

        Object userCode = session.getAttribute("userCode");
        Model.addAttribute("userCode", userCode);
        Model.addAttribute("userList", userList);
        return "login";
    }

    @PostMapping("/emp")
    public String add(User user) {
        boolean save = iUserService.save(user);
        if (save == true) {
            return "redirect:/user/list";
        } else {
            return "add";
        }

    }

    @PutMapping("/emp")
    public String update(User user) {
//        UpdateWrapper<User> userUpdateWrapper=new UpdateWrapper<>();
//        userUpdateWrapper.set("id",16);
//        userUpdateWrapper.set("userName","xxxx");
        boolean update = iUserService.updateById(user);
        if (update == true) {
            return "redirect:/user/list";
        }
        return "/add";
    }

    @GetMapping("/del/{id}")
//   @DeleteMapping("/del/{id}")
    public String del(@PathVariable Integer id) {
        boolean b = iUserService.removeById(id);
        if (b == true) {
            return "redirect:/user/list";
        } else {
            System.out.println("111111111111111111111111");
            return "redirect:/user/list";
        }
    }
}
