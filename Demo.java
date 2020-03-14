package com.company.hw02;

import java.util.*;


public class Demo {
    public static String of(List<Id> black, List<Id> white){
        List<Integer> bn = new ArrayList<>();
        List<String> bc = new ArrayList<>();
        List<Integer> wn = new ArrayList<>();
        List<String> wc = new ArrayList<>();
        for (Map.Entry<List, List> list : Demo.place(black).entrySet()) {
            bn = list.getKey();
            bc = list.getValue();
        }
        for (Map.Entry<List, List> list : Demo.place(white).entrySet()) {
            wn = list.getKey();
            wc = list.getValue();
        }
        Collections.sort(bn, (Integer o1, Integer o2) -> {
                return o2-o1;
            });
        Collections.sort(wn,(Integer o1, Integer o2) -> {
            return o2-o1;
        });
        int bt = judgeType(bn,bc);
        int wt = judgeType(wn,wc);
        if (bt < wt)
            return "black wins";
        else if (bt > wt)
            return "white wins";
        else{
            if (comp(bn,wn) == 1)
                return "black wins";
            else
                return "white wins";
        }

    }
    public static Map<List,List> place(List<Id> Id){
        List<Integer> cn = new ArrayList<>();
        List<String> cc = new ArrayList<>();
        ListIterator<Id> ci = Id.listIterator();
        while(ci.hasNext()){
            Id next = ( Id ) ci.next();
            if (next.num == "A")
                cn.add(14);
            else if (next.num == "K")
                cn.add(13);
            else if (next.num == "Q")
                cn.add(12);
            else if (next.num == "J")
                cn.add(11);
            else cn.add(Integer.parseInt(next.num));
            cc.add(next.color);
        }
        HashMap<List,List> map = new HashMap<>();
        map.put(cn,cc);
        return map;
    }
    public static int isRoyalFlush(List<Integer> n,List<String> c){
        if(Demo.isFlush(c) == 4 && Demo.isStriaght(n) == 5)
            return 1;
        else
            return 0;
    }

    public static int isFlush(List<String> list){
        if (list.get(0) == list.get(1) && list.get(1) == list.get(2) && list.get(2) == list.get(3) && list.get(3) == list.get(4))
            return 4;
        else
            return 0;
    }
    public static int isStriaght(List<Integer> list){
        if(list.get(0)-list.get(1) == list.get(1)-list.get(2) && list.get(2)-list.get(3) == list.get(3)-list.get(4)
        && list.get(3)-list.get(4) == 1)
            return 5;
        else
            return 0;
    }
    public static int isPairs(List<Integer> list){
        if (list.get(0)==list.get(1)){
            if(list.get(2)==list.get(3) || list.get(3)==list.get(4))
                return 7;
            else
                return 8;
        }else if (list.get(1)==list.get(2)){
            if (list.get(3)==list.get(4))
                return 7;
            else
                return 8;
        }else if (list.get(2)==list.get(3) || list.get(3)==list.get(4))
            return 8;
        else
            return 0;
    }
    public static int isThree(List<Integer> list){
        if(list.get(0) == list.get(1) && list.get(1) == list.get(2)){
            if (list.get(3) == list.get(4))
                return 3;
            else
                return 6;
        }else if ((list.get(1) == list.get(2) && list.get(2) == list.get(3)) || (list.get(2) == list.get(3) && list.get(3) == list.get(4))){
            return 6;
        }else
            return 0;
    }
    public static int isFour(List<Integer> list){
        if ((list.get(0)==list.get(1) && list.get(1)==list.get(2) && list.get(2)==list.get(3)) ||
                (list.get(1)==list.get(2) && list.get(2)==list.get(3) && list.get(3)==list.get(4)))
            return 2;
        else
            return 0;
    }
    public static int judgeType(List<Integer> n,List<String> c){
        int flag;
        if (isPairs(n) != 0)
            flag = isPairs(n);
        else if (isThree(n) != 0)
            flag = isThree(n);
        else if (isStriaght(n) != 0)
            flag = isStriaght(n);
        else if (isFlush(c) != 0)
            flag = isFlush(c);
        else if (isFour(n) != 0)
            flag = isFour(n);
        else if (isRoyalFlush(n,c) != 0)
            flag = isRoyalFlush(n,c);
        else
            flag = 0;
        return 0;
    }
    public static int comp(List<Integer> first,List<Integer> second){
        int flag = 0;
        for (int i = 0; i < 5; i++) {
            if(first.get(i) > second.get(i)){
                flag = 1;
                break;
            }
            else if (first.get(i) < second.get(i)){
                flag = -1;
                break;
            }
            else
                continue;
        }
        return flag;
    }
}
