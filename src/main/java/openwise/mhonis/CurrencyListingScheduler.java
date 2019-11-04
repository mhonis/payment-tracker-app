package openwise.mhonis;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CurrencyListingScheduler {

	//scheduler period in milliseconds
	private static final long PERIOD = 60000;

	private static CurrencyListingScheduler instance = null;
	private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

	private CurrencyListingScheduler() {
	}

	public static CurrencyListingScheduler getInstance() {
		if (instance == null)
			instance = new CurrencyListingScheduler();
		return instance;
	}

	/**
	 * Starts the scheduler
	 */
	public void init() {
		scheduler.scheduleAtFixedRate(runnable, PERIOD, PERIOD, TimeUnit.MILLISECONDS);
	}

	/**
	 * Terminates the scheduler
	 */
	public void shutdown() {
		scheduler.shutdown();
	}

	/**
	 * Runnable that prints the current list of currencies in memory
	 */
	private static Runnable runnable = new Runnable() {
		public void run() {
			InputProcessor.getInstance().listCurrencies();
		}
	};
}
