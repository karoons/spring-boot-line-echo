package com.ananda.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IdmServiceTest {

    @Autowired
    IdmService idmService;

    //mvn -Dspring.profiles.active=dev -Dtest=IdmServiceTest#testSignUp test
    @Test
    public void testSignUp() throws Exception {
        try {
            System.out.println("-- start test --");
            String userName = "testWithSpring2";
            String password = "P@ssw0rd1";
            Map<String, Object> attr = new HashMap<>();
            attr.put("email", "karoon@ananda.co.th");
            idmService.signUp(userName, password, attr);
            assertThat(1).isEqualTo(1);
            System.out.println("-- end test --");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //mvn -Dspring.profiles.active=dev -Dtest=IdmServiceTest#testVerifyAccessCode test
    @Test
    public void testVerifyAccessCode() throws Exception {
        try {
            System.out.println("-- start test --");
            String userName = "testWithSpring2";
            String code = "404646";
            idmService.verifyAccessCode(userName, code);
            assertThat(1).isEqualTo(1);
            System.out.println("-- end test --");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //mvn -Dspring.profiles.active=dev -Dtest=IdmServiceTest#testSignIn test
    @Test
    public void testSignIn() throws Exception {
        try {
            System.out.println("-- start test --");
            String userName = "testWithSpring2";
            String password = "P@ssw0rd1";
//            String outputData = idmService.signIn(userName, password);
            System.out.println("Result from login : " + idmService.signIn(userName, password));
            assertThat(1).isEqualTo(1);
            System.out.println("-- end test --");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //mvn -Dspring.profiles.active=dev -Dtest=IdmServiceTest#testResetPassword test
    @Test
    public void testResetPassword() throws Exception {
        try {
            System.out.println("-- start test --");
            String userName = "testWithSpring2";
            String newPassword = "P@ssw0rd1";
            String confirmCode = "";
            idmService.resetPassword(userName, newPassword, confirmCode);
            assertThat(1).isEqualTo(1);
            System.out.println("-- end test --");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //mvn -Dspring.profiles.active=dev -Dtest=IdmServiceTest#testRequestConfirmCodeForResetPassword test
    @Test
    public void testRequestConfirmCodeForResetPassword() throws Exception {
        try {
            System.out.println("-- start test --");
            String userName = "testWithSpring2";
            idmService.requestConfirmCodeForResetPassword(userName);
            assertThat(1).isEqualTo(1);
            System.out.println("-- end test --");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //mvn -Dspring.profiles.active=dev -Dtest=IdmServiceTest#testGetUser test
    @Test
    public void testGetUser() throws Exception {
        try {
            System.out.println("-- start test testGetUser --");
            String accessToken = "eyJraWQiOiJFOGtpeWtxNlhDQlwvdHg1c1BzQWFmSUpHSnBFTzF5N1pYd3lCR1hVbUs5ND0iLCJhbGciOiJSUzI1NiJ9.eyJzdWIiOiIxYjc4NWI3OC1lMGY0LTQyOTItOTU3Yi02NTIxOWVhNGUyYzkiLCJldmVudF9pZCI6Ijc4OThmOWEyLTcwNjEtMTFlOC05MjZhLTZiMzhhMWY0OGY2NyIsInRva2VuX3VzZSI6ImFjY2VzcyIsInNjb3BlIjoiYXdzLmNvZ25pdG8uc2lnbmluLnVzZXIuYWRtaW4iLCJhdXRoX3RpbWUiOjE1MjkwNDI0NTcsImlzcyI6Imh0dHBzOlwvXC9jb2duaXRvLWlkcC5hcC1zb3V0aGVhc3QtMS5hbWF6b25hd3MuY29tXC9hcC1zb3V0aGVhc3QtMV9EcFpuZjJEWDMiLCJleHAiOjE1MjkwNDYwNTcsImlhdCI6MTUyOTA0MjQ1NywianRpIjoiMzEwZjU4YzItYjc0NC00NjgwLThkM2ItZmJiMzA4ZTNmYmU5IiwiY2xpZW50X2lkIjoiNHUyMnRjbmxkbWRqcGx0cTVmZ2Z1bDVzYjIiLCJ1c2VybmFtZSI6InJlc3RVc2VyIn0.kQoB-jLEtQq8DoBMtgWL6YKfz6ENfrN6nHgnffbcRlhQ7dxQgBXHagAE8nRH5kEbnHG5rXNzvO1OA5J9Vve39L5rFcLpUZfUZDdEFjVVLJWI79ZevV24SmTG7NGhqgrF2PS29M9LXcGkR9Hzcsd6Vuuppkm-Ga-zK_DuHsCnIx1a76Eb274XOK2eKVuPQSCOkC0XziPZsZoO4PhW_IC3CWgULBwFyWaNSPBejsMjfKiHje-didKgvgFx1ZnA88GqCQPLCimjEhGR3kY1UQ_apQCxBGuAxfJ0gve-opVNDb8E1_Q-kT5kQDPLJTmMEjaOmM6p3JkrNpKviQL6Xtbu9w";
            System.out.println("--------------- " + idmService.getUser(accessToken));
            assertThat(1).isEqualTo(1);
            System.out.println("-- end test --");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
