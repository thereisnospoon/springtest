package test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class PrototypeBeanTest {

    private ConfigurableApplicationContext context;

    @Before
    public void createContext() {

        context = new ClassPathXmlApplicationContext("test-config.xml");
    }

    @Test
    public void test() {

        SingletonSpringService springService = context.getBean(SingletonSpringService.class);
        PrototypeBean prototypeBean1 = springService.getPrototypeBean();
        PrototypeBean prototypeBean2 = springService.getPrototypeBean();

        System.out.println(prototypeBean1);
        System.out.println(prototypeBean2);

        assertNotNull(prototypeBean1);
        assertNotNull(prototypeBean2);
        assertFalse(prototypeBean1 == prototypeBean2);
    }
}
