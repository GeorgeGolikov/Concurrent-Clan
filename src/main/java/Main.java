import dao.impl.ClanConsumerImpl;
import service.TaskService;
import service.UserAddGoldService;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int threadsNum = 100;
        Thread[] threadPool = new Thread[threadsNum];

        for (int i = 0; i < threadsNum; ++i) {
            Thread thread = new Thread(() -> {
                TaskService taskService = new TaskService();
                UserAddGoldService userAddGoldService = new UserAddGoldService();
                long id = Thread.currentThread().getId();
                taskService.completeTask(id % 5, id);
                userAddGoldService.addGoldToClan(id, id % 5, 100);
            });
            threadPool[i] = thread;
            thread.start();
        }

        Arrays.stream(threadPool).forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("\n\n");
        ClanConsumerImpl.printClansGold();
    }
}
