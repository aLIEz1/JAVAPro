package Test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<People> queue = new PriorityQueue<People>(11,
                new Comparator<People>() {
                    public int compare(People p1, People p2) {
                        return p2.age - p1.age;
                    }
                });

        for (int i = 1; i <= 10; i++) {
            queue.add(new People("张" + i, (new Random().nextInt(100))));
        }
        while (!queue.isEmpty()) {
            System.out.println(queue.poll().toString());
        }
    }
}

class People {
    private String name;
    int age;

    People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "姓名：" + name + " 年龄：" + age;
    }
}
