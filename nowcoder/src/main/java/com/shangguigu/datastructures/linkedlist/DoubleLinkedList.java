package com.shangguigu.datastructures.linkedlist;

/**
 * 双向链表
 */
public class DoubleLinkedList {


    public static void main(String[] args) {
        //进行测试
        System.out.println("双向链表的测试");
        HeroNode2 heroNode1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 heroNode2 = new HeroNode2(3, "卢俊义", "玉麒麟");
        HeroNode2 heroNode3 = new HeroNode2(5, "吴用", "智多星");
        HeroNode2 heroNode4 = new HeroNode2(7, "林冲", "豹子头");

        HeroNode2 heroNode5 = new HeroNode2(2, "花荣", "小李广");
        HeroNode2 heroNode6 = new HeroNode2(4, "武松", "行者");
        HeroNode2 heroNode7 = new HeroNode2(6, "鲁智深", "花和尚");
        HeroNode2 heroNode8 = new HeroNode2(8, "李逵", "黑旋风");

        //创建一个双向链表对象
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
//        DoubleLinkedList doubleLinkedList2 = new DoubleLinkedList();
//        doubleLinkedList.headAdd(heroNode1);
//        doubleLinkedList.headAdd(heroNode2);
//        doubleLinkedList.headAdd(heroNode3);
//        doubleLinkedList.headAdd(heroNode4);
//
//        doubleLinkedList2.tailAdd(heroNode5);
//        doubleLinkedList2.tailAdd(heroNode6);
//        doubleLinkedList2.tailAdd(heroNode7);
//        doubleLinkedList2.tailAdd(heroNode8);
//
//        System.out.println("头插发双向链表展示");
//        doubleLinkedList.list();
//
//        System.out.println("尾插发双向链表展示");
//        doubleLinkedList2.list();
//
//        HeroNode2 heroNodeUpdate = new HeroNode2(3, "小卢", "玉麒麟");
//        doubleLinkedList.update(heroNodeUpdate);
//        System.out.println("头插发双向链表更新后");
//        doubleLinkedList.list();
//
//        doubleLinkedList.delete(heroNodeUpdate);
//        System.out.println("头插发双向链表删除后");
//        doubleLinkedList.list();

        doubleLinkedList.addAndOrder(heroNode1);
        doubleLinkedList.addAndOrder(heroNode2);
        doubleLinkedList.addAndOrder(heroNode3);
        doubleLinkedList.addAndOrder(heroNode4);
        doubleLinkedList.addAndOrder(heroNode5);
        doubleLinkedList.addAndOrder(heroNode6);
        doubleLinkedList.addAndOrder(heroNode7);
        doubleLinkedList.addAndOrder(heroNode8);

        System.out.println("按顺序插入双向链表展示");
        doubleLinkedList.list();
    }


    /**
     * 初始化头节点
     */
    private HeroNode2 head = new HeroNode2(0, "", "");

    public HeroNode2 getHead() {
        return head;
    }

    public void setHead(HeroNode2 head) {
        this.head = head;
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
        HeroNode2 temp = head.next;
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

    /**
     * 向链表中添加节点(头插)
     *
     * @param heroNode
     */
    public void headAdd(HeroNode2 heroNode) {
        //将要添加节点的next域指向头节点的next域
        heroNode.next = head.next;
        //将新节点的pre指向头节点
        heroNode.pre = head;
        //将头节点的next域的pre域指向新添加的节点
        if (head.next != null) {
            head.next.pre = heroNode;
            //将头节点的next域指向新节点
            head.next = heroNode;
        } else {
            //将头节点的next域指向新节点
            head.next = heroNode;
        }

    }

    /**
     * 向链表中添加节点（尾插）
     *
     * @param heroNode 英雄节点
     */
    public void tailAdd(HeroNode2 heroNode) {
        //当不考虑编号的顺序时
        //1.找到当前链表的最后节点
        //2.将最后这个节点的next域指向新的节点
        //3.因为head节点不能动，因此我们需要一个辅助变量temp
        HeroNode2 temp = head;
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
        heroNode.pre = temp;
    }

    /**
     * 根据英雄排名，将英雄插入到指定位置
     *
     * @param heroNode
     */
    public void addAndOrder(HeroNode2 heroNode) {
        //因为头节点不能动,因此通过一个辅助变量来帮助找到添加的位置
        //我们找的temp，是位于添加位置的前一个节点，否则插入不了
        HeroNode2 temp = head;
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
            heroNode.pre = temp;
            if (temp.next != null) {
                temp.next.pre = heroNode;
            }
            temp.next = heroNode;
        }
    }

    /**
     * 修改节点的信息，根据no编号来修改
     *
     * @param heroNode
     */
    public void update(HeroNode2 heroNode) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点，根据no编号；需要一个辅助变量
        HeroNode2 temp = head.next;
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
    public void delete(HeroNode2 heroNode) {
        if (head.next == null) {
            System.out.println("链表为空，无法删除");
            return;
        }
        //找到需要删除的节点，需要定义一个辅助变量
        HeroNode2 temp = head.next;
        //标识是否找到需要删除的节点
        boolean flag = false;
        while (true) {
            if (temp == null) {
                //链表遍历结束
                break;
            }
            if (temp.no == heroNode.no) {
                flag = true;
                break;
            }
            //temp后移
            temp = temp.next;
        }
        //判断flag的值
        if (flag) {
            temp.pre.next = temp.next;
            //如果不是最后一个节点
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
            temp.next = null;
            temp.pre = null;
        } else {
            System.out.printf("没有找到编号为 %d 的英雄，无法删除\n", heroNode.no);
        }
    }
}

class HeroNode2 {
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
     * 指向前一个几点
     */
    public HeroNode2 pre;

    /**
     * 指向下一个节点
     */
    public HeroNode2 next;

    /**
     * 构造器
     *
     * @param no       编号
     * @param name     名称
     * @param nickName 昵称
     */
    public HeroNode2(int no, String name, String nickName) {
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
