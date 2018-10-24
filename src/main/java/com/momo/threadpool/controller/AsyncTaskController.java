package com.momo.threadpool.controller;

import com.momo.threadpool.service.AsyncService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/async")
public class AsyncTaskController {

    @Autowired
    private AsyncService asyncService;

    @RequestMapping("/execute")
    public String execute() {
        asyncService.execute();
        return "finish";
    }

    @RequestMapping("/execute/returnValue")
    public String executeReturnValue() throws Exception {
        return asyncService.executeReturnValue().get();
    }
}
