package javabasic.topN;

import java.util.PriorityQueue;

class Student implements Comparable<Student> {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.score, other.score); // 升序
    }

    @Override
    public String toString() {
        return name + "(" + score + ")";
    }
}

public class TopKStudents {
    public static void main(String[] args) {
        Student[] students = {
            new Student("Alice", 85),
            new Student("Bob", 92),
            new Student("Charlie", 78),
            new Student("David", 95),
            new Student("Eve", 88)
        };
        
        int k = 2;
        
        // 创建小顶堆获取分数最高的K名学生
        PriorityQueue<Student> minHeap = new PriorityQueue<>(k);
        
        for (Student s : students) {
            if (minHeap.size() < k) {
                minHeap.offer(s);
            } else if (s.getScore() > minHeap.peek().getScore()) {
                minHeap.poll();
                minHeap.offer(s);
            }
        }
        
        // 输出结果（按分数降序）
        System.out.println("分数最高的" + k + "名学生：");
        System.out.println(minHeap);
        minHeap.stream()
               .sorted((a, b) -> b.getScore() - a.getScore())
               .forEach(System.out::println);
    }
}