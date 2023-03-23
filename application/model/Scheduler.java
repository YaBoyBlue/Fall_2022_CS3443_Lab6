package application.model;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public abstract class Scheduler {
	
	private long schedule;
	
	ScheduledExecutorService scheduleExecutorService = Executors.newSingleThreadScheduledExecutor();
	
	public Scheduler(long schedule) {
		this.schedule = schedule;
	}
	
	public void start() {
		this.scheduleExecutorService.scheduleWithFixedDelay(this::onSchedule, this.schedule * 1000, this.schedule * 1000, TimeUnit.MILLISECONDS);
	}
	
	public void stop() {
		this.scheduleExecutorService.shutdown();
	}
	
	protected abstract void onSchedule();
}
