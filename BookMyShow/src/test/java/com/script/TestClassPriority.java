package com.script;

import org.testng.annotations.Test;

public class TestClassPriority {
/*@Test
public void First()
{
	System.out.println("First method Non priority");
}
@Test
public void Second()
{
	System.out.println("Second method with no priority");
}
@Test(priority=0)
public void Third()
{
	System.out.println("Third method with 0 prority");
}*/
/*@Test(priority=1)
public void Four()
{
	System.out.println("fourth method with 1 priority");
}
@Test(priority=-1)
public void Five()
{
	System.out.println("five method with -1 priority");
}*/
@Test(priority=1)
public void six()
{
	System.out.println("six method with 1 priority");
}
@Test(priority=-2)
public void seven()
{
	System.out.println("seven method with -2 priority");
}
@Test
public void eight()
{
	System.out.println("Eight method with non priority");
}

@Test()
public void c_method(){
	System.out.println("I'm in method C");
}
@Test()
public void b_method(){
	System.out.println("I'm in method B");
}
@Test(priority=6)
public void a_method(){
	System.out.println("I'm in method A");
}
@Test()
public void ekmethod(){
	System.out.println("I'm in method E");
}
@Test(priority=6)
public void d_method(){
	System.out.println("I'm in method D");
}
@Test(priority=0)
public void test()
{
	System.out.println("priority 0");
}
@Test(priority=0)
public void a()
{
	System.out.println("priority o a");
}
}