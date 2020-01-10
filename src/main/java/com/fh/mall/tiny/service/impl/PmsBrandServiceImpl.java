package com.fh.mall.tiny.service.impl;

import com.fh.mall.tiny.mbg.model.PmsBrand;
import com.fh.mall.tiny.service.PmsBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 实现类
 */
@Service
public class PmsBrandServiceImpl implements PmsBrandService {
   /* @Autowired
    private PmsBrandMapper brandMapper;*/
    @Override
    public List<PmsBrand> listAllBrand() {
        return null;
    }

    @Override
    public int createBrand(PmsBrand brand) {
        return 0;
    }

    @Override
    public int updateBrand(Long id, PmsBrand brand) {
        return 0;
    }

    @Override
    public int deleteBrand(Long id) {
        return 0;
    }

    @Override
    public List<PmsBrand> listBrand(int pageNum, int pageSize) {
        return null;
    }

    @Override
    public PmsBrand getBrand(Long id) {
        return null;
    }
}
