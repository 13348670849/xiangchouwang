package cn.enjoy.controller;

import com.enjoy.service.IProductClientService;
import com.enjoy.vo.Product;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/consumer")
public class ConsumerProductController {


    @Resource
    private IProductClientService iProductClientService;

    @RequestMapping("/product/get/{id}")
    public Object getProduct(@PathVariable("id") long id) {
        Product product = iProductClientService.getProduct(id);
        return  product;
    }

    @RequestMapping("/product/list")
    public  Object listProduct() {
        List<Product> list = iProductClientService.listProduct();
        return  list;
    }

    @RequestMapping("/product/add")
    public Object addPorduct(Product product) {
        Boolean result = iProductClientService.addPorduct(product);
        return  result;
    }
}