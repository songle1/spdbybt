package com.topcheer.spdbybt.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import com.topcheer.spdbybt.service.UserService;
import com.topcheer.spdbybt.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


//@RestController/**自动返回的是json格式数据***/
@Controller/**视图解析器对应方法上可以解析return的jsp html***/
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public ModelAndView list(){
        ModelAndView view = new ModelAndView();
        List<User> userlist = userService.findAllUser();
        User user = new User();
        user.setId(1234234);
        user.setSex("男");
        user.setUsername("max");
        user.setPassword("********");
        user.setAddress("AJKHSKJHKJ");
        view.addObject("user",user);
        view.addObject("userlist",userlist);
        view.setViewName("reciveControllerData");
        return view;
    }


    @RequestMapping(path="/list2")
    public String list2(Model model){
        ModelMap map = new ModelMap();
        List<User> userlist = userService.findAllUser();
        User user = new User();
        user.setId(1234234);
        user.setSex("男");
        user.setUsername("max");
        user.setPassword("********");
        user.setAddress("AJKHSKJHKJ");
        userlist.add(user);
        model.addAttribute("user",user);
        model.addAttribute("userlist",userlist);
        return "/reciveControllerData";
    }

    @RequestMapping("/getUsers")
    public ModelAndView getUsers() {
        ModelAndView view = new ModelAndView();
        PageHelper.startPage(1, 5).setOrderBy("id asc");
        final PageInfo<User> userPageInfo = new PageInfo<>(this.userService.getAll());
        for (int i=0;i<userPageInfo.getList().size();i++) {
            log.info(userPageInfo.getList().get(i).getUsername());
        }
        log.info("[普通写法] - [{}]", userPageInfo);


        view.addObject("userlist",userPageInfo.getList());

        List<User> userlist = userService.findAllUser();
        view.addObject("userlist2",userlist);
        view.setViewName("reciveControllerData");

        User user = new User();
        user.setId(1234234);
        user.setSex("男");
        user.setUsername("max");
        user.setPassword("********");
        user.setAddress("AJKHSKJHKJ");
        view.addObject("user",user);

        return view;
    }

    @RequestMapping(path="/getUserList")
    public String getUserList(Model model){
        ModelMap map = new ModelMap();
        List<User> userlist = userService.findAllUser();
        User user = new User();
        user.setId(1234234);
        user.setSex("男");
        user.setUsername("max");
        user.setPassword("********");
        user.setAddress("AJKHSKJHKJ");
        userlist.add(user);
        model.addAttribute("user",user);
        model.addAttribute("userlist",userlist);
        return "/userlist";
    }


}