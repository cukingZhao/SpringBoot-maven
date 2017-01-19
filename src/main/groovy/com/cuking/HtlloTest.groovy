package com.cuking

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by cuking on 2017/1/4.
 */
@RestController
public class HtlloTest {

    @RequestMapping("/a")
    def sayhello() {
        return  "Hello World"
    }
}
