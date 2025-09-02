package javaStudy;

public class Practice1 {
    public class Car {
        private String name;
        private String type;

        //method
        public void printCarInfo() {
            System.out.println("Name: " + name);
            System.out.println("Type: " + type);
        }

        public void move() {
            System.out.println("이동");
        }

        public void brake() {
            System.out.println("정지");
        }

    }
}
