package utilities;

import lombok.SneakyThrows;

public class Wait {

    @SneakyThrows
    public static void forSeconds(int seconds){
        Thread.sleep(seconds * 1000L);
    }
}
