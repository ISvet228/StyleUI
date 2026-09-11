package StyleUI;

import javax.swing.*;
import java.util.LinkedHashSet;
import java.util.Set;

final class AnimationManager {
    private static final Set<Runnable> tasks = new LinkedHashSet<>();
    private static final Timer timer = new Timer(16, e -> tick());
    private static long lastTickNanos = System.nanoTime();
    private static double glassPhase;

    static {
        timer.setCoalesce(true);
        timer.setRepeats(true);
    }

    static void register(Runnable task) {
        if (task == null) return;
        tasks.add(task);
        if (!timer.isRunning()) {
            lastTickNanos = System.nanoTime();
            timer.start();
        }
    }

    static void unregister(Runnable task) {
        if (task == null) return;
        tasks.remove(task);
        if (tasks.isEmpty()) timer.stop();
    }

    static double getGlassPhase() { return glassPhase; }

    private static void tick() {
        if (tasks.isEmpty()) {
            timer.stop();
            return;
        }

        long now = System.nanoTime();
        double delta = Math.clamp((now - lastTickNanos) / 1_000_000_000.0, 0.0, 0.1);
        lastTickNanos = now;

        glassPhase += delta * 0.22;
        if (glassPhase >= 1.0) glassPhase -= Math.floor(glassPhase);

        for (Runnable task : tasks.toArray(Runnable[]::new)) task.run();
    }
}