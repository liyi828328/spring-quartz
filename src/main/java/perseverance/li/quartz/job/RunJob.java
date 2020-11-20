package perseverance.li.quartz.job;

import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Map;

/**
 * ---------------------------------------------------------------
 * Author: LiYi
 * Email: yi.li@yulore.com
 * Create: 2020-11-20 13:52
 * ---------------------------------------------------------------
 * Describe:
 * ---------------------------------------------------------------
 * Changes:
 * ---------------------------------------------------------------
 * 2020-11-20 13:52 : Create by LiYi
 * ---------------------------------------------------------------
 */
public class RunJob extends QuartzJobBean {

    private Logger logger = LoggerFactory.getLogger(RunJob.class);

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDetail jobDetail = jobExecutionContext.getJobDetail();
        JobDataMap jobDataMap = jobDetail.getJobDataMap();
        Trigger trigger = jobExecutionContext.getTrigger();
        logger.info("*** " + jobDetail.getKey().getName() + " >> run job : jobDataMap : " + jobDataMap.toString());
        for (Map.Entry<String, Object> entry : jobDataMap.entrySet()) {
            logger.info("job key : " + entry.getKey() + " value : " + entry.getValue());
        }
    }
}
