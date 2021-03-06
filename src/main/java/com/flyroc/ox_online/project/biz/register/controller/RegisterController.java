package com.flyroc.ox_online.project.biz.register.controller;

import com.alibaba.fastjson.JSONObject;
import com.flyroc.ox_online.framework.aspectj.lang.annotation.Log;
import com.flyroc.ox_online.framework.aspectj.lang.enums.BusinessType;
import com.flyroc.ox_online.framework.web.controller.BaseController;
import com.flyroc.ox_online.framework.web.domain.AjaxResult;
import com.flyroc.ox_online.framework.web.page.TableDataInfo;
import com.flyroc.ox_online.project.biz.activation.domain.Activation;
import com.flyroc.ox_online.project.biz.activation.service.ActivationService;
import com.flyroc.ox_online.project.biz.byre.domain.HyByre;
import com.flyroc.ox_online.project.biz.byre.service.IHyByreService;
import com.flyroc.ox_online.project.biz.record.domain.HyVarietiesRecord;
import com.flyroc.ox_online.project.biz.record.service.IHyVarietiesRecordService;
import com.flyroc.ox_online.project.biz.register.domain.Register;
import com.flyroc.ox_online.project.biz.register.service.IRegisterService;
import com.flyroc.ox_online.project.biz.varieties.domain.HyVarieties;
import com.flyroc.ox_online.project.biz.varieties.service.IHyVarietiesService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/biz/register")
public class RegisterController extends BaseController {
    private String prefix = "biz/register";

    private String key = "";

    @Autowired
    private IRegisterService registerService;

    @Autowired
    private ActivationService activationService;

    @Autowired
    private IHyByreService hyByreService;

    @Autowired
    private IHyVarietiesService hyVarietiesService;

    @Autowired
    private IHyVarietiesRecordService hyVarietiesRecordService;


    /**
     * ??????
     *
     * @return
     */
    @RequiresPermissions("biz:register:view")
    @GetMapping()
    public String register() {
        return prefix + "/register";
    }

