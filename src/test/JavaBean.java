package test;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import scala.actors.threadpool.Arrays;

@RequestScoped
@ManagedBean
public class JavaBean {
 public List<String> getTest(){
	 return Arrays.asList(new String[]{"toto",""});
 }
}
