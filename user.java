import java.sql.*;

public class user {

        public user() {

        }





        boolean x =true;
        boolean y=false;
        public int login(String name,String pass) throws Exception{

            int re=0;



            String url,user,password;
            url="jdbc:oracle:thin:@localhost:1521:xe";
            user="c##amrsalman";
            password="123";
           // Driver d=new oracle.driver.OracleDriver();
            //DriverManager.registerDriver(d);

            Connection con = DriverManager.getConnection(url,user,password);
            con.setAutoCommit(false);
            Statement stmt = null;
            stmt = con.createStatement();
            String sqlst="select USERNAME,PASSWORD from USERP ";
            ResultSet s = stmt.executeQuery(sqlst);
            if(name.equals("")||pass.equals("")){
                x=false;
            }
            if(x){
                while(s.next()){
                    if(s.getString("USERNAME").equals(name)&&s.getString("PASSWORD").equals(pass)){


                        y=true;
                        return re= 1;


                    }



                }
                if(!y){
                    return re= 0;


                }


            }

            else{
                return re= 0;

            }




         return re=0;
        }


     public int singup(String name,String pass,String repass,Date bart,String jop,String email,String phone)throws Exception {



            boolean x=false;

            boolean y=false;

            int re=0;




            Class.forName("oracle.jdbc.OracleDriver");
            String url,user,password;
            url="jdbc:oracle:thin:@localhost:1521/xe";
            user="c##amrsalman";
            password="123";
            Connection con=DriverManager.getConnection(url,user,password);
            con.setAutoCommit(false);
            Statement stmt=con.createStatement();
            String sqlst="select USERNAME from USERP ";
            ResultSet s=stmt.executeQuery(sqlst);
            if(name.equals("")||pass.equals("")||bart.equals("")
                    ||email.equals("")||phone.equals("")||jop.equals("")||repass.equals("")){
                x=true;
            }
            if(!x){
                while(s.next()){
                    if(s.getString("USERNAME").equals(name)){

                        x=true;
                    }

                }
                if(x){
                    return re=0;
                }
                else {
                    if(pass.equals(repass)){
                        String sql="insert into USERP (USERNAME,PASSWORD,OLD,JOP,EMAIL,PHONENUMBER) "
                                + "values('"+name+"','"+pass+"','"+bart+"','"
                                +jop+"','"+email+"','"+phone+"')";


                        System.out.println(sql);
                        stmt.executeUpdate(sql);
                        con.commit();
                        //con.close();
                        return re=1;


                    }
                    else{
                        return re=0;
                    }


                }
            }
            else{
                return re=0;
            }




    }



    }



