// package com.example.off2.controller;
 
// import com.example.off2.model.Title;
// import com.example.off2.repository.TitleRepository;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;
 
// import java.util.List;
// @RestController
// @RequestMapping("/api")
// public class TitleController {

//     @Autowired
//     private TitleRepository titleRepository;
 
//     @GetMapping("/titles")
//     public List<Title> getAllTitles() {
//         return titleRepository.findAll();
//     }
// }

package com.example.off2.controller;

import com.example.off2.model.Title;
import com.example.off2.repository.TitleRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class TitleController {

    private final TitleRepository titleRepository;

    public TitleController(TitleRepository titleRepository) {
        this.titleRepository = titleRepository;
    }

    @GetMapping("/titles")
    public List<Title> getAllTitles() {
        return titleRepository.findAll();
    }
}
