package com.min.section06.singleton;

public class LazySingleton {
    private static LazySingleton lazy;

    private LazySingleton() {
    }

    public static LazySingleton getInstance() {
        // 처음 코드가 실행되면 null 이기 때문에
        if (lazy == null) {
            lazy = new LazySingleton();
        }

        return lazy;
    }
}
