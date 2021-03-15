package com.shangguigu.datastructures.linkedlist;

/**
 * 单向环形链表(约瑟夫环)
 */
public class SingleCircleLinkedList {

    public static void main(String[] args) {
        //测试构建环形链表，和遍历是否正确
        SingleCircleLinkedList singleCircleLinkedList = new SingleCircleLinkedList();
        singleCircleLinkedList.add(5);
        singleCircleLinkedList.list();
        //测试小孩出圈是否正确
        singleCircleLinkedList.printChildNo(2, 2, 5);
    }


    /**
     * 根据用户的输入，计算出小孩出圈的顺序
     *
     * @param startNo  表示从第几个小孩开始数
     * @param countNum 表示数几下
     * @param nums     表示最初有多少小孩在环中
     */
    public void printChildNo(int startNo, int countNum, int nums) {
        //校验
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误，请重新输入");
            return;
        }
        //将first移动到startNo
        for (int j = 0; j < startNo - 1; j++) {
            first = first.getNext();
        }
        //创建一个辅助指针，帮助完成小孩出圈
        ChildNode helper = first;
        while (helper.getNext() != first) {
            //当helper的下一个节点为first，说明helper已经在链表的最后一个节点了
            helper = helper.getNext();
        }
        //当小孩报数时，让first和helper指针同时移动m-1次，然后出圈
        while (helper != first) {
            //说明圈中只有一个节点
            //让first和helper指针同时移动countNum-1次
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //此时first指向的节点就是要出圈的节点
            System.out.printf("小孩 %d 出圈\n", first.getNo());
            //将first指向的小孩出圈
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后留在圈中的小孩编号 %d \n", first.getNo());
    }

    /**
     * 创建first节点，没有编号
     */
    private ChildNode first;

    /**
     * 添加小孩
     *
     * @param num 添加小孩的个数
     */
    public void add(int num) {
        if (num < 1) {
            System.out.println("num 参数非法， num必须大于等于1");
            return;
        }
        //辅助变量，帮助构建环形链表
        ChildNode current = null;
        //使用for循环创建环形链表
        for (int i = 1; i <= num; i++) {
            //根据编号创建小孩节点
            ChildNode childNode = new ChildNode(i);
            if (i == 1) {
                first = childNode;
                //构成环
                first.setNext(childNode);
                current = first;
            } else {
                current.setNext(childNode);
                childNode.setNext(first);
                current = childNode;
            }
        }
    }

    /**
     * 遍历当前环形链表
     */
    public void list() {
        //判断链表是否为空
        if (first == null) {
            System.out.println("链表为空");
            return;
        }
        //因为first不能动，因此使用一个辅助变量完成遍历
        ChildNode current = first;
        //如果current.getNext() == first 循环结束
        while (true) {
            System.out.printf("小孩的编号：%d\n", current.getNo());
            if (current.getNext() == first) {
                break;
            }
            //current后移
            current = current.getNext();
        }
    }

}

class ChildNode {

    /**
     * 编号
     */
    private int no;

    /**
     * 指向下一个小孩
     */
    private ChildNode next;

    public ChildNode(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public ChildNode getNext() {
        return next;
    }

    public void setNext(ChildNode next) {
        this.next = next;
    }
}


