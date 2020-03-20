package com.tenement.domain.common;

import org.dozer.DozerBeanMapper;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.List;

public class BeanUtils {
    private static final DozerBeanMapper MAPPER = new DozerBeanMapper();

    static {
        List<String> files = new ArrayList<String>();
        files.add("bean.xml");
        MAPPER.setMappingFiles(files);
    }

    public static void copy(Object orig, Object dest) {
        if (orig == null || dest == null) {
            throw new BeanException("cannot copy null!");
        }

        MAPPER.map(orig, dest);
    }

    public static void copyList(List orig, List dest) {
        if (orig == null || dest == null) {
            throw new BeanException("cannot copy null!");
        }
        if (orig.size() != dest.size()) {
            throw new BeanException("not same size!");
        }

        int i = 0;
        for (Object each : orig) {
            copy(each, dest.get(i));
            i++;
        }
    }

    public static <T> T convert(Object orig, Class<T> clazz) {
        if (orig == null) {
            return null;
        }

        return MAPPER.map(orig, clazz);
    }

    public static <T> List<T> convertList(List<?> orig, Class<T> clazz) {
        List<T> dest = null;

        if (orig !=null) {
            dest = new ArrayList<T>();
            for (Object each : orig) {
                T destEntry = convert(each, clazz);
                dest.add(destEntry);
            }

        } else if (orig != null) {
            dest = new ArrayList<T>();
        }
        return dest;
    }

    public static boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;
        }
        boolean isEmptyFlag = true;
        PropertyDescriptor[] propArray = PropertyUtils.getPropertyDescriptors(obj);
        for (PropertyDescriptor prop : propArray) {
            if (!"class".equals(prop.getName())) {
                try {
                    Object fieldValue = prop.getReadMethod().invoke(obj);
                    if (fieldValue != null) {
                        isEmptyFlag = false;
                        break;
                    }
                } catch (Exception e) {
                    throw new BeanException(e);
                }
            }
        }
        return isEmptyFlag;
    }

    public static void setProperty(Object o,String name,Object value){
        try {
            org.apache.commons.beanutils.BeanUtils.setProperty(o, name, value);
        }catch (Exception e){
            throw new BeanException(e);
        }
    }

    public static String getProperty(Object o,String name){
        try {
            return org.apache.commons.beanutils.BeanUtils.getProperty(o, name);
        }catch (Exception e){
            throw new BeanException(e);
        }
    }

//    public static void main(String[] args) {
//        IdBean id = new IdBean();
//        id.setId(1L);
//        System.out.println(BeanUtils.isEmpty(id));
//    }

}


