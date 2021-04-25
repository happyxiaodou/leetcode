package com.leetcode;

import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

class Order {
    int index;
    String customerName;
    boolean isAppetizerOrdered;//前菜
    boolean isDessertOrdered;//甜点
    int preparationTime;
    int cookTime;
    int mealTime;

    LocalTime startPreparationTime;
    LocalTime startCookTime;
    LocalTime startMealTime;
    LocalTime entTime;
    int sort;
    int tempTime;

    public Order() {

    }

    public Order(int index, String customerName, boolean isAppetizerOrdered, boolean isDessertOrdered, int preparationTime, int cookTime, int mealTime) {
        this.index = index;
        this.customerName = customerName;
        this.isAppetizerOrdered = isAppetizerOrdered;
        this.isDessertOrdered = isDessertOrdered;
        this.preparationTime = preparationTime;
        this.cookTime = cookTime;
        this.mealTime = mealTime;
    }

    public int getTotalTime() {
        return preparationTime + cookTime + mealTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return index == order.index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index);
    }

    @Override
    public String toString() {
        return "Order{" +
                "index=" + index +
                '}';
    }
}


/**
 * 最优方案,总耗时445分钟
 * Li Xing：8:0
 * Zhang Lin：11:10
 * Huang oo：14:25
 * <p>
 * 备选方案(不满足条件e的尽量，但时间小于等于最优方案),总耗时405分钟
 * Li Xing：8:0
 * Zhang Lin：10:35
 * Huang oo：13:45
 */

/**
 * 某餐厅仅接受预约就餐服务，给定餐馆订单基本信息列表如下，
 * {{“customerName”, “isAppetizerOrdered”, “isDessertOrdered”, “preparationTime”, “cookTime”, “mealTime”}
 * 以每日招待尽可能多的客户为目标，编程计算最优客人就餐顺序及时间。
 * 一些有用信息如下：
 * a. 每日8点钟开始营业
 * b. 假定同一时间只能服务一位顾客,
 * c. mealTime可用于做下一顾客的准备工作，即第一个顾客的mealTime可与第二个顾客的preparationTime重叠
 * d. 同一顾客的不同预约安排在同一时间进行
 * e. 预定了前菜的顾客要尽量安排在没有预定甜点的顾客之后
 * f. cookTime不可用于做任何其他任务
 * g. 一个顾客的完整招待时间= preparationTime + cookTime + mealTime
 */
public class MealTime {
    Map<Integer, Order> resultMap = new HashMap<>();

    List<Order> choose(List<Order> orderList) {
        //相同客户排序在一起
        Map<String, List<Order>> orderHashMap = orderList.stream().collect(Collectors.toMap(
                order -> order.customerName,
                order -> {
                    List<Order> orders = new ArrayList<>();
                    orders.add(order);
                    return orders;
                },
                (List<Order> newValueList, List<Order> oldValueList) -> {
                    oldValueList.addAll(newValueList);
                    return oldValueList;
                }));
        //排序客户
        orderList.sort(Comparator.comparing(Order::getTotalTime));
        for (int i = 0; i < orderList.size(); i++) {
            orderList.get(i).index = i;
        }

        LocalTime timePoint = LocalTime.of(8, 0);//8点开始营业

        Order first = orderList.get(0);
        first.startPreparationTime = timePoint;
        first.startCookTime = first.startPreparationTime.plusMinutes(first.preparationTime);
        first.startMealTime = first.startCookTime.plusMinutes(first.cookTime);
        first.entTime = first.startMealTime.plusMinutes(first.mealTime);

        orderList.remove(first);
        dp(orderList, first);


        return orderList;
    }


    /**
     * 从orderList 订单中获取最优的客户
     * 1. 从客户中选取相同的客户
     * 2. 选取没有预定甜点的客户
     * 3. 选取preparationTime 最接近mealtime的客户
     */
    //定义 从用户last开始，最少需要dp(orderList,last) 分钟
    Order dp(List<Order> orderList, Order last) {
        Order result = last;
        // base case 当last为最后一个订单，则不需要在计算了;
        if (orderList.size() == 1) {
            return result;
        }
        List<Order> newList = new ArrayList<>(orderList);
        newList.remove(last);

        for (int i = 0; i < newList.size(); i++) {
            Order next = newList.get(i);
            if (next == null || next.index == last.index) {
                continue;
            }
            Order next = dp(newList, result);//子问题消耗时间

            // 穷举每一个选择
            // 计算每一个子问题的结果
            int increaseTime;
            if (last.mealTime <= next.preparationTime) {//上一次的mealtime小于下次的prepertime
                next.startPreparationTime = last.startMealTime;
            } else {
                increaseTime = last.mealTime - (last.mealTime - next.preparationTime);
                next.startPreparationTime = last.startMealTime.plusMinutes(increaseTime);
            }
            next.startCookTime = next.startPreparationTime.plusMinutes(next.preparationTime);
            next.startMealTime = next.startCookTime.plusMinutes(next.cookTime);
            next.entTime = next.startMealTime.plusMinutes(next.cookTime);
            // 消耗时间：当前时间 + 子问题时间
            if (result.entTime.isAfter(next.entTime)) {
                result = next;
            }

        }

        return result;
    }


    public static void main(String[] args) {
        List<Order> orderList = new ArrayList<>();//订单数据
        orderList.add(new Order(0, "Li Xing", false, false, 20, 60, 15));
        orderList.add(new Order(1, "Zhang Lin", true, true, 15, 40, 5));
        orderList.add(new Order(2, "Huang oo", true, true, 55, 45, 15));
        orderList.add(new Order(3, "Li Xing", false, false, 10, 50, 15));
        orderList.add(new Order(4, "Zhang Lin", true, false, 35, 40, 45));
        MealTime mealTime = new MealTime();
        orderList = mealTime.choose(orderList);
        System.err.println("");
    }
}
