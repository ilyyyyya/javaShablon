package practica4;

public class Main {
    public static void main(String[] args) {
        MyExecutorService executorService = new MyExecutorService(2);
        executorService.execute(() -> {
            try{
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Потом это");
        });
        
        executorService.execute(() -> System.out.println("Сначала это"));
        executorService.shutdown();
    }
}
