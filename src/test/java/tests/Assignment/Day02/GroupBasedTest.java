package tests.Assignment.Day02;

import org.testng.annotations.Test;
import utilities.TestBase;

public class GroupBasedTest extends TestBase {

    @Test(groups = {"smoke"})
    public void test01() {
        System.out.println("Smoke Test");
    }

    @Test(groups = {"regression"})
    public void test02() {
        System.out.println("Regression Test");
    }

    @Test(groups = {"api"})
    public void test03() {
        System.out.println("API Test");
    }

    @Test(groups = {"smoke", "regression"})
    public void test04() {
        System.out.println("Smoke + Regression Test");
    }
}

