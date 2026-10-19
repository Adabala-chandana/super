package day11;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadLocalRequest {
	private static final ThreadLocal<String> REQUEST_ID = new ThreadLocal<>();

	static void runWith(String requestId, Runnable task) {
		try {
			REQUEST_ID.set(requestId);
			task.run();
		} finally {
			REQUEST_ID.remove();
		}
	}

	static String currentRequestId() {
		String requestId = REQUEST_ID.get();
		if (requestId == null) {
			throw new IllegalStateException("No request ID set for the current thread");
		}
		return requestId;
	}

	static <T> Future<T> submit(ExecutorService executor, Callable<T> work) {
		String capturedRequestId = currentRequestId();
		return executor.submit(() -> {
			REQUEST_ID.set(capturedRequestId);
			try {
				return work.call();
			} finally {
				REQUEST_ID.remove();
			}
		});
	}

	public static void main(String[] args) throws Exception {
		ExecutorService pool = Executors.newSingleThreadExecutor();
		try {
			runWith("A", () -> {
				try {
					String result = submit(pool, () -> currentRequestId()).get();
					System.out.println("Request A: " + result);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			});
			runWith("B", () -> {
				try {
					String result = submit(pool, () -> currentRequestId()).get();

					System.out.println("Request B: " + result);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			});
		} finally {
			pool.shutdown();
		}
	}
}
