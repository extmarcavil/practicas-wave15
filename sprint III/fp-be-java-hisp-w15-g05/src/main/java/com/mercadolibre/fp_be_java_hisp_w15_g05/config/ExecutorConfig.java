package com.mercadolibre.fp_be_java_hisp_w15_g05.config;

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

/**
 * Represents async instructions configuration.
 * See @{@link EnableAsync} for usage examples.
 * @see EnableAsync
 */
@EnableAsync
@EnableScheduling
@Configuration
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

  /**
   * Initializes async instruction execution using {@link MeliExecutors}.
   * This enables the following features:
   * <ul>
   * <li>Telemetry in New Relic for async instructions.</li>
   * <li>Propagation of traceability.</li>
   * <li>Logger context propagation through MDC.</li>
   * </ul>
   * @return MeliExecutor for async instructions.
   */
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

  /**
   * Creates a {@link SimpleAsyncUncaughtExceptionHandler} to be used
   * when an exception is thrown during an asynchronous method execution
   * with {@code void} return type.
   * @return SimpleAsyncUncaughtExceptionHandler.
   */
  @Override
  public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
    return new SimpleAsyncUncaughtExceptionHandler();
  }

  /**
   * Callback allowing a {@link org.springframework.scheduling.TaskScheduler
   * TaskScheduler} and specific {@link org.springframework.scheduling.config.Task Task}
   * instances to be registered against the given the {@link ScheduledTaskRegistrar}.
   * @param taskRegistrar the registrar to be configured.
   */
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
