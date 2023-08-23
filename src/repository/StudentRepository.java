package repository;

import dto.StudentDTO;
import service.StudentService;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    private final List<StudentDTO> studentDTOList = new ArrayList<>();
    public boolean save(StudentDTO studentDTO) {
        // id 값을 하나씩 증가 시켜 함께 저장
        // (현재 리스트에 저장된 학생수 가져오고 1 증가하여 저장)
        int size = studentDTOList.size();
        studentDTO.setId((long) (size+1));
        // 리스트에 신규학생 추가
        return studentDTOList.add(studentDTO);
    }

    public List<StudentDTO> findAll(){
        return studentDTOList;
    }

}
