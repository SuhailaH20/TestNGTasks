package tests;

import org.testng.annotations.*;

public class Dummy {
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("🔧 Before Suite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("🧹 After Suite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("🔧 Before Test");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("🧹 After Test");
    }

    @BeforeGroups("group1")
    public void beforeGroup1() {
        System.out.println("🔧 Before Group1");
    }

    @AfterGroups("group1")
    public void afterGroup1() {
        System.out.println("🧹 After Group1");
    }

    @Test(groups = "group1")
    public void testGroup1Method1() {
        System.out.println("✅ Test Group1 Method1");
    }

    @Test(groups = "group1")
    public void testGroup1Method2() {
        System.out.println("✅ Test Group1 Method2");
    }

    @Test
    public void testNormalMethod() {
        System.out.println("✅ Test Normal Method");
    }
}
