package com.onyx.springbootdemo.vo;

import lombok.Builder;

public class Test {



    private static class User1{
        private int id;
        private String name;

        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }



    //@Builder  注解
    @Builder
    private static class User2{
        private int id;
        private String name;

    }

}


