package com.krishna.fullstackbackend.services;

import com.krishna.fullstackbackend.exception.StudentAlreadyExistsExeption;
import com.krishna.fullstackbackend.exception.StudentNotFoundExeption;
import com.krishna.fullstackbackend.model.Student;
import com.krishna.fullstackbackend.repositor.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService implements IStudentService {

    private final StudentRepository studentRepository;
    @Override
    public List<Student> getStudent() {
        return studentRepository.findAll();
    }
    @Override
    public Student addStudent(Student student) {
        if(studentAlreadyExixsts(student.getEmail())){
            throw new StudentAlreadyExistsExeption(student.getEmail()+"already exist!!");
        }
        return studentRepository.save(student);
    }


    @Override
    public Student updateStudent(Student student, Long id) {
        return studentRepository.findById(id).map(st ->{
            st.setFirstName(student.getFirstName());
            st.setLastName(student.getLastName());
            st.setEmail(student.getEmail());
            st.setDepartment(student.getDepartment());
            return studentRepository.save(st);
        } ).orElseThrow(() -> new StudentNotFoundExeption("sorry,this could not be found"));
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundExeption("sorry,no student found with id:" +id));
    }

    @Override
    public void deleteStudent(Long id) {
        if(!studentRepository.existsById(id)){
            throw new StudentNotFoundExeption("sorry ,student not found");
        }
        studentRepository.deleteById(id);
    }
    private boolean studentAlreadyExixsts(String email) {
        return studentRepository.findByEmail(email).isPresent();
    }
}
