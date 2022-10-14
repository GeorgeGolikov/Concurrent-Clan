import service.TaskService;
import service.UserAddGoldService;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 100; ++i) {
            Thread thread = new Thread(() -> {
                TaskService taskService = new TaskService();
                UserAddGoldService userAddGoldService = new UserAddGoldService();
                long id = Thread.currentThread().getId();
                taskService.completeTask(id % 5, id);
                userAddGoldService.addGoldToClan(id, id % 5, 100);
            });
            thread.start();
        }
    }
}
