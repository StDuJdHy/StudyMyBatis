package com.dsfzl.mybatis.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * @author: dsf
 * @description: 通过类加载器获得resource的辅助类
 * @date 2024/11/21 下午9:07
 */

public class Resources {

    public static Reader getResourceAsReader(String resource) throws IOException {
        return new InputStreamReader(getResourceAsStream(resource));
    }

    private static InputStream getResourceAsStream(String resource) throws IOException {
        ClassLoader[] classLoaders = getClassLoaders();
        for (ClassLoader classLoader : classLoaders) {
            InputStream inputStream = classLoader.getResourceAsStream(resource);
            if (null != inputStream) {
                return inputStream;
            }
        }
        throw new IOException("Could not find resource " + resource);
    }

    private static ClassLoader[] getClassLoaders() {
        return new ClassLoader[]{
                //系统类加载器是用于加载应用程序的类路径（CLASSPATH）中的类和资源的类加载器。
                //它通常负责加载JRE的核心库以及用户指定的类路径上的类。
                ClassLoader.getSystemClassLoader(),
                Thread.currentThread().getContextClassLoader()};
    }

    public static Class<?> classForName(String className) throws ClassNotFoundException {
        // 查找名为 className 的类
        return Class.forName(className);
    }
}
