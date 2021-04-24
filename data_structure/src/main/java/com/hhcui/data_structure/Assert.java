package com.hhcui.data_structure;

/**
 * 测试工具类
 */
public class Assert {
    public static void test(boolean result) {
        if (!result) {
            throw new IllegalArgumentException("测试未通过");
        }
    }
}
