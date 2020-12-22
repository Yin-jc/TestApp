package com.example.appl;

public class TestEscapeAnalysis {
    static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void alloc() {
        Point point = new Point(1, 2);
        System.out.println("point.x = " + point.x + "; point y = " + point.y);
    }

    public static void main(String[] args) {
        alloc();
    }
}
