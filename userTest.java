import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class userTest {
    user user;
    @BeforeAll
    public void setup(){
        System.out.println("Before all");
        user=new user();

    }
    //login
    @Test
    public void login_True() throws Exception{
        String name="amr";
        String pass="123";
        int actual= user.login(name,pass);
        int expected=1;
        assertEquals(expected,actual);
    }
    @Test
    public void login_name_and_pass_ronge() throws Exception{
        String name="amor";
        String pass="1234";
        int actual= user.login(name,pass);
        int expected=0;
        assertEquals(expected,actual);
    }
    @Test
    public void login_pass_ronge() throws Exception{
        String name="amr";
        String pass="1234";
        int actual= user.login(name,pass);
        int expected=0;
        assertEquals(expected,actual);
    }
    @Test
    public void login_name_ronge() throws Exception{
        String name="amor";
        String pass="123";
        int actual= user.login(name,pass);
        int expected=0;
        assertEquals(expected,actual);
    }
    @Test
    public void login_name_and_pass_is_empte() throws Exception{
        String name="";
        String pass="";
        int actual= user.login(name,pass);
        int expected=0;
        assertEquals(expected,actual);
    }
    @Test
    public void login_name_is_empte() throws Exception{
        String name="";
        String pass="123";
        int actual= user.login(name,pass);
        int expected=0;
        assertEquals(expected,actual);
    }
    @Test
    public void login_pass_is_empte() throws Exception{
        String name="amr";
        String pass="";
        int actual= user.login(name,pass);
        int expected=0;
        assertEquals(expected,actual);
    }
    @Test
    public void login_name_is_empte_and_pass_ronge() throws Exception{
        String name="";
        String pass="1234";
        int actual= user.login(name,pass);
        int expected=0;
        assertEquals(expected,actual);
    }
    @Test
    public void login_pass_is_empte_and_ronge_name() throws Exception{
        String name="amor";
        String pass="";
        int actual= user.login(name,pass);
        int expected=0;
        assertEquals(expected,actual);
    }

    //sing up
    @Test
    public void singup_True() throws Exception{
        String name="omar";
        String pass="987";
        String repass="987";
        String sDate1="31/12/1998";
        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
        String jop="doctor";
        String email="s11941434@stu.najah.edu";
        String phone="0595012199";
        int actual= user.singup(name,pass,repass, (java.sql.Date) date1,jop,email,phone);
        int expected=1;
        assertEquals(expected,actual);
    }
    @Test
    public void singup_name_exists() throws Exception{
        String name="amr";
        String pass="987";
        String repass="987";
        String sDate1="31/12/1998";
        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
        String jop="doctor";
        String email="s11941434@stu.najah.edu";
        String phone="0595012199";
        int actual= user.singup(name,pass,repass, (java.sql.Date) date1,jop,email,phone);
        int expected=1;
        assertEquals(expected,actual);
    }
    @Test
    public void singup_empte() throws Exception{
        String name="";
        String pass="";
        String repass="";
        String sDate1="";
        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
        String jop="";
        String email="";
        String phone="";
        int actual= user.singup(name,pass,repass, (java.sql.Date) date1,jop,email,phone);
        int expected=0;
        assertEquals(expected,actual);
    }
    @Test
    public void singup_pass_not_equal_repass() throws Exception{
        String name="omar";
        String pass="987";
        String repass="9877";
        String sDate1="31/12/1998";
        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
        String jop="doctor";
        String email="s11941434@stu.najah.edu";
        String phone="0595012199";
        int actual= user.singup(name,pass,repass, (java.sql.Date) date1,jop,email,phone);
        int expected=0;
        assertEquals(expected,actual);
    }
    @Test
    public void singup_one_is_empte() throws Exception{
        String name="omar";
        String pass="987";
        String repass="987";
        String sDate1="31/12/1998";
        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
        String jop="doctor";
        String email="";
        String phone="0595012199";
        int actual= user.singup(name,pass,repass, (java.sql.Date) date1,jop,email,phone);
        int expected=0;
        assertEquals(expected,actual);
    }
    @Test
    public void singup_name_is_empte() throws Exception{
        String name="";
        String pass="987";
        String repass="987";
        String sDate1="31/12/1998";
        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
        String jop="doctor";
        String email="s11941434@stu.najah.edu";
        String phone="0595012199";
        int actual= user.singup(name,pass,repass, (java.sql.Date) date1,jop,email,phone);
        int expected=0;
        assertEquals(expected,actual);
    }
    @Test
    public void singup_name_and_one_empte() throws Exception{
        String name="";
        String pass="987";
        String repass="987";
        String sDate1="31/12/1998";
        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
        String jop="doctor";
        String email="";
        String phone="0595012199";
        int actual= user.singup(name,pass,repass, (java.sql.Date) date1,jop,email,phone);
        int expected=0;
        assertEquals(expected,actual);
    }
    @Test
    public void singup_name_is_faind_and_repass_ronge() throws Exception{
        String name="amr";
        String pass="987";
        String repass="9878";
        String sDate1="31/12/1998";
        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
        String jop="doctor";
        String email="s11941434@stu.najah.edu";
        String phone="0595012199";
        int actual= user.singup(name,pass,repass, (java.sql.Date) date1,jop,email,phone);
        int expected=0;
        assertEquals(expected,actual);
    }
    @Test
    public void singup_more_one_is_empte() throws Exception{
        String name="omar";
        String pass="987";
        String repass="987";
        String sDate1="";
        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
        String jop="doctor";
        String email="";
        String phone="";
        int actual= user.singup(name,pass,repass, (java.sql.Date) date1,jop,email,phone);
        int expected=1;
        assertEquals(expected,actual);
    }




    @AfterAll
    public void teardown(){
        System.out.println("After all");
        user=null;
    }


}