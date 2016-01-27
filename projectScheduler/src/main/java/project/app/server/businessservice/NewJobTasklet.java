package project.app.server.businessservice;
import org.quartz.Job;
import org.springframework.stereotype.Component;
import org.quartz.DisallowConcurrentExecution;
import java.lang.Override;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import java.util.Calendar;

@Component("NewJobTasklet")
@DisallowConcurrentExecution
public class NewJobTasklet implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        try {
            org.springframework.context.ApplicationContext springContext = org.springframework.web.context.support.WebApplicationContextUtils.getWebApplicationContext(org.springframework.web.context.ContextLoaderListener.getCurrentWebApplicationContext().getServletContext());
            com.athena.config.appsetUp.model.AppConfiguration appConfiguration = (com.athena.config.appsetUp.model.AppConfiguration) springContext.getBean("appConfig");
            project.app.util.BatchConnection connection = new project.app.util.BatchConnection();
            String targetURL = appConfiguration.getSchedulerConfig().getSchedulerUrl() + "NewServiceWS/newMethod";
            String urlParameters = "{\"testName\":\"puja\"}";
            connection.closeConnection(connection.getResponse(connection.sendPayLoad(connection.openConnection(targetURL, urlParameters, "POST"), urlParameters)));
        } catch (java.io.IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
