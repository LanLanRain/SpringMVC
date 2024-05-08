package com.rainsoul.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {

    //@RequestMapping("/product/detail")
    @RequestMapping("/detail")
    public String productDetail(){
        return "product_detail";
    }

}