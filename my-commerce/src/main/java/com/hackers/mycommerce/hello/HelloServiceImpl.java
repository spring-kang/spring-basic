package com.hackers.mycommerce.hello;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HelloServiceImpl implements HelloService{
    private final HelloRepository helloRepository;
    private final PlatformTransactionManager transactionManager;
    @Override
    public HelloStudentDto getStudent(String name) {
        Optional<HelloStudent> student = helloRepository.findByName(name);
        return HelloStudentDto.from(student.get());
    }

    @Override
    public HelloStudentDto saveStudent(String name) {
        HelloStudent student = new HelloStudent();
        student.setName(name);

        helloRepository.save(student);

        return HelloStudentDto.from(student);
    }

}
