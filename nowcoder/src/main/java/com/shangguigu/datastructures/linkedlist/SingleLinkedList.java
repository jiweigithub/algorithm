package com.shangguigu.datastructures.linkedlist;

import java.util.Stack;

/**
 * 单链表
 */

public class SingleLinkedList {


    public static void main(String[] args) {
        //进行测试
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(3, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(5, "吴用", "智多星");
        HeroNode heroNode4 = new HeroNode(7, "林冲", "豹子头");

        HeroNode heroNode5 = new HeroNode(2, "花荣", "小李广");
        HeroNode heroNode6 = new HeroNode(4, "武松", "行者");
        HeroNode heroNode7 = new HeroNode(6, "鲁智深", "花和尚");
        HeroNode heroNode8 = new HeroNode(8, "李逵", "黑旋风");

        //创建链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        SingleLinkedList singleLinkedList2 = new SingleLinkedList();

        //头插加入
//        singleLinkedList.headAdd(heroNode1);
//        singleLinkedList.headAdd(heroNode2);
//        singleLinkedList.headAdd(heroNode3);
//        singleLinkedList.headAdd(heroNode4);

        //尾插加入
//        singleLinkedList.tailAdd(heroNode1);
//        singleLinkedList.tailAdd(heroNode2);
//        singleLinkedList.tailAdd(heroNode4);
//        singleLinkedList.tailAdd(heroNode3);

        //加入按照编号排序
        singleLinkedList.addAndOrder(heroNode1);
        singleLinkedList.addAndOrder(heroNode4);
        singleLinkedList.addAndOrder(heroNode2);
        singleLinkedList.addAndOrder(heroNode3);

        singleLinkedList2.addAndOrder(heroNode5);
        singleLinkedList2.addAndOrder(heroNode8);
        singleLinkedList2.addAndOrder(heroNode6);
        singleLinkedList2.addAndOrder(heroNode7);


        //显示
        /*singleLinkedList.list();

        //测试修改节点的代码
        HeroNode heroNode = new HeroNode(2, "小卢", "玉麒麟~~~");

        singleLinkedList.update(heroNode);

        System.out.println("修改后~~~");


        //显示
        singleLinkedList.list();

        //测试删除节点的代码
        HeroNode delNode = new HeroNode(2, "小卢", "玉麒麟~~~");

        singleLinkedList.delete(delNode);

        System.out.println("删除后~~~");

        singleLinkedList.list();

        System.out.println("有效的节点个数： " + getLength(singleLinkedList.getHead()));

        HeroNode lastIndexNode = findLastIndexNode(singleLinkedList.getHead(), 2);

        System.out.println(lastIndexNode);*/

        HeroNode head = new HeroNode(0, "", "");

        merge(head, singleLinkedList.getHead(), singleLinkedList2.getHead());

        System.out.println(head);

        System.out.println("原链表的情况~~~");
        singleLinkedList.list();
        reverse(singleLinkedList.getHead());
        System.out.println("反转链表的情况~~~");
        singleLinkedList.list();
        System.out.println("逆序打印链表~~~");
        reversePrint(singleLinkedList.getHead());
    }

    /**
     * 获取单链表的节点个数（如果是带头节点的链表,需要不统计头节点）
     *
     * @param head 链表的头节点
     * @return 返回有效节点的个数
     */
    public static int getLength(HeroNode head) {
        if (head.next == null) {
            //链表为空，返回0
            return 0;
        }
        int length = 0;
        //定义一个辅助变量
        HeroNode current = head.next;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    /**
     * 查找单链表中的倒数第K个节点
     *
     * @param head  头节点
     * @param index 倒数第几个节点
     * @return heroNode
     * <p>
     * 先把链表从头到位遍历，得到链表的总的长度getLength
     * 得到size后，从链表的第一个开始遍历，遍历（size-index）个
     * 如果找到了返回该节点，否则返回空
     */
    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        //判断，如果链表为空，返回空
        if (head.next == null) {
            return null;
        }
        //获取链表长度
        int length = getLength(head);
        //遍历到length-index位置
        //先做index校验
        if (index <= 0 || index > length) {
            return null;
        }
        HeroNode current = head.next;
        for (int i = 0; i < length - index; i++) {
            current = current.next;
        }
        return current;
    }

    /**
     * 单链表反转
     *
     * @param head
     * @return
     */
    public static void reverse(HeroNode head) {
        //如果当前链表为空，或者只有一个节点，无需反转，直接返回
        if (head.next == null || head.next.next == null) {
            return;
        }
        //定义一个辅助变量，帮助我们遍历原有的链表
        HeroNode current = head.next;
        //定义一个辅助变量，指向当前节点的下一个节点
        HeroNode next = null;
        //定义一个临时头节点
        HeroNode reverseHead = new HeroNode(0, "", "");
        //遍历原链表，每遍历一个节点，就将其取出，并放在新的链表reverseHead的最前端
        while (current != null) {
            //保存当前节点的下一个节点
            next = current.next;
            //将current的下一个节点指向新的头节点的最前端
            current.next = reverseHead.next;
            //将reverseHead的下一个节点指向current
            reverseHead.next = current;
            //current后移
            current = next;
        }
        //将head.next指向reverseHead.next,实现单链表的反转
        head.next = reverseHead.next;
    }

    public static void merge(HeroNode head, HeroNode head1, HeroNode head2) {
        HeroNode current = head1.next;
        HeroNode next = null;
        while (current != null) {
            next = current.next;
            current.next = null;
            addAndOrder(head, current);
            current = next;
        }
        current = head2.next;
        while (current != null) {
            next = current.next;
            current.next = null;
            addAndOrder(head, current);
            current = next;
        }
    }

    public static void addAndOrder(HeroNode head, HeroNode heroNode) {
        //因为头节点不能动,因此通过一个辅助变量来帮助找到添加的位置
        //因为单链表，因此我们找的temp，是位于添加位置的前一个节点，否则插入不了
        HeroNode temp = head;
        //标识添加的编号是否存在,默认为false
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                //说明temp已经在链表的最后
                break;
            }
            if (temp.next.no > heroNode.no) {
                //位置找到,在temp后插入
                break;
                //编号存在
            } else if (temp.next.no == heroNode.no) {
                //编号存在
                flag = true;
                break;
            }
            //后移，遍历当前链表
            temp = temp.next;
        }
        //判断flag的值
        if (flag) {
            System.out.printf("准备插入的英雄的编号 %d 已经存在了，不能加入\n", heroNode.no);
        } else {
            //插入到链表中，temp的后面
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    /**
     * 逆序打印链表中的各个节点
     * 利用栈的先入后出的特点
     *
     * @param head
     */
    public static void reversePrint(HeroNode head) {
        if (head.next == null) {
            //空链表无法打印
            return;
        }
        //创建一个栈，将各个节点压入栈中
        Stack<HeroNode> heroNodeStack = new Stack<>();
        HeroNode current = head.next;
        //将链表的所有节点压入栈中
        while (current != null) {
            //压栈
            heroNodeStack.push(current);
            //节点后移
            current = current.next;
        }
        //将栈中的节点进行打印
        while (heroNodeStack.size() > 0) {
            System.out.println(heroNodeStack.pop());
        }
    }


    /**
     * 初始化头节点
     */
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    public void setHead(HeroNode head) {
        this.head = head;
    }

    /**
     * 向链表中添加节点(头插)
     *
     * @param heroNode
     */
    public void headAdd(HeroNode heroNode) {
        //将要添加节点的next域指向头节点的next域
        heroNode.next = head.next;
        //将头节点的next域指向新添加的节点
        head.next = heroNode;
    }

    /**
     * 向链表中添加节点（尾插）
     *
     * @param heroNode 英雄节点
     */
    public void tailAdd(HeroNode heroNode) {
        //当不考虑编号的顺序时
        //1.找到当前链表的最后节点
        //2.将最后这个节点的next域指向新的节点
        //3.因为head节点不能动，因此我们需要一个辅助变量temp
        HeroNode temp = head;
        //4.遍历链表，找到最后一个几点
        while (true) {
            //找到链表的最后一个节点
            if (temp.next == null) {
                break;
            }
            //如果没有找到最后一个节点，将temp后移
            temp = temp.next;
        }
        //当循环结束时，temp就指向了链表的最后一个节点
        temp.next = heroNode;
    }

    /**
     * 根据英雄排名，将英雄插入到指定位置
     *
     * @param heroNode
     */
    public void addAndOrder(HeroNode heroNode) {
        //因为头节点不能动,因此通过一个辅助变量来帮助找到添加的位置
        //因为单链表，因此我们找的temp，是位于添加位置的前一个节点，否则插入不了
        HeroNode temp = head;
        //标识添加的编号是否存在,默认为false
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                //说明temp已经在链表的最后
                break;
            }
            if (temp.next.no > heroNode.no) {
                //位置找到,在temp后插入
                break;
                //编号存在
            } else if (temp.next.no == heroNode.no) {
                //编号存在
                flag = true;
                break;
            }
            //后移，遍历当前链表
            temp = temp.next;
        }
        //判断flag的值
        if (flag) {
            System.out.printf("准备插入的英雄的编号 %d 已经存在了，不能加入\n", heroNode.no);
        } else {
            //插入到链表中，temp的后面
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    /**
     * 修改节点的信息，根据no编号来修改
     *
     * @param heroNode
     */
    public void update(HeroNode heroNode) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点，根据no编号；需要一个辅助变量
        HeroNode temp = head.next;
        //表示是否找到改节点
        boolean flag = false;
        while (true) {
            if (temp == null) {
                //表示链表已经遍历结束
                break;
            }
            if (temp.no == heroNode.no) {
                //找到了需要修改的节点
                flag = true;
                break;
            }
            //temp后移
            temp = temp.next;
        }
        //根据flag判断是否找到要修改的节点
        if (flag) {
            temp.name = heroNode.name;
            temp.nickName = heroNode.nickName;
        } else {
            System.out.printf("没有找到编号为 %d 的节点，不能修改\n", heroNode.no);
        }
    }

