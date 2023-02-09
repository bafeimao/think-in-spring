package org.bafeimao.ioc.java.beans;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyEditorSupport;
import java.util.stream.Stream;

/**
 * @projectName: think-in-spring
 * @package: org.bafeimao.ioc.java.beans
 * @className: BeanInfoDemo
 * @author: ycd20
 * @description: TODO
 * @date: 2023/2/5 20:18
 * @version: 1.0
 */
public class BeanInfoDemo {
    public static void main(String[] args) throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class, Object.class);

        Stream.of(beanInfo.getPropertyDescriptors())
                .forEach(propertyDescriptor -> {
                    Class<?> propertyType = propertyDescriptor.getPropertyType();
                    String name = propertyDescriptor.getName();
                    if ("age".equals(name)) {
                        // String
//                        Integer.valueOf("1");
                        propertyDescriptor.setPropertyEditorClass(StringToIntegerPropertyEditor.class);
//                        propertyDescriptor.createPropertyEditor();
                    }
                });
    }

    static class StringToIntegerPropertyEditor extends PropertyEditorSupport {
        @Override
        public void setAsText(String text) throws java.lang.IllegalArgumentException {
            Integer value = Integer.valueOf(text);
            setValue(value);
        }

    }
}
