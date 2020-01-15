package com.fh.mall.tiny.controller;

import com.fh.mall.tiny.common.api.CommonPage;
import com.fh.mall.tiny.mbg.model.PmsBrand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;

/**
 * 实现PmsBrand表中的添加、修改、删除及分页查询接口。
 */
import com.fh.mall.tiny.common.api.CommonResult;
import com.fh.mall.tiny.service.PmsBrandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 品牌管理Controller
 */
//添加上Swagger注解@Api相关
//@Api：用于修饰Controller类，生成Controller相关文档信息
//@ApiOperation：用于修饰Controller类中的方法，生成接口方法相关文档信息
//@ApiParam：用于修饰接口中的参数，生成接口参数相关文档信息
//@ApiModelProperty：用于修饰实体类的属性，当实体类是请求参数或返回结果时，直接生成相关文档信息
@Api(tags = "PmsBrandController",description = "商品品牌管理")
@Controller
@RequestMapping("/brand")
public class PmgBrandController {


    @Autowired
    private PmsBrandService demoService;

    private static final Logger LOGGER = LoggerFactory.getLogger(PmgBrandController.class);

    @ApiOperation("获取所有品牌列表")
    @RequestMapping(value = "listAll",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PmsBrand>> getBrandList(){
        return CommonResult.success(demoService.listAllBrand());
    }

    @ApiOperation("添加品牌")
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult createBrand(@RequestBody PmsBrand pmsBrand){
        CommonResult commonResult;
        int count = demoService.createBrand(pmsBrand);
        if(count == 1){
            commonResult = CommonResult.success(pmsBrand);
            LOGGER.debug("createBrand success:{}",pmsBrand);
        }
        else{
            commonResult = CommonResult.failed("操作失败");
            LOGGER.debug("createBrand failed:{}",pmsBrand);
        }
        return commonResult;
    }

    @ApiOperation("更新指定id品牌信息")
    @RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateBrand(@PathVariable("id") Long id , @RequestBody PmsBrand pmsBrandDto, BindingResult result){
        CommonResult commonResult;
        int count = demoService.updateBrand(id,pmsBrandDto);
        if (count == 1) {
            commonResult = CommonResult.success(pmsBrandDto);
            LOGGER.debug("update success:{}", pmsBrandDto);
        } else {
            commonResult = CommonResult.failed("操作失败");
            LOGGER.debug("updateBrand failed:{}", pmsBrandDto);
        }
        return commonResult;
    }

    @ApiOperation("删除指定id的品牌")
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult deleteBrand(@PathVariable("id") Long id){
        int count = demoService.deleteBrand(id);
        if (count == 1) {
            LOGGER.debug("deleteBrand success:id ={}", id);
            return CommonResult.success(null);
        } else {
            LOGGER.debug("deleteBrand failed:{}", id);
        }
        return CommonResult.failed("操作失败");
    }

    @ApiOperation("分页查询品牌列表")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
   public CommonResult<CommonPage<PmsBrand>> listBrand(@RequestParam(value = "pageNum",defaultValue = "1")
                                                           @ApiParam("页码") Integer pageNum,
                                                       @RequestParam(value = "pageSize",defaultValue = "3")
                                                            @ApiParam("每页数量") Integer pageSize){
        List<PmsBrand> brandList = demoService.listBrand(pageNum,pageSize);
        return CommonResult.success(CommonPage.restPage(brandList));
   }

   @ApiOperation("获取指定id的品牌详情")
   @RequestMapping(value = "/{id}",method = RequestMethod.GET)
   @ResponseBody
   public CommonResult<PmsBrand> brand(@PathVariable("id") Long id){
        return CommonResult.success(demoService.getBrand(id));

   }


}
