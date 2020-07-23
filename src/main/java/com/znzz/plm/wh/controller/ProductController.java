package com.znzz.plm.wh.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.znzz.plm.wh.config.R;
import com.znzz.plm.wh.entity.ConditionQuery.MaterialQuery;
import com.znzz.plm.wh.entity.ConditionQuery.ProductQuery;
import com.znzz.plm.wh.entity.Dto.MaterialAndProduct;
import com.znzz.plm.wh.entity.Material;
import com.znzz.plm.wh.entity.Product;
import com.znzz.plm.wh.entity.ProductMaterial;
import com.znzz.plm.wh.service.MaterialService;
import com.znzz.plm.wh.service.ProductMaterialService;
import com.znzz.plm.wh.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 成品表 前端控制器
 * </p>
 *
 * @author wh
 * @since 2020-05-25
 */
@RestController
@CrossOrigin
@RequestMapping("/plm/product")
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    ProductMaterialService productMaterialService;
    @Autowired
    MaterialService materialService;


    @PostMapping("/condition/{page}/{size}")
    public R getMaterialByCondition(@PathVariable Integer page,
                                    @PathVariable Integer size,
                                    @RequestBody(required = false) ProductQuery productQuery){
        Page<Product> productPage = new Page<>(page,size);

        IPage<Product> page1= productService.selectCondition(productPage,productQuery);
        long total = page1.getTotal();
        List<Product> records = page1.getRecords();
        return R.ok().data("total",total).data("list",records);
    }


    @PostMapping("/addProduct")
    public R addProduct(@RequestBody Product product){
        boolean save = productService.save(product);
        if(save){
            return R.ok();
        }
        return R.error();
    }

    @GetMapping("/getProductInfoById/{id}")
    public R getProductInfoById(@PathVariable String id){
        Product product = productService.getById(id);
        return R.ok().data("data",product);
    }

    @PostMapping("/updateProductById")
    public R updateProduct(@RequestBody  Product product){
        boolean b = productService.updateById(product);
        if(b){
            return R.ok();
        }
        return R.error();
    }

    @DeleteMapping("/deleteById/{id}")
    public  R delete(@PathVariable String id){
        boolean b = productService.removeById(id);//删除成品表信息
        QueryWrapper<ProductMaterial> queryWrapper = new QueryWrapper<>();//删除成品对应的原料信息
        queryWrapper.eq("product_id",id);
        boolean remove = productMaterialService.remove(queryWrapper);
        if(b && remove){
            return R.ok();
        }
        return R.error();
    }
    //添加配方
    @PostMapping("/addMaterialOfProduct")
    public R addMaterialOfP(@RequestBody ProductMaterial productMaterial){
        boolean save = productMaterialService.save(productMaterial);
        if(save){
            return R.ok();
        }
        return R.error();
    }

    @PostMapping("/updateMaterialOfProduct")
    public R updateMaterialOfProduct(@RequestBody ProductMaterial productMaterial){
        boolean b = productMaterialService.updateById(productMaterial);
        if(b){
            return R.ok();
        }
        return R.error();
    }

    //根据产品和原料id获得配方信息
    @GetMapping("/getMP/{mid}/{pid}")
    public  R getMP(@PathVariable String mid,
                    @PathVariable String pid){
        QueryWrapper<ProductMaterial> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("product_id",pid).eq("material_id",mid);
        ProductMaterial productMaterial = productMaterialService.getOne(queryWrapper);
        return  R.ok().data("data",productMaterial);
    }

    //根据产品和原料id删除配方信息
    @DeleteMapping("/delMP/{mid}/{pid}")
    public R deleteMP(@PathVariable String mid,
                      @PathVariable String pid){
        QueryWrapper<ProductMaterial> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("product_id",pid).eq("material_id",mid);
        boolean remove = productMaterialService.remove(queryWrapper);
        if(remove){
            return  R.ok();
        }return R.error();
    }


    //根据产品id获得对应配方
    @GetMapping("/getMPByProductId/{id}")
    public R getMPByProductId(@PathVariable String id){
        QueryWrapper<ProductMaterial> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("product_id",id);
        List<ProductMaterial> list = productMaterialService.list(queryWrapper);
        ArrayList<MaterialAndProduct> materialAndProducts = new ArrayList<>();
        for (ProductMaterial productMaterial : list) {
            MaterialAndProduct materialAndProduct = new MaterialAndProduct();
            BeanUtils.copyProperties(productMaterial,materialAndProduct);
            Material material = materialService.getById(productMaterial.getMaterialId());
            materialAndProduct.setMaterialName(material.getMaterialName());
            materialAndProducts.add(materialAndProduct);
        }
        return R.ok().data("list",materialAndProducts);
    }

}

