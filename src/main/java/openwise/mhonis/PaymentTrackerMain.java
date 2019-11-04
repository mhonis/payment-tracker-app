package openwise.mhonis;

/**
 * Payment Tracker main class
 */
public class PaymentTrackerMain {

	public static void main(String[] args) {
		try {
			init();
		} finally {
			shutdown();
		}
	}

	private static void init() {
		CurrencyListingScheduler.getInstance().init();
		ConsoleInputProcessor.getInstance().init();
	}

	private static void shutdown() {
		CurrencyListingScheduler.getInstance().shutdown();
		System.exit(1);
	}
}
