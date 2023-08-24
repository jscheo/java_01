package repository;

import dto.StudentDTO;
import service.StudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentRepository {
    private final List<StudentDTO> studentDTOList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    public boolean save(StudentDTO studentDTO) {
        // id 값을 하나씩 증가 시켜 함께 저장
        // (현재 리스트에 저장된 학생수 가져오고 1 증가하여 저장)
//        int size = studentDTOList.size();
//        studentDTO.setId((long) (size+1));
//        // 리스트에 신규학생 추가
        return studentDTOList.add(studentDTO);
    }

    public List<StudentDTO> findAll(){
        return studentDTOList;
    }

    public StudentDTO findById(long id) {
        //forEach
        for(StudentDTO studentDTO: studentDTOList){
            // id와 일치하는 결과를 찾으면 해당 DTO 객체를 리턴
            if(id == studentDTO.getId()){
                return studentDTO;
            }
        }
        // for
//        for(int i = 0; i< studentDTOList.size(); i++){
//            //     : studentDTO = studentDTOList.get(i)
//            if(id == studentDTOList.get(i).getId()){
//                return studentDTOList.get(i);
//            }
//        }
        // 반복문을 돌려서 일치하는 결과가 없으면 null 리턴 (없으면 오류남)
        // 리턴타입이 있다는건 리턴값이 무조건 있어야한다. 각 상황에 따라 다 줘야함
        return null;
    }

    public void delete(long deleteId) {
//        for(int i = 0; i < studentDTOList.size(); i++){
//            if(deleteId==studentDTOList.get(i).getId()){
//                studentDTOList.remove(i);
//            }
//        }
        for(StudentDTO studentDTO: studentDTOList){
            if(deleteId == studentDTO.getId()){
                studentDTOList.remove(studentDTO);
                System.out.println("삭제완료");
            }
        }
    }

    public void update(long updateId, String updateMobile) {
        for(StudentDTO studentDTO: studentDTOList){
            if(updateId == studentDTO.getId()){
                studentDTO.setStudentMobile(updateMobile);
                System.out.println("수정완료");
            }
        }
    }
}
