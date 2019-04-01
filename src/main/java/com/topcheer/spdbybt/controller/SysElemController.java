package com.topcheer.spdbybt.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.topcheer.spdbybt.common.DateUtil;
import com.topcheer.spdbybt.entity.SysElem;
import com.topcheer.spdbybt.entity.YbtElemsOptions;
import com.topcheer.spdbybt.entity.YbtFieldElems;
import com.topcheer.spdbybt.entity.YbtModuleElems;
import com.topcheer.spdbybt.mapper.SysElemMapper;
import com.topcheer.spdbybt.mapper.YbtElemsOptionsMapper;
import com.topcheer.spdbybt.mapper.YbtFieldElemsMapper;
import com.topcheer.spdbybt.mapper.YbtModuleElemsMapper;
import com.topcheer.spdbybt.service.YbtElemsOptionsService;
import com.topcheer.spdbybt.service.YbtFieldElemsService;
import com.topcheer.spdbybt.service.YbtModuleElemsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
public class SysElemController {
    private static final Logger log = LoggerFactory.getLogger(SysElemController.class);

    @Autowired
    YbtModuleElemsService ybtModuleElemsService;

    @Autowired
    YbtModuleElemsMapper sysElemMapper;

    @Autowired
    YbtFieldElemsService ybtFieldElemsService;

    @Autowired
    YbtFieldElemsMapper ybtFieldElemsMapper;

    @Autowired
    YbtElemsOptionsService ybtElemsOptionsService;

    @Autowired
    YbtElemsOptionsMapper ybtElemsOptionsMapper;

    //list数据模块设置
    @RequestMapping(value = "/sysElementList")
    public ModelAndView sysElementList(YbtModuleElems sysElem, Model model, HttpServletRequest request,
     @RequestParam(required = false,defaultValue="1",value="pageNum")Integer pageNum,
                                       @RequestParam(defaultValue="5",value="pageSize")Integer pageSize) throws Exception {
          // 查询所有的数据模块；
        String atomtypename = request.getParameter("atomtypename");
        sysElem.setAtomtypename(atomtypename);
        ModelAndView view = new ModelAndView();
        //为了程序的严谨性，判断非空：
        if(pageNum == null){
            pageNum = 1;   //设置默认当前页
        }
        if(pageNum <= 0){
            pageNum = 1;
        }
        if(pageSize == null){
            pageSize = 5;    //设置默认每页显示的数据数
        }
        PageHelper.startPage(pageNum,pageSize).setOrderBy("atomtypeid asc");
        final PageInfo<YbtModuleElems> pageInfo = new PageInfo<YbtModuleElems>(ybtModuleElemsService.getSysElemList(sysElem),pageSize);
        for (int i=0;i<pageInfo.getList().size();i++) {
            log.info(pageInfo.getList().get(i).getAtomtypename());
        }
        log.info("[普通写法] - [{}]", pageInfo);


        view.addObject("sysElemList",pageInfo.getList());
        view.addObject("pageInfo",pageInfo);
        view.setViewName("sysElement/sysElementList");
        return view;

    }


    //to新增或编辑数据模块设置
    @RequestMapping(value = "/toSysElemAddOrEdit/{atomtypeid}",method = RequestMethod.GET)
    public ModelAndView toSysElemAddOrEdit(@PathVariable String atomtypeid,Model model) {
        YbtModuleElems sysElem = null;
        String mode = null;
        if(atomtypeid.equals("add")){
            sysElem = new YbtModuleElems();
            System.out.println(mode);
            System.out.println(sysElem);
            mode = "add";
        }else{
            sysElem = ybtModuleElemsService.getById(atomtypeid);
            mode = "edit";
        }
        ModelAndView view = new ModelAndView();
        view.addObject("sysElem",sysElem);
        view.addObject("mode",mode);
        view.setViewName("sysElement/sysElementEdit");
        System.out.println("************************"+atomtypeid);
        return view;

    }

    //新增或编辑数据
    @RequestMapping(value = "/saveSysElem")
    public String saveSysElem(YbtModuleElems sysElem,Model model,HttpServletRequest request) {
       String mode = request.getParameter("mode");
        if(mode.equals("add")){ // 新增数据
            sysElem.setUpdatedate(DateUtil.getTimeStr(new Date())); //创建时间;
            sysElem.setUpdatetime(DateUtil.getDateStr(new Date()));
            String operatorPerson = (String)request.getSession().getAttribute("operatorPerson");//操作柜员号
            String operatorbankcode = (String)request.getSession().getAttribute("operatorbankcode");//操作机构
            sysElem.setOperatorcode(operatorPerson);
            sysElem.setOperatorbankcode(operatorbankcode);
            sysElemMapper.insertSelective(sysElem);
        }else{  //修改数据
            sysElem.setUpdatedate(DateUtil.getTimeStr(new Date())); //创建时间;
            sysElem.setUpdatetime(DateUtil.getDateStr(new Date()));
            sysElemMapper.updateByPrimaryKeySelective(sysElem);
        }
        return "redirect:/sysElementList";

    }

