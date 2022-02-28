package com.leecode.string;

import org.junit.jupiter.api.Test;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wangzicheng
 * @Date: 2020/5/6 16:05
 * @Poject: AlgorithmStudy
 * leecode：6
 * 字形变换：将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 */
public class Convert {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());
        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();

    }

    @Test
    public void testCouvert() throws ClassNotFoundException {
        String s =convert("sfsdfaaefcaceffae",4);
        System.err.println(s);
        Class<Convert> convertClass = Convert.class;
        //Calculator实现类的构造器信息
        Constructor<?>[] calculatorImplClazzConstructors = convertClass.getConstructors();
        //Calculator实现类的方法信息
        Method[] calculatorImplClazzMethods = convertClass.getMethods();
        //打印
        System.out.println("------实现类Class的构造器信息------");
        printClassInfo(calculatorImplClazzConstructors);
        System.out.println("------实现类Class的方法信息------");
        printClassInfo(calculatorImplClazzMethods);
    }

    public static void printClassInfo(Executable[] targets){
        for (Executable target : targets) {
            // 构造器/方法名称
            String name = target.getName();
            StringBuilder sBuilder = new StringBuilder(name);
            // 拼接左括号
            sBuilder.append('(');
            Class[] clazzParams = target.getParameterTypes();
            // 拼接参数
            for(Class clazzParam : clazzParams){
                sBuilder.append(clazzParam.getName()).append(',');
            }
            //删除最后一个参数的逗号
            if(clazzParams!=null && clazzParams.length != 0) {
                sBuilder.deleteCharAt(sBuilder.length()-1);
            }
            //拼接右括号
            sBuilder.append(')');
            //打印 构造器/方法
            System.out.println(sBuilder.toString());
        }
    }


    private static Object getProxy(final Object target) throws Exception {
        Object proxy = Proxy.newProxyInstance(
                target.getClass().getClassLoader(),/*类加载器*/
                target.getClass().getInterfaces(),/*让代理对象和目标对象实现相同接口*/
                new InvocationHandler(){/*代理对象的方法最终都会被JVM导向它的invoke方法*/
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println(method.getName() + "方法开始执行...");
                        Object result = method.invoke(target, args);
                        System.out.println(result);
                        System.out.println(method.getName() + "方法执行结束...");
                        return result;
                    }
                }
        );
        return proxy;
    }
}
