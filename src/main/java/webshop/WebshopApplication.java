package webshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import webshop.service.ProductService;
import webshop.service.SampleDataService;

@SpringBootApplication
public class WebshopApplication implements CommandLineRunner {
    
    @Autowired
    SampleDataService sampleDataService;
    
    @Autowired
    ProductService productService;

    public static void main(String[] args) {
        SpringApplication.run(WebshopApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //sampleDataService.initSampleData();
//        productService.discountProductsByCategoryName("AAA", 10);
    }

}
