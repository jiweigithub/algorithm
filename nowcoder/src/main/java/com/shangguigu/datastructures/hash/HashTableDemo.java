package com.shangguigu.datastructures.hash;

/**
 * 哈希表
 */
public class HashTableDemo {

    public static void main(String[] args) {
        HashTable hashTable = new HashTable(7);
        Emp emp1 = new Emp(1, "张1");
        Emp emp2 = new Emp(3, "张3");
        Emp emp3 = new Emp(5, "张5");
        Emp emp4 = new Emp(7, "张7");
        Emp emp5 = new Emp(9, "张9");
        Emp emp6 = new Emp(11, "张11");
        Emp emp7 = new Emp(13, "张13");
        Emp emp8 = new Emp(15, "张15");
        Emp emp9 = new Emp(17, "张17");
        Emp emp10 = new Emp(19, "张19");
        Emp emp11 = new Emp(21, "张21");
        hashTable.add(emp1);
        hashTable.add(emp2);
        hashTable.add(emp3);
        hashTable.add(emp4);
        hashTable.add(emp5);
        hashTable.add(emp6);
        hashTable.add(emp7);
        hashTable.add(emp8);
        hashTable.add(emp9);
        hashTable.add(emp10);
        hashTable.add(emp11);
        hashTable.list();
//        Emp byId = hashTable.findById(21);
//        if (byId != null) {
//            System.out.println(byId);
//        } else {
//            System.out.println("雇员信息不存在");
//        }
        hashTable.removeById(21);
        hashTable.list();
    }
}

/**
 * 雇员类
 */
class Emp {
    /**
     * id
     */
    private Integer id;
    /**
     * name
     */
    private String name;
    /**
     * next指针
     */
    private Emp next;

    public Emp(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Emp getNext() {
        return next;
    }

    public void setNext(Emp next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

/**
 * 哈希表，管理多条链表
 */
class HashTable {

    private int size;

    private EmpLinkedList[] empLinkedLists;

    public HashTable(int size) {
        this.empLinkedLists = new EmpLinkedList[size];
        this.size = size;
        for (int i = 0; i < size; i++) {
            empLinkedLists[i] = new EmpLinkedList();
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    /**
     * 添加雇员
     *
     * @param emp
     */
    public void add(Emp emp) {
        //根据员工的ID，得到该员工应当添加到哪条链表
        int i = hashFun(emp.getId());
        //将Emp添加到对应的链表中
        empLinkedLists[i].tailAdd(emp);
    }

    /**
     * 遍历所有链表，遍历哈希表
     */
    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedLists[i].list(i);
        }
    }

    /**
     * 根据Id查找雇员信息
     *
     * @param id
     */
    public Emp findById(Integer id) {
        int i = hashFun(id);
        Emp emp = empLinkedLists[i].findById(id);
        return emp;
    }

    public void removeById(Integer id) {
        int i = hashFun(id);
        empLinkedLists[i].removeById(id);
    }

    /**
     * 散列函数
     *
     * @param id
     * @return
     */
    public int hashFun(Integer id) {
        return id % size;
    }

}

/**
 * 雇员链表
 */
class EmpLinkedList {
    /**
     * 头指针指向第一个雇员
     */
    private Emp head;

    /**
     * 判断链表是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        if (head == null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 尾插法
     *
     * @param emp
     */
    public void tailAdd(Emp emp) {
        boolean flag = false;
        if (isEmpty()) {
            head = emp;
        } else if (head.getId().equals(emp.getId())) {
            emp.setNext(head.getNext());
            head = emp;
        } else {
            Emp current = head;
            while (current.getNext() != null) {
                if (current.getNext().getId().equals(emp.getId())) {
                    flag = true;
                    break;
                }
                current = current.getNext();
            }
            if (flag) {
                emp.setNext(current.getNext().getNext());
                current.setNext(emp);
            } else {
                current.setNext(emp);
            }
        }
    }

    /**
     * 按照empId升序插入
     *
     * @param emp
     */
    public void orderAdd(Emp emp) {
        if (isEmpty()) {
            head = emp;
        } else if (this.head.getId() > emp.getId()) {
            emp.setNext(head);
            head = emp;
        } else if (this.head.getId().equals(emp.getId())) {
            emp.setNext(head.getNext());
            head = emp;
        } else {
            Emp current = head;
            boolean flag = false;
            while (current.getNext() != null) {
                //说明位置找到就在current后
                if (current.getNext().getId() > emp.getId()) {
                    break;
                }
                //如果id相同，需要将当前节点替换为新的节点
                if (current.getNext().getId().equals(emp.getId())) {
                    flag = true;
                    break;
                }
                current = current.getNext();
            }
            //如果id相同则替换
            if (flag) {
                emp.setNext(current.getNext().getNext());
                current.setNext(emp);
            } else {
                emp.setNext(current.getNext());
                current.setNext(emp);
            }
        }
    }

    /**
     * 打印链表
     */
    public void list(int no) {
        if (isEmpty()) {
            System.out.println("第" + no + "链表为空");
        } else {
            Emp current = head;
            while (current != null) {
                System.out.printf("第%d条链表内容", no);
                System.out.printf("=>%s", current.toString());
                current = current.getNext();
            }
            System.out.println();
        }
    }

    public Emp findById(Integer id) {
        Emp current = head;
        while (current != null) {
            if (current.getId().equals(id)) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    public void removeById(Integer id) {
        if (head.getId().equals(id)) {
            head = head.getNext();
        } else {
            Emp current = head;
            while (current.getNext() != null) {
                if (current.getNext().getId().equals(id)) {
                    current.setNext(current.getNext().getNext());
                    break;
                }
                current = current.getNext();
            }
        }
    }
}


