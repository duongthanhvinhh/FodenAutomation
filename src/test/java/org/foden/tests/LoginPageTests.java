package org.foden.tests;

import org.foden.annotations.FrameworkAnnotation;
import org.foden.enums.CategoryType;
import org.testng.annotations.Test;

/**
 * The type Login page tests.
 */
public final class LoginPageTests extends BaseTest{

    private LoginPageTests(){}

    /**
     * Login test 1.
     */
    @FrameworkAnnotation(author = {"Foden", "VinhDuong"}, category = {CategoryType.REGRESSION,CategoryType.MINIREGRESSION})
    @Test(description = "Test Login")
    public void loginTest1(){
        System.out.println("Login Test 1 is running");
    }
}
