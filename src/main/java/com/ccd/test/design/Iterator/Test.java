package com.ccd.test.design.Iterator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by ccd on 2017/12/12.
 * 迭代子模式（Iterator）
 * 顾名思义，迭代器模式就是顺序访问聚集中的对象，一般来说，集合中非常常见，如果对集合类比较熟悉的话，理解本模式会非常轻松。
 * 这句话包含两层意思：一是需要遍历的对象，即聚集对想，二是迭代器对象，用于对聚合对象进行遍历访问。我们看下关系图
 *                   Iterator                                    collection
 *                  [previous,                                   [iterator,get,size]
 *                   next,hasnext,first;
 *
 *
 * 这个思路和我们常用的一模一样，MyCollection中定义了集合的一些操作，MyIterator中定义了一系列迭代操作，且持有
 * Collection实例，我们来看看实现代码：
 *
 * 此处我们貌似模拟了一个集合类的过程，感觉是不是很爽？其实JDK中各个类也都是这些基本的东西，加一些设计模式，再加
   一些优化放到一起的，只要我们把这些东西学会了，掌握好了，我们也可以写出自己的集合类，甚至框架！
 *
 */
public class Test {
    public static void main(String[] args) throws ParseException {
        Collection collection = new MyCollection();
        Iterator it = collection.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
