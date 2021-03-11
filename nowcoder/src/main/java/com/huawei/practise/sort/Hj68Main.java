package com.huawei.practise.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * 题目描述
 * 查找和排序
 * <p>
 * 题目：输入任意（用户，成绩）序列，可以获得成绩从高到低或从低到高的排列,相同成绩
 * 都按先录入排列在前的规则处理。
 * <p>
 * 例示：
 * jack      70
 * peter     96
 * Tom       70
 * smith     67
 * <p>
 * 从高到低  成绩
 * peter     96
 * jack      70
 * Tom       70
 * smith     67
 * <p>
 * 从低到高
 * <p>
 * smith     67
 * <p>
 * jack      70
 * <p>
 * Tom       70
 * peter     96
 * <p>
 * 注：0代表从高到低，1代表从低到高
 * <p>
 * 本题含有多组输入数据！
 * 输入描述:
 * 输入多行，先输入要排序的人的个数，然后分别输入他们的名字和成绩，以一个空格隔开
 * <p>
 * 输出描述:
 * 按照指定方式输出名字和成绩，名字和成绩之间以一个空格隔开
 * <p>
 * 示例1
 * 输入
 * 3
 * 0
 * fang 90
 * yang 50
 * ning 70
 * 输出
 * fang 90
 * ning 70
 * yang 50
 */
public class Hj68Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String countInput = sc.nextLine();
            int count = Integer.parseInt(countInput);
            String sortInput = sc.nextLine();
            int sort = Integer.parseInt(sortInput);
            List<Student> studentList = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                String studentInput = sc.nextLine();
                String[] split = studentInput.split(" ");
                String name = split[0];
                int grade = Integer.parseInt(split[1]);
                Student student = new Student(name, grade);
                studentList.add(student);
            }
            if (sort == 0) {
                studentList.sort((s1, s2) -> s2.getGrade() - s1.getGrade());
            }
            if (sort == 1) {
                studentList.sort(Comparator.comparingInt(Student::getGrade));
            }
            studentList.forEach(student -> {
                System.out.println(student.getName()+" "+student.getGrade());
            });
        }
    }
}

class Student {

    String name;

    int grade;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }
}
