import java.sql.*;
import java.util.Scanner;
public class Operation extends dbcon {
    void insert(){

        try{
//            int id =7;
//            String name ="ram";
//            int age =20;
//            String gender = "male";
//            String course ="MBA";
//            int fee = 42150;
            Scanner sc = new Scanner(System.in);
            System.out.println("enter id");
            int id = sc.nextInt();
            System.out.println("enter name");
            String name = sc.next();
            System.out.println("enter age");
            int age = sc.nextInt();
            System.out.println(" enter gender");
            String gender = sc.next();
            System.out.println("enter course");
            String course = sc.next();
            System.out.println("enter fee");
            int fee = sc.nextInt();

            String insertquery = "insert into student values(?,?,?,?,?,?);";
            PreparedStatement pst = con.prepareStatement(insertquery);

            pst.setInt(1,id);
            pst.setString(2,name);
            pst.setInt(3,age);
            pst.setString(4,gender);
            pst.setString(5,course);
            pst.setInt(6,fee);

            pst.executeUpdate();
            System.out.println("data inserted");
            Thread.sleep(1000);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    void delete(){
        try{
            System.out.println("enter id");
            Scanner sc = new Scanner(System.in);
            int id = sc.nextInt();
            String delqueary = "delete from student where sid="+id;
            PreparedStatement pst = con.prepareStatement(delqueary);
            pst.executeUpdate();
            System.out.println("record deltee");
            Thread.sleep(10000);


        }catch (Exception e){
            System.out.println(e);

        }
    }
    void update() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("press 1 for id based update");
            System.out.println("press 2 for name based update");
            System.out.println("press 3 for age based update");
            System.out.println("press 4 for gender based update");
            System.out.println("press 5 for cource based update");
            System.out.println("press 6 for fee based update");
            int press = sc.nextInt();
            String updateQuery = null;

            switch (press) {

                case 1: {
                    System.out.println("enter which id ");
                    int id = sc.nextInt();
                    System.out.println("enter 0 for not update and 1 to undate  like [1 ,1 ,0,1,0 ]" +
                            "\n [name,age,gender,cource,fee]");
                    int array[] = new int[5];
                    for (int i = 0; i < 5; i++) {
                        array[i] = sc.nextInt();
                    }
                    String name = "", cource = "", gender = "";
                    int age = -1, fee = -1;

                        System.out.println("--------update value ---------");
                        if (array[0] == 1 && name.equals("")) {
                            System.out.printf(" enter field name to be updated");
                            name = sc.next();
                        }
                        if (array[1] == 1 && age == -1) {
                            System.out.printf(" enter field age to be updated");
                            age = sc.nextInt();
                        }
                        if (array[2] == 1 && gender.equals("")) {
                            System.out.printf(" enter field gender to be updated");
                            gender = sc.next();
                        }
                        if (array[3] == 1 && cource.equals("")) {
                            System.out.printf(" enter field cource to be updated");
                            cource = sc.next();
                        }
                        if (array[4] == 1 && fee == -1) {
                            System.out.printf(" enter field fee to be updated");
                            fee = sc.nextInt();
                        }


                    updateQuery = String.format("UPDATE student SET sname = CASE WHEN '%s' != '' THEN '%s' ELSE sname END, sage = CASE WHEN %d != -1 THEN %d ELSE sage END, sgender = CASE WHEN '%s' != '' THEN '%s' ELSE sgender END, scource = CASE WHEN '%s' != '' THEN '%s' ELSE scource END, sfees = CASE WHEN %d != -1 THEN %d ELSE sfees END WHERE sid = %d ;", name, name, age, age, gender, gender, cource, cource, fee, fee, id);


                    break;
                }
                case 2: {
                    System.out.println("enter which name ");
                    String name = sc.next();
                    System.out.println("enter 0 for not update and 1 to undate  like [1 ,1 ,0,1,0 ]" +
                            "\n [id,age,gender,cource,fee]");
                    int array[] = new int[5];
                    for (int i = 0; i < 5; i++) {
                        array[i] = sc.nextInt();
                    }
                    String cource = "", gender = "";
                    int age = -1, fee = -1, id = -1;

                        System.out.println("--------update value ---------");
                        if (array[0] == 1 && id == -1) {
                            System.out.printf(" enter field id to be updated");
                            id = sc.nextInt();
                        }
                        if (array[1] == 1 && age == -1) {
                            System.out.printf(" enter field age to be updated");
                            age = sc.nextInt();
                        }
                        if (array[2] == 1 && gender.equals("")) {
                            System.out.printf(" enter field gender to be updated");
                            gender = sc.next();
                        }
                        if (array[3] == 1 && cource.equals("")) {
                            System.out.printf(" enter field cource to be updated");
                            cource = sc.next();
                        }
                        if (array[4] == 1 && fee == -1) {
                            System.out.printf(" enter field fee to be updated");
                            fee = sc.nextInt();
                        }


                    updateQuery = String.format("UPDATE student SET sid = CASE WHEN '%d' != -1 THEN '%d' ELSE sid END, sage = CASE WHEN %d != -1 THEN %d ELSE sage END, sgender = CASE WHEN '%s' != '' THEN '%s' ELSE sgender END, scource = CASE WHEN '%s' != '' THEN '%s' ELSE scource END, sfees = CASE WHEN %d != -1 THEN %d ELSE sfees END WHERE sname = '%s' ;", id, id, age, age, gender, gender, cource, cource, fee, fee, name);


                    break;


                }
                case 3: {
                    System.out.println("enter which age ");
                    int age = sc.nextInt();
                    System.out.println("enter 0 for not update and 1 to undate  like [1 ,1 ,0,1,0 ]" +
                            "\n [ id,name,gender,cource,fee]");
                    int array[] = new int[5];
                    for (int i = 0; i < 5; i++) {
                        array[i] = sc.nextInt();
                    }
                    String cource = "", gender = "",name="";
                    int  fee = -1, id = -1;

                        System.out.println("--------update value ---------");
                        if (array[0] == 1 && id == -1) {
                            System.out.printf(" enter field id to be updated");
                            id = sc.nextInt();
                        }
                        if (array[1] == 1 && name.equals("")) {
                            System.out.printf(" enter field name to be updated");
                            name = sc.next();
                        }
                        if (array[2] == 1 && gender.equals("")) {
                            System.out.printf(" enter field gender to be updated");
                            gender = sc.next();
                        }
                        if (array[3] == 1 && cource.equals("")) {
                            System.out.printf(" enter field cource to be updated");
                            cource = sc.next();
                        }
                        if (array[4] == 1 && fee == -1) {
                            System.out.printf(" enter field fee to be updated");
                            fee = sc.nextInt();
                        }


                    updateQuery = String.format("UPDATE student SET sid = CASE WHEN '%d' != -1 THEN '%d' ELSE sid END, sname = CASE WHEN '%s' != '' THEN '%s' ELSE sname END, sgender = CASE WHEN '%s' != '' THEN '%s' ELSE sgender END, scource = CASE WHEN '%s' != '' THEN '%s' ELSE scource END, sfees = CASE WHEN %d != -1 THEN %d ELSE sfees END WHERE sage = %d ;", id, id, name, name, gender, gender, cource, cource, fee, fee, age);


                    break;


                }
                case 4: {
                    System.out.println("enter which gender ");
                    String gender = sc.next();
                    System.out.println("enter 0 for not update and 1 to undate  like [1 ,1 ,0,1,0 ]" +
                            "\n [id,name,age,cource,fee]");
                    int array[] = new int[5];
                    for (int i = 0; i < 5; i++) {
                        array[i] = sc.nextInt();
                    }
                    String cource = "", name = "";
                    int age = -1, fee = -1, id = -1;

                        System.out.println("--------update value ---------");
                        if (array[1] == 1 && name.equals("")) {
                            System.out.printf(" enter field id to be updated");
                            id = sc.nextInt();
                        }
                        if (array[2] == 1 && age == -1) {
                            System.out.printf(" enter field age to be updated");
                            age = sc.nextInt();
                        }
                        if (array[1] == 1 && name.equals("")) {
                            System.out.printf(" enter field name to be updated");
                            name = sc.next();
                        }
                        if (array[3] == 1 && cource.equals("")) {
                            System.out.printf(" enter field cource to be updated");
                            cource = sc.next();
                        }
                        if (array[4] == 1 && fee == -1) {
                            System.out.printf(" enter field fee to be updated");
                            fee = sc.nextInt();
                        }


                    updateQuery = String.format("UPDATE student SET sid = CASE WHEN '%d' != -1 THEN '%d' ELSE sid END, sage = CASE WHEN %d != -1 THEN %d ELSE sage END, sname = CASE WHEN '%s' != '' THEN '%s' ELSE sname END, scource = CASE WHEN '%s' != '' THEN '%s' ELSE scource END, sfees = CASE WHEN %d != -1 THEN %d ELSE sfees END WHERE sgender = '%s' ;", id, id, age, age, name, name, cource, cource, fee, fee, gender);



                    break;


                }
                case 5: {
                    System.out.println("enter which cource ");
                    String cource = sc.next();
                    System.out.println("enter 0 for not update and 1 to undate  like [1 ,1 ,0,1,0 ]" +
                            "\n [id,name,age,gender,fee]");
                    int array[] = new int[5];
                    for (int i = 0; i < 5; i++) {
                        array[i] = sc.nextInt();
                    }
                    String name="", gender = "";
                    int age = -1, fee = -1, id = -1;

                        System.out.println("--------update value ---------");
                        if (array[1] == 1 && name.equals("")) {
                            System.out.printf(" enter field name to be updated");
                            name = sc.next();
                        }
                        if (array[2] == 1 && age == -1) {
                            System.out.printf(" enter field age to be updated");
                            age = sc.nextInt();
                        }
                        if (array[3] == 1 && gender.equals("")) {
                            System.out.printf(" enter field gender to be updated");
                            gender = sc.next();
                        }
                        if (array[0] == 1 && id == -1) {
                            System.out.printf(" enter field id to be updated");
                            id = sc.nextInt();
                        }
                        if (array[4] == 1 && fee == -1) {
                            System.out.printf(" enter field fee to be updated");
                            fee = sc.nextInt();
                        }


                    updateQuery = String.format("UPDATE student SET sid = CASE WHEN '%d' != -1 THEN '%d' ELSE sid END, sage = CASE WHEN %d != -1 THEN %d ELSE sage END, sgender = CASE WHEN '%s' != '' THEN '%s' ELSE sgender END, sname = CASE WHEN '%s' != '' THEN '%s' ELSE sname END, sfees = CASE WHEN %d != -1 THEN %d ELSE sfees END WHERE scource = '%s' ;", id, id, age, age, gender, gender, name, name, fee, fee, cource);


                    break;


                }
                case 6: {
                    System.out.println("enter which fee ");
                    int fee = sc.nextInt();
                    System.out.println("enter 0 for not update and 1 to undate  like [1 ,1 ,0,1,0 ]" +
                            "\n [id,name,age,gender,cource]");
                    int array[] = new int[5];
                    for (int i = 0; i < 5; i++) {
                        array[i] = sc.nextInt();
                    }
                    String cource = "", gender = "",name= "";
                    int age = -1,  id = -1;

                        System.out.println("--------update value ---------");
                        if (array[1] == 1 && name.equals("")) {
                            System.out.printf(" enter field name to be updated");
                            name = sc.next();
                        }
                        if (array[2] == 1 && age == -1) {
                            System.out.printf(" enter field age to be updated");
                            age = sc.nextInt();
                        }
                        if (array[3] == 1 && gender.equals("")) {
                            System.out.printf(" enter field gender to be updated");
                            gender = sc.next();
                        }
                        if (array[4] == 1 && cource.equals("")) {
                            System.out.printf(" enter field cource to be updated");
                            cource = sc.next();
                        }
                        if (array[0] == 1 && id == -1) {
                            System.out.printf(" enter field id to be updated");
                            id = sc.nextInt();
                        }


                    updateQuery = String.format("UPDATE student SET sid = CASE WHEN '%d' != -1 THEN '%d' ELSE sid END, sage = CASE WHEN %d != -1 THEN %d ELSE sage END, sgender = CASE WHEN '%s' != '' THEN '%s' ELSE sgender END, scource = CASE WHEN '%s' != '' THEN '%s' ELSE scource END, sname = CASE WHEN '%s' != '' THEN '%s' ELSE sname END WHERE sfees = %d ;", id, id, age, age, gender, gender, cource, cource, name, name, fee);


                    break;
                }
                default:
                    System.out.println("enter wrong input ");
            }
            PreparedStatement pst = con.prepareStatement(updateQuery);
            pst.executeUpdate();
            System.out.println(" data updated ...");
            Thread.sleep(2000);
            view();
            Thread.sleep(10000);

        }catch (Exception e){
            System.out.println(e);
        }

    }

