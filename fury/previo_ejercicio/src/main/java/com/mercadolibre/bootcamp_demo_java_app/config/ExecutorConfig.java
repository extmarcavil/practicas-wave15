package com.mercadolibre.bootcamp_demo_java_app.config;

import com.mercadolibre.threading.executor.MeliExecutors;
import java.util.concurrent.ExecutorService;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.aop.interceptor.SimpleAsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

@Configuration
@EnableAsync
@EnableScheduling
public class ExecutorConfig implements AsyncConfigurer, SchedulingConfigurer {

	public static final String ASYNC_EXECUTOR = "asyncExecutor";

	@Value("${async.executor.pool-size:16}")
	private int asyncPoolSize;

	@Value("${async.executor.prefix:async-}")
	private String asyncPoolPrefix;

	@Value("${async.executor.await-termination:60}")
	private int asyncPoolAwaitTermination;

	@Value("${scheduler.executor.pool-size:4}")
	private int schedulerPoolSize;

	@Value("${scheduler.executor.prefix:job-scheduler-}")
	private String schedulerPrefix;

	@Override
	@Bean(name = ASYNC_EXECUTOR, destroyMethod = "shutdown")
	public ExecutorService getAsyncExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setThreadNamePrefix(this.asyncPoolPrefix);
		executor.setCorePoolSize(this.asyncPoolSize);
		executor.setMaxPoolSize(this.asyncPoolSize);
		executor.setAwaitTerminationSeconds(this.asyncPoolAwaitTermination);
		executor.initialize();
		return MeliExecutors.trace(executor.getThreadPoolExecutor());
	}

	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		return new SimpleAsyncUncaughtExceptionHandler();
	}

	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
		scheduler.setPoolSize(this.schedulerPoolSize);
		scheduler.setThreadNamePrefix(this.schedulerPrefix);
		scheduler.setWaitForTasksToCompleteOnShutdown(true);
		scheduler.initialize();
		taskRegistrar.setScheduler(scheduler);
	}
}
