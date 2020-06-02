package com.leecode.pratice;

import com.alibaba.fastjson.JSONObject;
import com.leecode.dto.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: wangzicheng
 * @Date: 2020/5/15 10:01
 * @Poject: AlgorithmStudy
 */
public class PraticeDemo {
    @Test
    public void testDemo(){
        ListNode listNode=new ListNode(1);
        ListNode listNode1=new ListNode(3);

        List<ListNode> listNodes=new ArrayList<>();
        listNodes.add(listNode);
        listNodes.add(listNode1);
        Map<String,List<ListNode>> map=new HashMap<>();
        map.put("data",listNodes);
        String json=JSONObject.toJSONString(map);
        System.out.println(json);
    }
}
