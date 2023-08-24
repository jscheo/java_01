package main;

import dto.StudentDTO;
import org.w3c.dom.ls.LSOutput;
import service.StudentService;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.util.*;
import java.sql.*;

public class MainClass {
    //스캐너를 이용하여
    //1. 학생등록
    //2. 학생상세조회
    //3. 학생목록조회
    // 를 선택하는 코드를 작성합니다.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentService studentService =new StudentService();

       boolean run = true;
       while(run){
           System.out.println("---------------메뉴선택-----------------");
           System.out.println("1.학생등록 2. 학생상세조회 3.학생목록조회 4.정보수정 5.삭제 0.종료");
           System.out.println("---------------------------------------");
           System.out.print("숫자입력> ");
           int sel = scanner.nextInt();

           if(sel == 1){
               System.out.println("학생등록메뉴");
               studentService.save();
           }else if(sel == 2){
               System.out.println("학생상세조회");
               /*
                    service의 findById 매서드를 호출함.

                    service의 findById
                    - id값을 입력받고 repository의 findById로 id값을 넘김
                    - 입력받은 id에 해당하는 학생 데이터를 리턴받음.
                    - 리턴받은 값을 출력함.
               * */
               studentService.findById();
           }else if(sel == 3){
               System.out.println("학생목록조회");
               studentService.findAll();
           }else if(sel == 4) {
               System.out.println("정보수정");
               studentService.update();
               studentService.findAll();
           }else if(sel == 5){
               System.out.println("삭제");
               studentService.delete();
               studentService.findAll();
           }else{
               System.out.println("종료");
               run=false;
           }
       }

    }



}
