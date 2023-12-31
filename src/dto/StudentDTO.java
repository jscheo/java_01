package dto;

public class StudentDTO {
    private Long id;
    private String studentName;
    private String studentMajor;
    private String studentMobile;
    private static long num = 1L;
    public StudentDTO() {
    }
    public StudentDTO(String studentName, String studentMajor, String studentMobile) {
        this.id = num++;
        this.studentName = studentName;
        this.studentMajor = studentMajor;
        this.studentMobile = studentMobile;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentMajor() {
        return studentMajor;
    }

    public void setStudentMajor(String studentMajor) {
        this.studentMajor = studentMajor;
    }

    public String getStudentMobile() {
        return studentMobile;
    }

    public void setStudentMobile(String studentMobile) {
        this.studentMobile = studentMobile;
    }
    // override는 재정의 overloding 은 이름은 같지만 매개변수가 다르면 그대로 쓸 수 있다는 뜻


    @Override
    public String toString() {
        return "StudentDTO{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                ", studentMajor='" + studentMajor + '\'' +
                ", studentMobile='" + studentMobile + '\'' +
                '}';
    }
}
