package com.fh.mall.tiny.controller;

import com.fh.mall.tiny.common.api.CommonResult;
import com.fh.mall.tiny.service.PmsBrandService;
import org.apache.catalina.LifecycleState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 品牌管理Controller
 */
@Controller
@RequestMapping("/brand")
public class PmgBrandController {

/*
    @Autowired
    private PmsBrandService demoService;
    private static final Logger LOGGER = LoggerFactory.getLogger(PmgBrandController.class);

    @RequestMapping(value = "listAll",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<LifecycleState<PmsBrand>> getBrandList(){
        return CommonResult.success(demoService.listAllBrand());
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult createBrand(@RequestBody PmsBrand pmgBrand){}
*/

}
