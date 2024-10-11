package myspring.di.annot.config;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = HelloBeanConfig.class, 
                      loader = AnnotationConfigContextLoader.class)
/*
 * @Configuration을 위한 컨테이너 객체는 AnnotationConfigApplicationContext
 * 변경된 컨테이너 객체를 로드 해주는 역할을 하는 AnnotationConfigContextLoader 클래스를 loader로 설정하는 것임
 */
public class HelloBeanConfigTest {

}
