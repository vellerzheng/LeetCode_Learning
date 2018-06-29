package com.leetCode._1__100_problems._56MergeIntervals;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: vellerzheng
 * @Description:
 * 题意：有很多个区间，把有重叠的区间合并。
 *
 * 思路：先排序，然后检查相邻两个区间，看前一个区间的结尾是否大于后一个区间的开始，
 *       注意前一个区间包含后一个区间的情况。
 * @Date:Created in 20:25 2018/6/26
 * @Modify By:
 */
class Interval {
     int start;
     int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
  }

  //Runtime: 92ms
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() <= 1)
            return intervals;
        // 先排序
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));

        List<Interval> result = new LinkedList<>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        // 相邻合并
        for(Interval interval : intervals){
            if(interval.start <= end){
                end = Math.max(end, interval.end);
            }else {
                result.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }

        result.add(new Interval(start, end));
        return result;
    }


    // Runtime: 118ms
    public List<Interval> merge1(List<Interval> intervals) {
        if(intervals==null || intervals.size()<=1) {
            return intervals;
        }

        // 先排序
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));

        Iterator<Interval> itr = intervals.iterator();
        Interval merge=itr.next();

        while(itr.hasNext()){
            Interval current=itr.next();

            if(merge.end>=current.start){
                merge.end= Math.max(merge.end,current.end);
                itr.remove();
            } else {
                merge=current;
            }
        }

        return intervals;
    }

    public static void main(String[] args) {

        Interval interval1 = new Interval(1,3);
        Interval interval2 = new Interval(2,6);
        Interval interval3 = new Interval(8,10);
        Interval interval4 = new Interval(15,18);

        List<Interval> list = new ArrayList<>();
        list.add(interval1);
        list.add(interval3);
        list.add(interval2);
        list.add(interval4);

        List<Interval> result = new Solution().merge1(list);
                for(Interval interval: result) {
                    System.out.print("[" + interval.start +"," +interval.end + "]" +",");
                }

    }
}