    /**
     * ????????????
     *
     * @param register
     * @return
     */
    @RequiresPermissions("biz:register:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HttpServletRequest request, Register register) {
        Map map = new HashMap();
        map.put("store_ower", request.getParameter("configName"));
        map.put("store_tel", request.getParameter("configKey"));
        map.put("create_time", request.getParameter("params[chooseTime]"));
        startPage();
        List<HashMap<String, Object>> list = registerService.selectTurnoverMassage(map);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).get("user_imports").equals("0")){
                list.get(i).put("user_imports","??????");
            }else if (list.get(i).get("User_imports").equals("4")){
                list.get(i).put("user_imports","??????");
            }
        }
        return getDataTable(list);
    }

    /**
     * ??????????????????????????? ?????????????????????
     *
     * @return
     */
    @RequiresPermissions("biz:register:form")
    @GetMapping("/form")
    public String from(ModelMap mmap) {
        List<HashMap<String, Object>> map = registerService.selectHyOxMarketCount();//???
        List<HashMap<String, Object>> max = registerService.selectHyOxMarketMax();//??????
        List<HashMap<String, Object>> min = registerService.selectHyOxMarketMin();//??????
        List<HashMap<String, Object>> max1 = registerService.selectHyOxMarketMax1();//??????
        List<HashMap<String, Object>> min1 = registerService.selectHyOxMarketMin1();//??????
        Object ax = max.get(0).get("count");
        Object in = min.get(0).get("count");
        Object ax1 = max1.get(0).get("count1");
        Object in1 = min1.get(0).get("count1");
        Object[] count = new Object[map.size()];
        Object[] count1 = new Object[map.size()];
        Object[] time = new Object[map.size()];
        int a = 0;
        for (HashMap<String, Object> map2 : map) {
            count[a] = map2.get("count");
            count1[a] = map2.get("count1");
            time[a] = map2.get("time");
            if (map2.get("time").equals(max.get(0).get("time"))) {
                mmap.put("max", a);
            }
            if (map2.get("time").equals(min.get(0).get("time"))) {
                mmap.put("min", a);
            }
            if (map2.get("time").equals(max1.get(0).get("time"))) {
                mmap.put("max1", a);
            }
            if (map2.get("time").equals(min1.get(0).get("time"))) {
                mmap.put("min1", a);
            }
            a++;
        }
        mmap.put("count", count);//??????
        mmap.put("count1", count1);//??????
        mmap.put("time", time);//??????
        mmap.put("ax", ax);//??????
        mmap.put("in", in);//??????
        mmap.put("ax1", ax1);//??????
        mmap.put("in1", in1);//??????
        return prefix + "/form";
    }

    /**
     * ??????????????????
     */
    @GetMapping("/edit/{user_id}")
    public String edit(@PathVariable("user_id") String user_id, ModelMap mmap, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<Activation> list = activationService.selectRegisterById(user_id);
        if(!list.isEmpty()){
            Activation activation = list.get(0);
            mmap.put("Activation", activation);
        }
        mmap.put("time", sdf.format(date));

        return prefix + "/edit";
    }

    /**
     * ??????????????????????????????
     * @param keys
     * @return
     */
    @RequestMapping("/toedit1")
    public String toedit1(String keys, ModelMap mmap) {
        this.key = keys;
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<Activation> list1 = activationService.selectActivationByCardId(key);
        Activation activation = list1.get(0);
        mmap.put("Activation", activation);
        mmap.put("time", sdf.format(date));
        return prefix + "/edit1";
    }

    /**
     * ????????????????????????????????????
     * @param resp
     * @throws IOException
     */
    @RequestMapping("/edit1")
    public void edit1(HttpServletResponse resp) throws IOException {

    }

    /**
     * ????????????
     */
    @Log(title = "????????????", businessType = BusinessType.UPDATE)
    @RequiresPermissions("biz:register:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HttpServletRequest request, @Validated Register register, HyVarieties hyVarieties) {
        //???????????????????????????
        List<HyVarieties> list2 = hyVarietiesService.selectHyVarietiesList(hyVarieties);
        String id = "";//?????????id
        List<HyVarietiesRecord> list = new ArrayList<>();//?????????????????????
        String HyVarieties = request.getParameter("HyVarieties");//??????????????????
        Long id1 = Long.parseLong(request.getParameter("quantity"));//????????????????????????
        HyVarietiesRecord ord = new HyVarietiesRecord();
        String uuid = java.util.UUID.randomUUID().toString().replaceAll("-", "");
        String uuid1 = java.util.UUID.randomUUID().toString().replaceAll("-", "");
        ord.setId(uuid);
        ord.setDealId(uuid1);
        ord.setOxId("");
        ord.setNum(id1);
        ord.setVarietiesId(HyVarieties);
        list.add(ord);
        //?????? ???????????????????????????????????????
        for (int i = 0; i < list2.size(); i++) {
            ord = new HyVarietiesRecord();
            HyVarieties hyVarieties1 = list2.get(i);//??????
            id = hyVarieties1.getVarietiesId();//?????????id
            if (request.getParameter(id)!=null&&request.getParameter(id).equals("")) {
                Long VarietiesId = Long.parseLong(request.getParameter(id));//?????????id???????????????
                if (VarietiesId == null) {
                    continue;
                } else {
                    ord.setId(uuid);
                    ord.setDealId(uuid1);
                    ord.setOxId("");
                    ord.setVarietiesId(id);
                    ord.setNum(VarietiesId);
                    list.add(ord);
                }
            } else {
                continue;
            }
        }
        for (int j = 0; j < list.size(); j++) {

            hyVarietiesRecordService.insertHyVarietiesRecord(list.get(j));
        }

        return toAjax(list.size() + 1);
    }

    /**
     * ?????????????????????
     *
     * @param request
     * @param response
     * @param hyByre
     * @throws Exception
     */
    @RequestMapping(value = "infoSave.do", method = RequestMethod.POST)
    public void infoSave(HttpServletRequest request, HttpServletResponse response, HyByre hyByre, HyVarieties hyVarieties) throws Exception {

        List<HyByre> list1 = hyByreService.selectHyByreList(hyByre);
        List<HyVarieties> list2 = hyVarietiesService.selectHyVarietiesList(hyVarieties);


        JSONObject json = new JSONObject();
        int isTrue = 0;
        if (list1.size() == 0) {
            isTrue = 1;
        } else {
            isTrue = 2;
            json.put("HyByre", list1);
            json.put("HyVarieties", list2);
        }
        json.put("isTrue", isTrue);


        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = null;
        out = response.getWriter();
        out.write(json.toString());
    }


}
