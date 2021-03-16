package com.shangguigu.practise;

/**
 * 单向链表练习（不带头节点）
 */
public class SingleLinedList {

    public static void main(String[] args) {
        CustomerNode customerNode1 = new CustomerNode(1, "张三", "法外狂徒");
        CustomerNode customerNode2 = new CustomerNode(2, "韩梅梅", "大众同学");
        CustomerNode customerNode3 = new CustomerNode(3, "李雷", "英语科代表");
        CustomerNode customerNode4 = new CustomerNode(4, "王二麻子", "麻子脸");

        SingleLinedList singleLinedList = new SingleLinedList();
        SingleLinedList singleLinedList2 = new SingleLinedList();
//        singleLinedList.headAdd(customerNode1);
//        singleLinedList.headAdd(customerNode2);
//        singleLinedList.headAdd(customerNode3);
//        singleLinedList.headAdd(customerNode4);
//        singleLinedList.list();
//        singleLinedList2.tailAdd(customerNode1);
//        singleLinedList2.tailAdd(customerNode2);
//        singleLinedList2.tailAdd(customerNode3);
//        singleLinedList2.tailAdd(customerNode4);
        singleLinedList2.addAndOrder(customerNode2);
        singleLinedList2.addAndOrder(customerNode4);
        singleLinedList2.addAndOrder(customerNode1);
        singleLinedList2.addAndOrder(customerNode3);
        singleLinedList2.addAndOrder(customerNode3);
        singleLinedList2.list();
        CustomerNode customerNode = new CustomerNode(1, "王大麻子", "麻子脸");
        singleLinedList2.update(customerNode);
        singleLinedList2.list();
        singleLinedList2.delete(customerNode);
        singleLinedList2.list();
    }

    /**
     * 定义一个空的节点作为头
     */
    private CustomerNode head;

    /**
     * 头插法
     *
     * @param customerNode
     */
    public void headAdd(CustomerNode customerNode) {
        customerNode.next = head;
        head = customerNode;
    }

    /**
     * 尾插法
     *
     * @param customerNode
     */
    public void tailAdd(CustomerNode customerNode) {
        if (isEmpty()) {
            this.head = customerNode;
            return;
        }
        CustomerNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = customerNode;
    }

    /**
     * 插入并按照编号升序排列
     *
     * @param customerNode
     */
    public void addAndOrder(CustomerNode customerNode) {
        if (isEmpty()) {
            this.head = customerNode;
            return;
        }
        if (this.head.no > customerNode.no) {
            customerNode.next = head;
            head = customerNode;
            return;
        }
        boolean flag = false;
        CustomerNode current = head;
        while (true) {
            if (current.next == null) {
                //说明current已经在链表的最后
                break;
            }
            if (current.next.no > customerNode.no) {
                //位置找到,在current后插入
                break;
                //编号存在
            } else if (current.next.no == customerNode.no) {
                //编号存在
                flag = true;
                break;
            }
            //后移，遍历当前链表
            current = current.next;
        }
        //判断flag的值
        if (flag) {
            System.out.printf("准备插入的客户编号 %d 已经存在了，不能加入\n", customerNode.no);
        } else {
            //插入到链表中，current的后面
            customerNode.next = current.next;
            current.next = customerNode;
        }
    }

    /**
     * 修改
     *
     * @param customerNode
     */
    public void update(CustomerNode customerNode) {
        if (isEmpty()) {
            System.out.println("链表为空，无法更新");
        }
        boolean flag = false;
        CustomerNode current = this.head;
        while (current != null) {
            if (current.no == customerNode.no) {
                flag = true;
                break;
            }
            current = current.next;
        }
        if (flag) {
            current.name = customerNode.name;
            current.nickname = customerNode.nickname;
        } else {
            System.out.printf("客户编号 %d 不存在\n", customerNode.no);
        }
    }

    /**
     * 删除
     */
    public void delete(CustomerNode customerNode) {
        if (isEmpty()) {
            System.out.println("链表为空，无法删除");
        }
        CustomerNode current = head;
        if (head.no == customerNode.no) {
            head = head.next;
            return;
        }
        boolean flag = false;
        while (current.next != null) {
            if (current.next.no == customerNode.no) {
                flag = true;
                break;
            }
            current = current.next;
        }
        if (flag) {
            current.next = current.next.next;
        } else {
            System.out.printf("客户编号 %d 不存在\n", customerNode.no);
        }
    }

    /**
     * 判断链表是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * 显示链表中的所有节点
     */
    public void list() {
        if (isEmpty()) {
            System.out.println("链表为空，无法显示");
        }
        CustomerNode current = head;
        while (current != null) {
            System.out.println(current.toString());
            current = current.next;
        }
    }
}

class CustomerNode {
    /**
     * 客户编号
     */
    int no;
    /**
     * 客户名称
     */
    String name;
    /**
     * 客户昵称
     */
    String nickname;
    /**
     * next域，指向下一个客户节点
     */
    CustomerNode next;

    public CustomerNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public CustomerNode getNext() {
        return next;
    }

    public void setNext(CustomerNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "CustomerNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
