package com.min.section04.override;

import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        SuperClass subClass = new SuperClass();

        try {
            subClass.method();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