    //删除数据
    @RequestMapping("/delSysElem/{atomtypeid}")
    public String delSysElem(@PathVariable String atomtypeid) {
        /*YbtModuleElems sysElem = ybtModuleElemsService.getById(atomtypeid);*/
        sysElemMapper.deleteByPrimaryKey(atomtypeid);
        return "redirect:/sysElementList";

    }

    //判断交易模块编号是否存在
    @RequestMapping("/getByAtomtypeid")
    @ResponseBody
    public int getByAtomtypeid(HttpServletRequest request) {
        int flag=0;
        String atomtypeid = request.getParameter("atomtypeid");
        YbtModuleElems sysElem = ybtModuleElemsService.getById(atomtypeid);
        if(sysElem == null){
            flag = 1;
        }
        return flag;

    }


    //判断交易模块名称是否存在
    @RequestMapping("/getByAtomtypename")
    @ResponseBody
    public int getByAtomtypename(HttpServletRequest request) {
        int flag=0;
        String atomtypename = request.getParameter("atomtypename");
        YbtModuleElems sysElem = ybtModuleElemsService.getByName(atomtypename);
        if(sysElem == null){
            flag = 1;
        }
        return flag;

    }



    //list数据字段元素设置
    @RequestMapping(value = "/fieldElementList")
    public ModelAndView fieldElementList(YbtFieldElems ybtFieldElems, Model model, HttpServletRequest request,
                                         @RequestParam(required = false,defaultValue="1",value="pageNum")Integer pageNum,
                                         @RequestParam(defaultValue="5",value="pageSize")Integer pageSize) throws Exception {
        // 查询所有的数据模块；
        String atomtypeid = request.getParameter("atomtypeid");
        String fieldcname = request.getParameter("fieldcname");
        ybtFieldElems.setAtomtypeid(atomtypeid);
        ybtFieldElems.setFieldcname(fieldcname);
        ModelAndView view = new ModelAndView();
        //为了程序的严谨性，判断非空：
        if(pageNum == null){
            pageNum = 1;   //设置默认当前页
        }
        if(pageNum <= 0){
            pageNum = 1;
        }
        if(pageSize == null){
            pageSize = 5;    //设置默认每页显示的数据数
        }
        PageHelper.startPage(pageNum,pageSize).setOrderBy("fieldId asc");
        final PageInfo<YbtFieldElems> pageInfo = new PageInfo<YbtFieldElems>(ybtFieldElemsService.getFieldElemList(ybtFieldElems),pageSize);
        for (int i=0;i<pageInfo.getList().size();i++) {
            log.info(pageInfo.getList().get(i).getFieldcname());
        }
        log.info("[普通写法] - [{}]", pageInfo);


        view.addObject("fieldElemList",pageInfo.getList());
        view.addObject("pageInfo",pageInfo);
        view.setViewName("sysElement/fieldElementList");
        return view;

    }

    //to新增或修改数据字段元素页面
    @RequestMapping(value = "/toFieldElemAddOrEdit/{fieldid}")
    public ModelAndView toFieldElemAddOrEdit(@PathVariable String fieldid,Model model) throws Exception {
        YbtFieldElems ybtFieldElems = null;
        YbtModuleElems sysElem = null;
        List<YbtModuleElems> sysElemList = ybtModuleElemsService.getSysElemList(sysElem);
        String mode = null;
        if(fieldid.equals("add")){
            ybtFieldElems = new YbtFieldElems();
            mode = "add";
        }else{
            ybtFieldElems = ybtFieldElemsMapper.selectByPrimaryKey(fieldid);
            mode = "edit";
        }
        ModelAndView view = new ModelAndView();
        view.addObject("ybtFieldElems",ybtFieldElems);
        view.addObject("sysElemList",sysElemList);
        view.addObject("mode",mode);
        view.setViewName("sysElement/fieldElementEdit");
        return view;
    }


