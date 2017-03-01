/**
 * @Title JUnitServiceBase.java 
 * @Package com.zlfund.headstone 
 * @Description 
 * @author 徐文凡
 * @date 2017年2月26日 下午3:53:37 
 * @version V1.0   
 */
package com.zlfund.headstone;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/** 
 * JUnit测试基类
 * @author: 徐文凡 
 * @since: 2017年2月26日 下午3:53:37 
 * @history:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/spring-context.xml" })
public class JUnitServiceBase extends AbstractJUnit4SpringContextTests {

}
