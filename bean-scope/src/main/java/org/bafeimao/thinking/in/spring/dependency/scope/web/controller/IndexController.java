package org.bafeimao.thinking.in.spring.dependency.scope.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @projectName: think-in-spring
 * @package: org.bafeimao.thinking.in.spring.dependency.scope.controller
 * @className: IndexController
 * @author: ycd20
 * @description: TODO
 * @date: 2023/2/23 22:46
 * @version: 1.0
 */

@Controller
public class IndexController {

    @GetMapping("/index.html")
    public String index() {
        return "index";
    }
}