    //新增或编辑数据
    @RequestMapping(value = "/saveFieldElem")
    public String saveFieldElem(YbtFieldElems ybtFieldElems,Model model,HttpServletRequest request) {
        String mode = request.getParameter("mode");
        System.out.println("*************************"+ybtFieldElems.getFieldcname());
        System.out.println(mode);
        if(mode.equals("add")){ // 新增数据
            ybtFieldElems.setUpdatedate(DateUtil.getTimeStr(new Date())); //创建时间;
            ybtFieldElems.setUpdatetime(DateUtil.getDateStr(new Date()));
            String operatorPerson = (String)request.getSession().getAttribute("operatorPerson");//操作柜员号
            String operatorbankcode = (String)request.getSession().getAttribute("operatorbankcode");//操作机构
            ybtFieldElems.setOperatorcode(operatorPerson);
            ybtFieldElems.setOperatorbankcode(operatorbankcode);
            ybtFieldElemsMapper.insertSelective(ybtFieldElems);
        }else{  //修改数据
            ybtFieldElems.setUpdatedate(DateUtil.getTimeStr(new Date())); //创建时间;
            ybtFieldElems.setUpdatetime(DateUtil.getDateStr(new Date()));
            ybtFieldElemsMapper.updateByPrimaryKeySelective(ybtFieldElems);
        }
        return "redirect:/fieldElementList";

    }


    //删除数据
    @RequestMapping("/delFieldElem/{fieldid}")
    public String delFieldElem(@PathVariable String fieldid) {
        /*YbtModuleElems sysElem = ybtModuleElemsService.getById(atomtypeid);*/
        ybtFieldElemsMapper.deleteByPrimaryKey(fieldid);
        return "redirect:/fieldElementList";

    }

    //判断字段元素编号是否存在
    @RequestMapping("/getById")
    @ResponseBody
    public int getById(HttpServletRequest request) {
        int flag=0;
        String fieldid = request.getParameter("fieldid");
        YbtFieldElems sysElem = ybtFieldElemsMapper.selectByPrimaryKey(fieldid);
        if(sysElem == null){
            flag = 1;
        }
        return flag;

    }

    //判断字段中文名称是否存在
    @RequestMapping("/getByFieldcname")
    @ResponseBody
    public int getByFieldcname(HttpServletRequest request) {
        int flag=0;
        String fieldcname = request.getParameter("fieldcname");
        YbtFieldElems sysElem = ybtFieldElemsMapper.selectByFieldcname(fieldcname);
        if(sysElem == null){
            flag = 1;
        }
        return flag;

    }


    //判断字段英文名称是否存在
    @RequestMapping("/getByFieldename")
    @ResponseBody
    public int getByFieldename(HttpServletRequest request) {
        int flag=0;
        String fieldename = request.getParameter("fieldename");
        YbtFieldElems sysElem = ybtFieldElemsMapper.selectByFieldename(fieldename);
        if(sysElem == null){
            flag = 1;
        }
        return flag;

    }


    //list数据字典设置
    @RequestMapping(value = "/dataElementList")
    public ModelAndView dataElementList(YbtElemsOptions ybtElemsOptions, Model model, HttpServletRequest request,
                                        @RequestParam(required = false,defaultValue="1",value="pageNum")Integer pageNum,
                                        @RequestParam(defaultValue="5",value="pageSize")Integer pageSize) {

        // 查询所有的数据模块；
        String atomtypeid = request.getParameter("atomtypeid");
        String fieldid = request.getParameter("fieldid");
        ybtElemsOptions.setAtomtypeid(atomtypeid);
        ybtElemsOptions.setFieldid(fieldid);
        ModelAndView view = new ModelAndView();
        //为了程序的严谨性，判断非空：
        if(pageNum == null){
            pageNum = 1;   //设置默认当前页
        }
        if(pageNum <= 0){
            pageNum = 1;
        }
        if(pageSize == null){
            pageSize = 5;    //设置默认每页显示的数据数
        }
        PageHelper.startPage(pageNum,pageSize);
        final PageInfo<YbtElemsOptions> pageInfo = new PageInfo<YbtElemsOptions>(ybtElemsOptionsService.getElemsOptionsList(ybtElemsOptions),pageSize);
        for (int i=0;i<pageInfo.getList().size();i++) {
            log.info(pageInfo.getList().get(i).getFieldcname());
        }
        log.info("[普通写法] - [{}]", pageInfo);


        view.addObject("ElemOptionsList",pageInfo.getList());
        view.addObject("pageInfo",pageInfo);

        view.setViewName("sysElement/dataElementList");
        return view;
    }

