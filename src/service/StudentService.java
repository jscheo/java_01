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
//    StudentDTO studentDTO = new StudentDTO();
    public void save(){
        System.out.println("이름: ");
        String studentName = scanner.next();
        System.out.println("학과: ");
        String studentMajor = scanner.next();
        System.out.println("전화번호: ");
        String studentMobile = scanner.next();
        // DTO 객체
//        StudentDTO studentDTO = new StudentDTO();
//        studentDTO.setStudentName(studentName);
//        studentDTO.setStudentMajor(studentMajor);
//        studentDTO.setStudentMobile(studentMobile);
        StudentDTO studentDTO = new StudentDTO(studentName, studentMajor, studentMobile);


        // DTO 객체를 StudentRepository의 save() 매서드로 전달하여 리턴을 boolean으로 받음.
        boolean result = studentRepository.save(studentDTO);
        // repository의 save()내용
        // 넘겨받은 dto 객체를 리스트에 추가하고 추가하면 true 리턴
        if(result){
            System.out.print("등록성공");
        }else{
            System.out.print("등록 실패");
        }
        System.out.println(studentDTO);
    }
    /*
        findall() 매서드
        Main에서 3번 선택시 호출되는 매서드
        매개변수 리턴 없음.
        실행내용
            - Repository의 findAll 매서드를 호출하여 리스트를 리턴받음.
            - 리턴받은 리스트에 담긴 데이터를 for 문을 이용하여 출력함.
    * */
    public void findAll(){
        // - Repository의 findAll 메서드를 호출하여 리스트를 리턴받음.
        List<StudentDTO> studentDTOList = studentRepository.findAll();
        for (StudentDTO studentDTO: studentDTOList) {
            System.out.println("studentDTO = " + studentDTO);
        }
//        for (int i=0; i<studentDTOList.size(); i++) {
//            System.out.println(studentDTOList.get(i));
//        }
    }
    /*
                   service의 findById 매서드를 호출함.

                   service의 findById
                   - id값을 입력받고 repository의 findById로 id값을 넘김
                   - 입력받은 id에 해당하는 학생 데이터를 리턴받음.
                   - 리턴받은 값을 출력함.
              * */
    public void findById(){
        System.out.println("StudentService.findById");
        //조회기능 선택시 목록을 먼저 보여줌
        // 서비스 클래스에서 정의한 findAll() 매서드 호출
        findAll();
        // 조회할 ID 입력
        System.out.print("아이디를 입력하세요>");
        long id = scanner.nextLong();
        // 입력받은 id를 repository로 넘겨서 DTO 객체를 리턴받음.
        StudentDTO studentDTO = studentRepository.findById(id);
        // 조회 결과 출력
        if(studentDTO== null){
            System.out.println("찾는 정보가 없습니다.");
        }else{
            System.out.println("조회 학생 정보:" + studentDTO);
        }
        
    }

    public void delete() {
        findAll();
        System.out.print("삭제할 id:");
        long deleteId = scanner.nextLong();
        studentRepository.delete(deleteId);
    }

    public void update() {
        findAll();
        System.out.print("수정할 id");
        long updateId = scanner.nextLong();
        StudentDTO studentDTO =studentRepository.findById(updateId);
        if(studentDTO == null){
            System.out.println("해당정보가 없습니다.");
        }else{
            System.out.println("수정할 전화번호:");
            String updateMobile = scanner.next();
            studentRepository.update(updateId, updateMobile);
        }
    }
}
