package com.multipolar.bootcamp.product;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class productController {
    @GetMapping("/product")
    public ResponseEntity<List<product>> products(){
        List<product> todoList = List.of(
                new product(1,"Ayam"),
                new product(2,"Tahu"),
                new product(3,"Tempe")
        );
        return ResponseEntity.ok(todoList);
    }
}