    //to新增数据字典设置
    @RequestMapping(value = "/toDataElemAddOrEdit/{optionid}/{atomtypeid}/{fieldid}")
    public ModelAndView toDataElemAddOrEdit(@PathVariable String optionid,@PathVariable String atomtypeid,@PathVariable String fieldid,Model model) throws Exception {
        YbtElemsOptions ybtElemsOptions = null;
        YbtModuleElems sysElem = null;
        List<YbtModuleElems> sysElemList = ybtModuleElemsService.getSysElemList(sysElem);
        List<YbtFieldElems> ybtFieldElemsList =  ybtFieldElemsMapper.getByInputType();
        String mode = null;
        if(optionid.equals("add")){
            ybtElemsOptions = new YbtElemsOptions();
            mode = "add";
        }else{
            YbtElemsOptions ybtElemsOption = new YbtElemsOptions();
            ybtElemsOption.setOptionid(optionid);
            ybtElemsOption.setAtomtypeid(atomtypeid);
            ybtElemsOption.setFieldid(fieldid);
            ybtElemsOptions = ybtElemsOptionsMapper.selectByPrimaryKey(ybtElemsOption);
            mode = "edit";
        }
        ModelAndView view = new ModelAndView();
        view.addObject("ybtElemsOptions",ybtElemsOptions);
        view.addObject("sysElemList",sysElemList);
        view.addObject("ybtFieldElemsList",ybtFieldElemsList);
        view.addObject("mode",mode);
        view.setViewName("sysElement/dataElementEdit");
        return view;
    }

    //添加或编辑数据字典设置
    @RequestMapping(value = "/saveDataElem")
    public String saveDataElem(YbtElemsOptions ybtElemsOptions,Model model,HttpServletRequest request) {
        String mode = request.getParameter("mode");
        System.out.println(mode);
        if(mode.equals("add")){ // 新增数据
            ybtElemsOptions.setUpdatedate(DateUtil.getTimeStr(new Date())); //创建时间;
            ybtElemsOptions.setUpdatetime(DateUtil.getDateStr(new Date()));
            String operatorPerson = (String)request.getSession().getAttribute("operatorPerson");//操作柜员号
            String operatorbankcode = (String)request.getSession().getAttribute("operatorbankcode");//操作机构
            ybtElemsOptions.setOperatorcode(operatorPerson);
            ybtElemsOptions.setOperatorbankcode(operatorbankcode);
            ybtElemsOptionsMapper.insertSelective(ybtElemsOptions);
        }else{  //修改数据
            ybtElemsOptions.setUpdatedate(DateUtil.getTimeStr(new Date())); //创建时间;
            ybtElemsOptions.setUpdatetime(DateUtil.getDateStr(new Date()));
            ybtElemsOptionsMapper.updateByPrimaryKeySelective(ybtElemsOptions);
        }
        return "redirect:/dataElementList";
    }


    //判断字典元素编号是否存在
    @RequestMapping("/getBySerialId")
    @ResponseBody
    public int getBySerialId(HttpServletRequest request) {
        int flag=0;
        String fieldid = request.getParameter("fieldid");
        String optionid = request.getParameter("optionid");
        String atomtypeid = request.getParameter("atomtypeid");
        YbtElemsOptions ybtElemsOption = new YbtElemsOptions();
        ybtElemsOption.setOptionid(optionid);
        ybtElemsOption.setAtomtypeid(atomtypeid);
        ybtElemsOption.setFieldid(fieldid);
        YbtElemsOptions ybtElemsOptions = ybtElemsOptionsMapper.selectByPrimaryKey(ybtElemsOption);
        if(ybtElemsOptions == null){
            flag = 1;
        }
        return flag;

    }


    //删除数据
    @RequestMapping("/delOptionElem/{optionid}/{atomtypeid}/{fieldid}")
    public String delFieldElem(@PathVariable String optionid,@PathVariable String atomtypeid,@PathVariable String fieldid) {
        /*YbtModuleElems sysElem = ybtModuleElemsService.getById(atomtypeid);*/
        YbtElemsOptions ybtElemsOption = new YbtElemsOptions();
        ybtElemsOption.setOptionid(optionid);
        ybtElemsOption.setAtomtypeid(atomtypeid);
        ybtElemsOption.setFieldid(fieldid);
        ybtElemsOptionsMapper.deleteByPrimaryKey(ybtElemsOption);
        return "redirect:/dataElementList";

    }

}