    /**
     * 删除节点
     *
     * @param heroNode
     */
    public void delete(HeroNode heroNode) {
        if (head.next == null) {
            System.out.println("链表为空，无法删除");
            return;
        }
        //找到需要删除的节点，需要定义一个辅助变量
        HeroNode temp = head;
        //标识是否找到需要删除的节点
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                //链表遍历结束
                break;
            }
            if (temp.next.no == heroNode.no) {
                flag = true;
                break;
            }
            //temp后移
            temp = temp.next;
        }
        //判断flag的值
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.printf("没有找到编号为 %d 的英雄，无法删除\n", heroNode.no);
        }
    }


    /**
     * 遍历链表并显示链表内容
     */
    public void list() {
        //先判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点不能动,因此需要一个辅助变量来遍历
        HeroNode temp = head.next;
        while (true) {
            //判断是否到链表最后一个节点
            if (temp == null) {
                break;
            }
            //如果不为空，输出节点信息
            System.out.println(temp);
            //将temp后移
            temp = temp.next;
        }
    }
}

class HeroNode {
    /**
     * 编号
     */
    public int no;
    /**
     * 名称
     */
    public String name;
    /**
     * 昵称
     */
    public String nickName;
    /**
     * 指向下一个节点
     */
    public HeroNode next;

    /**
     * 构造器
     *
     * @param no       编号
     * @param name     名称
     * @param nickName 昵称
     */
    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }


    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}


