package service;

import dto.StudentDTO;
import repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentService {
    // 학생등록 매서드
    // 매개변수 없음
    // 리턴 없음
    // 매서드 이름: save()
    // 실행내용
    // 이름(studentName), 학과(StudentMajor), 전화번호(studentMobile)를 입력받고
    // 입력값을 DTO 객체에 담아서 StudentRepository의 save() 매서드로 전달
    Scanner scanner = new Scanner(System.in);
    StudentRepository studentRepository = new StudentRepository();

    public void save(){
        StudentDTO studentDTO = new StudentDTO();

        System.out.println("이름을 입력하세요>");
        String name = scanner.nextLine();
        studentDTO.setStudentName(name);
        System.out.println("학과를 입력하세요>");
        String dept = scanner.nextLine();
        studentDTO.setStudentMajor(dept);
        System.out.println("전화번호를 입력하세요>");
        String phone = scanner.nextLine();
        studentDTO.setStudentMobile(phone);
        System.out.println(studentDTO.toString());

        // DTO 객체를 StudentRepository의 save() 매서드로 전달하여 리턴을 boolean으로 받음.
        boolean result = studentRepository.save(studentDTO);
        // repository의 save()내용
        // 넘겨받은 dto 객체를 리스트에 추가하고 추가하면 true 리턴
        if(result){
            System.out.println("등록성공");
        }else{
            System.out.println("등록 실패");
        }
    }
    /*
        findall() 매서드
        Main에서 3번 선택시 호출되는 매서드
        매개변수 리턴 없음.
        실행내용
            - Repository의 findAll 매서드를 호출하여 리스트를 리턴받음.
            - 리턴받은 리스트에 담긴 데이터를 for 문을 이용하여 출력함.
    * */
    public void findall(){
        // - Repository의 findAll 메서드를 호출하여 리스트를 리턴받음.
        List<StudentDTO> studentDTOList = studentRepository.findAll();
        for (StudentDTO studentDTO: studentDTOList) {
            System.out.println("studentDTO = " + studentDTO);
        }
//        for (int i=0; i<studentDTOList.size(); i++) {
//            System.out.println(studentDTOList.get(i));
//        }
    }
}
