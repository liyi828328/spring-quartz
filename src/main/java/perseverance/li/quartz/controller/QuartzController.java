package perseverance.li.quartz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import perseverance.li.quartz.job.RunJob;
import perseverance.li.quartz.job.ServiceJob;

import java.util.HashMap;
import java.util.Map;

/**
 * ---------------------------------------------------------------
 * Author: LiYi
 * Email: yi.li@yulore.com
 * Create: 2020-11-20 14:12
 * ---------------------------------------------------------------
 * Describe:
 * ---------------------------------------------------------------
 * Changes:
 * ---------------------------------------------------------------
 * 2020-11-20 14:12 : Create by LiYi
 * ---------------------------------------------------------------
 */
@RestController
public class QuartzController {

    @Autowired
    private ServiceJob serviceJob;

    @GetMapping(value = "/start")
    public String start() {
        serviceJob.start();
        return "ok...";
    }

    @GetMapping(value = "/add1")
    public String addJob1() {
        Map<String, Object> jobData = new HashMap<>();
        jobData.put("name", "perseverance.li");
        jobData.put("age", 11);
        jobData.put("birth", "1989/09/28");
        serviceJob.addJob(RunJob.class, "job-1-1", "job-group-1", "0/5 * * * * ? ", jobData);
        return "ok";
    }

    @GetMapping(value = "/add2")
    public String addJob2() {
        Map<String, Object> jobData = new HashMap<>();
        jobData.put("name", "水电费");
        jobData.put("price", 123);
        jobData.put("birth", "1989/09/28");
        serviceJob.addJob(RunJob.class, "job-1-2", "job-group-1", "0/10 * * * * ? ", jobData);
        return "ok";
    }

    @GetMapping(value = "/add3")
    public String addJob3() {
        Map<String, Object> jobData = new HashMap<>();
        jobData.put("name", "是的噶十多个");
        jobData.put("price", 2344124);
        jobData.put("birth", "1989/09/28");
        serviceJob.addJob(RunJob.class, "job-2-3", "job-group-2", "0/15 * * * * ? ", jobData);
        return "ok";
    }

}
