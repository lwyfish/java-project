//package javabasic;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class AddAllExceptionExample {
//    public static void main(String[] args) {
//        // ����һ����ʼ������С��ArrayList
//        List<Integer> list = new ArrayList<>();
//
//        // ���һЩԪ��
//        list.add(1);
//        list.add(2);
//
//        // ����һ���ϴ�ļ����������
//        List<Integer> largeList = new ArrayList<>();
//        for (int i = 0; i < 10000000; i++) {
//            largeList.add(i);
//        }
//
//        // ������Ӵ���Ԫ�أ����ܵ�����������
//        list.addAll(largeList);  // �����׳�ArrayIndexOutOfBoundsException
////        System.out.println(list);
//    }
//}