    void deleteall(){
        try{
            String delallquery = "truncate student";
            PreparedStatement pst = con.prepareStatement(delallquery);
            pst.executeUpdate();
            System.out.println("all data delted ...");

        }catch (Exception e){

        }
    }
    void view(){
        try{
            int id = 2;
           String viewquery = " select * from student; ";
            String cource = "BCA";
          //  String viewquery = " select * from student where scource='"+cource+"'";
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(viewquery);

        while(rs.next())
        {
            System.out.print(" " + rs.getInt(1));
            System.out.print(" " + rs.getString(2));
            System.out.print(" " + rs.getInt(3));
            System.out.print(" " + rs.getString(4));
            System.out.print(" " + rs.getString(5));
            System.out.println(" " + rs.getInt(6));
        }
        Thread.sleep(5000);
        }catch (Exception e){

        }
    }

    public static void main(String[] args) {
        Operation obj = new Operation();
        while (true){
            System.out.println("\npress 1 for insert");
            System.out.println("\npress 2 for delete");
            System.out.println("\npress 3 for delete ALL");
            System.out.println("\npress 4 for update");
            System.out.println("\npress 5 for view");
            System.out.println("\npress 6 for exit");

            System.out.println("enter your choice");
            Scanner sc = new Scanner(System.in);

            int choice = sc.nextInt();

            switch (choice)
            {
                case 1:
                    obj.insert();
                    break;

                case 2:
                    obj.delete();
                    break;
                case 3:
                    obj.deleteall();
                    break;
                case 4:
                    obj.update();
                    break;
                case 5:
                    obj.view();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("wrong choice");
            }
        }
    }
}
