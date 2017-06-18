package com.laotan.easyreader.test;

import com.laotan.easyreader.bean.Book;

import org.junit.Test;

import java.util.Comparator;
import java.util.GregorianCalendar;

/**
 * Created by quantan.liu on 2017/6/17 0017 19:53.
 */

public class CopareableTest {
    @Test
    public void test() throws Exception {
        Book b1 = new Book(10001, "红楼梦", 150.86, new GregorianCalendar(2009,
                01, 25), "曹雪芹、高鄂");
        Book b2 = new Book(10001, "三国演义", 99.68, new GregorianCalendar(2008, 7,
                8), "罗贯中 ");
        Book b3 = new Book(10003, "水浒传", 100.8, new GregorianCalendar(2009, 6,
                28), "施耐庵 ");
        Book b4 = new Book(10004, "西游记", 120.8, new GregorianCalendar(2011, 6,
                8), "吴承恩");
        Book b5 = new Book(10005, "天龙八部", 10.4, new GregorianCalendar(2011, 9,
                23), "搜狐");
//TreeMap
//        Map tm = new TreeMap();
//
//        tm.put(b1, new Integer(255));
//        tm.put(b2, new Integer(122));
//        tm.put(b3, new Integer(688));
//        tm.put(b4, new Integer(453));
//        tm.put(b5, new Integer(40));
//
//        Iterator it = tm.keySet().iterator();
//        Object key = null, value = null;
//        Book bb = null;
//        while (it.hasNext()) {
//            key = it.next();
//            bb = (Book) key;
//            value = tm.get(key);
//            System.out.println(bb.toString() + "\t库存：" + tm.get(key));
//        }

//        TreeSet案例
//        Set<Book> treeSet = new TreeSet<>();
//        treeSet.add(b1);
//        treeSet.add(b3);
//        treeSet.add(b4);
//        treeSet.add(b2);
//        treeSet.add(b5);
//        for (Book book : treeSet) {
//            System.out.println(book);
//}

//        ArrayList案例
//        List<Book> list= new ArrayList<>();
//        list.add(b1);
//        list.add(b3);
//        list.add(b4);
//        list.add(b2);
//        list.add(b5);
//        Collections.sort(list, new Comparator<Book>() {
//            @Override
//            public int compare(Book book1, Book book2) {
//                return (int) (book1.price-book2.price);
//            }
//        });
//        Collections.sort(list);
//        for (Book book : list) {
//            System.out.println(book);
//        }
    }

    // 自定义比较器：按书的价格排序
    static class PriceComparator implements Comparator {
        public int compare(Object object1, Object object2) {// 实现接口中的方法
            Book p1 = (Book) object1; // 强制转换
            Book p2 = (Book) object2;
            return new Double(p1.price).compareTo(new Double(p2.price));
        }
    }

    // 自定义比较器：按书出版时间来排序
    static class CalendarComparator implements Comparator {
        public int compare(Object object1, Object object2) {// 实现接口中的方法
            Book p1 = (Book) object1; // 强制转换
            Book p2 = (Book) object2;
            return p2.calendar.compareTo(p1.calendar);
        }
    }
}
